package com.kled.service.impl;

import com.github.pagehelper.PageHelper;
import com.kled.dao.PmsProductAttributeDao;
import com.kled.dto.ProductAttrInfo;
import com.kled.mbg.mapper.PmsProductAttributeMapper;
import com.kled.mbg.model.PmsProductAttribute;
import com.kled.mbg.model.PmsProductAttributeExample;
import com.kled.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeDao productAttributeDao;
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
