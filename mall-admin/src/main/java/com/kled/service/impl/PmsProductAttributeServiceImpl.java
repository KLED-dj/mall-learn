package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.PmsProductAttributeDao;
import com.kled.dto.PmsProductAttributeParam;
import com.kled.dto.ProductAttrInfo;
import com.kled.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.kled.mbg.mapper.PmsProductAttributeMapper;
import com.kled.mbg.model.PmsProductAttribute;
import com.kled.mbg.model.PmsProductAttributeCategory;
import com.kled.mbg.model.PmsProductAttributeExample;
import com.kled.service.PmsProductAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeDao productAttributeDao;
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public int create(PmsProductAttributeParam pmsProductAttributeParam) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeParam,pmsProductAttribute);
        int count = productAttributeMapper.insertSelective(pmsProductAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        if(pmsProductAttribute.getType()==0){
            productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount()+1);
        }else if(pmsProductAttribute.getType()==1){
            productAttributeCategory.setParamCount(productAttributeCategory.getParamCount()+1);
        }
        productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id, PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        pmsProductAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam,pmsProductAttribute);
        return productAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        PmsProductAttribute pmsProductAttribute = productAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = pmsProductAttribute.getType();
        PmsProductAttributeCategory pmsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = productAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if (type==0){
            if (pmsProductAttributeCategory.getAttributeCount()>=count){
                pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount()-count);
            }else {
                pmsProductAttributeCategory.setAttributeCount(0);
            }
        }else if (type==1){
            if(pmsProductAttributeCategory.getParamCount()>=count){
                pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount()-count);
            }else{
                pmsProductAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(example);
    }

    @Override
    public List<ProductAttrInfo> getProductAttributeInfo(Long productCategoryId) {
        return productAttributeDao.getProductAttrInfo(productCategoryId);
    }
}
