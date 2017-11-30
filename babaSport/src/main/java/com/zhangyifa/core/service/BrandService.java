package com.zhangyifa.core.service;

import com.zhangyifa.core.pojo.BbsBrand;
import com.zhangyifa.core.pojo.EUDataGridResult;

/**
 * Created by zhangyifa on 11/25/17.
 */
public interface BrandService {

    EUDataGridResult getItemList(String name, Boolean isDisplay, int page, int rows);

    void addBrand(BbsBrand brand);
    
    BbsBrand getBrandById(Integer id);

    void updateBrand(BbsBrand brand);
    
    void deleteBrand(Integer id);
    
}
