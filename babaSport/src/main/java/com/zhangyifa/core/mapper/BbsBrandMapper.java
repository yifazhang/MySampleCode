package com.zhangyifa.core.mapper;

import com.zhangyifa.core.pojo.BbsBrand;
import com.zhangyifa.core.pojo.BbsBrandExample;
import com.zhangyifa.core.pojo.TestTb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsBrandMapper {
    int countByExample(BbsBrandExample example);

    int deleteByExample(BbsBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BbsBrand record);

    int insertSelective(BbsBrand record);

    List<BbsBrand> selectByExample(BbsBrandExample example);

    BbsBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BbsBrand record, @Param("example") BbsBrandExample example);

    int updateByExample(@Param("record") BbsBrand record, @Param("example") BbsBrandExample example);

    int updateByPrimaryKeySelective(BbsBrand record);

    int updateByPrimaryKey(BbsBrand record);

    /**
     * Created by zyf on 2017/11/24.
     */
    interface TestTbDao {
        public void addTestTb(TestTb testTb);

        public List<TestTb> listTb();
    }
}