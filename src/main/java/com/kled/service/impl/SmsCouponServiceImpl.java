package com.kled.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.kled.dao.SmsCouponDao;
import com.kled.dao.SmsCouponProductCategoryRelationDao;
import com.kled.dao.SmsCouponProductRelationDao;
import com.kled.dto.SmsCouponParam;
import com.kled.mbg.mapper.SmsCouponMapper;
import com.kled.mbg.model.SmsCoupon;
import com.kled.mbg.model.SmsCouponExample;
import com.kled.mbg.model.SmsCouponProductCategoryRelation;
import com.kled.mbg.model.SmsCouponProductRelation;
import com.kled.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsCouponServiceImpl implements SmsCouponService {
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponProductRelationDao productRelationDao;
    @Autowired
    private SmsCouponProductCategoryRelationDao productCategoryRelationDao;
    @Autowired
    private SmsCouponDao couponDao;
    
    @Override
    public List<SmsCoupon> list(Integer pageSize, Integer pageNum, String name, Integer type) {
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if(!StrUtil.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if(type!=null){
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public int create(SmsCouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠券表
        int count = couponMapper.insert(couponParam);
        //插入优惠券和商品关系表
        if (couponParam.getUseType().equals(2)){
            for (SmsCouponProductRelation productRelation : couponParam.getProductRelationList()) {
                productRelation.setCouponId(couponParam.getId());
            }
            productRelationDao.insertList(couponParam.getProductRelationList());
        }
        //插入优惠券和商品分类关系表
        if (couponParam.getUseType().equals(1)){
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            productCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }
}
