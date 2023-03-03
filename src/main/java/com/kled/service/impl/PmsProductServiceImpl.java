package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.dao.*;
import com.kled.dto.PmsProductParam;
import com.kled.dto.PmsProductQueryParam;
import com.kled.dto.PmsProductResult;
import com.kled.mbg.mapper.PmsProductMapper;
import com.kled.mbg.model.PmsProduct;
import com.kled.mbg.model.PmsProductExample;
import com.kled.mbg.model.PmsSkuStock;
import com.kled.service.PmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class PmsProductServiceImpl implements PmsProductService {
    private static final Logger  LOGGER = LoggerFactory.getLogger(PmsProductServiceImpl.class);
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsMemberPriceDao memberPriceDao;
    @Autowired
    private PmsProductLadderDao productLadderDao;
    @Autowired
    private PmsProductFullReductionDao productFullReductionDao;
    @Autowired
    private PmsProductAttributeValueDao productAttributeValueDao;
    @Autowired
    private CmsSubjectProductRelationDao subjectProductRelationDao;
    @Autowired
    private CmsPrefrenceAreaProductRelationDao prefrenceAreaProductRelationDao;
    @Autowired
    private PmsProductDao productDao;

    @Override
    public int create(PmsProductParam productParam) {
        int count;
        //创建商品
        PmsProductParam product = productParam;
        product.setId(null);
        productMapper.insertSelective(product);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        relateAndInsertList(memberPriceDao,productParam.getMemberPriceList(),productId);
        //阶梯价格
        relateAndInsertList(productLadderDao,productParam.getProductLadderList(),productId);
        //满减价格
        relateAndInsertList(productFullReductionDao,productParam.getProductFullReductionList(),productId);
        //处理sku的编码
        handleSkuStockCode(productParam.getSkuStockList(),productId);
        //添加商品参数，添加自定义商品规格
        relateAndInsertList(productAttributeValueDao,productParam.getProductAttributeValueList(),productId);
        //关联主题
        relateAndInsertList(subjectProductRelationDao,productParam.getSubjectProductRelationList(),productId);
        //关联优选
        relateAndInsertList(prefrenceAreaProductRelationDao,productParam.getPrefrenceAreaProductRelationList(),productId);
        count = 1;
        return count;
    }
    
    private void handleSkuStockCode(List<PmsSkuStock> skuStockList,Long productId){
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            PmsSkuStock skuStock = skuStockList.get(i);
            if (StrUtil.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04",productId));
                //三位索引id
                sb.append(String.format("%03",i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }
    

    @Override
    public List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (productQueryParam.getPublishStatus()!=null){
            criteria.andPublishStatusEqualTo(productQueryParam.getPublishStatus());
        }
        if(productQueryParam.getVerifyStatus()!=null){
            criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
        }
        if(!StrUtil.isEmpty(productQueryParam.getKeyword())){
            criteria.andNameLike("%"+productQueryParam.getKeyword()+"%");
        }
        if(!StrUtil.isEmpty(productQueryParam.getProductSn())){
            criteria.andProductSnEqualTo(productQueryParam.getProductSn());
        }
        if(productQueryParam.getBrandId()!=null){
            criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
        }
        if(productQueryParam.getProductCategoryId()!=null){
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(productExample);
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        PmsProduct record = new PmsProduct();
        record.setPublishStatus(publishStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        PmsProduct record = new PmsProduct();
        record.setNewStatus(newStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        PmsProduct record = new PmsProduct();
        record.setRecommandStatus(recommendStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record,example);
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return productDao.getUpdateInfo(id);
    }

    /**
     * 建立和插入关系表操作
     * @param dao           可操作的DAO
     * @param dataList      要插入的数据
     * @param productId     建立关系的id
     */
    private void relateAndInsertList(Object dao,List dataList,Long productId){
        try{
            if(CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item,(Long)null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item,productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao,dataList);
        }catch (Exception e){
            LOGGER.warn("创建产品出错：{}",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
