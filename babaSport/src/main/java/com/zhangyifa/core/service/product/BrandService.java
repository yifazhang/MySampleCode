package com.zhangyifa.core.service.product;

import com.zhangyifa.core.pojo.EUDataGridResult;

/**
 * Created by zhangyifa on 11/25/17.
 */
public interface BrandService {

    EUDataGridResult getItemList(String name, Boolean isDisplay, int page, int rows);

}
