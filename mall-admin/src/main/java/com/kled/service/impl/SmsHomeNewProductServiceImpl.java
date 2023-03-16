package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.mbg.mapper.SmsHomeNewProductMapper;
import com.kled.mbg.model.SmsHomeNewProduct;
import com.kled.mbg.model.SmsHomeNewProductExample;
import com.kled.service.SmsHomeNewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {
    @Autowired
    private SmsHomeNewProductMapper productMapper;

    @Override
    public List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        SmsHomeNewProductExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(productName)){
            criteria.andProductNameLike(productName);
        }
        if (recommendStatus!=null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public int create(List<SmsHomeNewProduct> homeNewProductList) {
        for (SmsHomeNewProduct smsHomeNewProduct : homeNewProductList) {
            smsHomeNewProduct.setRecommendStatus(1);
            smsHomeNewProduct.setSort(0);
            productMapper.insert(smsHomeNewProduct);
        }
        return homeNewProductList.size();
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeNewProduct record = new SmsHomeNewProduct();
        record.setRecommendStatus(recommendStatus);
        return productMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return productMapper.updateByPrimaryKeySelective(homeNewProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.deleteByExample(example);
    }
}
