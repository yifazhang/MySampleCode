package com.zhangyifa.core.service.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyifa.core.mapper.BbsBrandMapper;
import com.zhangyifa.core.pojo.BbsBrand;
import com.zhangyifa.core.pojo.BbsBrandExample;
import com.zhangyifa.core.pojo.BbsBrandExample.Criteria;
import com.zhangyifa.core.pojo.EUDataGridResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyifa on 11/25/17.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BbsBrandMapper brandMapper;

    @Override
    public EUDataGridResult getItemList(String name, Boolean isDisplay, int page, int rows) {
        //查询内容
        BbsBrandExample example = new BbsBrandExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameEqualTo(name);
        }
        criteria.andIsDisplayEqualTo(isDisplay);
        //分页处理
        PageHelper.startPage(page, rows);

        List<BbsBrand> list = brandMapper.selectByExample(example);
        //返回对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);

        PageInfo<BbsBrand> pageInfo = new PageInfo<BbsBrand>(list);
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        result.setPageSize(rows);
        return result;
    }

	@Override
	public void addBrand(BbsBrand brand) {
		brandMapper.insert(brand);
	}
}
