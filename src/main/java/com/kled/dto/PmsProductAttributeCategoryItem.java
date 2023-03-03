package com.kled.dto;

import com.kled.mbg.model.PmsProductAttribute;
import com.kled.mbg.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * 带有属性的商品属性分类
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
