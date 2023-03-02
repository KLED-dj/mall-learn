package com.kled.service;

import com.kled.dto.PmsProductQueryParam;
import com.kled.mbg.model.PmsProduct;

import java.util.List;

public interface PmsProductService {
    

    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageSize, Integer pageNum);
}
