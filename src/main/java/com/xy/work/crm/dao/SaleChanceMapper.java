package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.SaleChance;


public interface SaleChanceMapper extends BaseMapper<SaleChance,Integer> {

    Integer deleteByPrimaryKey(Integer id);

    int insert(SaleChance record);

    Integer insertSelective(SaleChance record);

    SaleChance selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(SaleChance record);

    int updateByPrimaryKey(SaleChance record);


}
