package com.kled.service;

import com.kled.dto.PmsBrandParam;
import com.kled.mbg.model.PmsBrand;

import java.util.List;


public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id,PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum,int pageSize);

    PmsBrand getBrand(Long id);

    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);

    int updateShowStatus(List<Long> ids,Integer showStatus);
}
