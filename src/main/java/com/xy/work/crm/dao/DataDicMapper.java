package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.vo.DataDic;

import java.util.List;

public interface DataDicMapper extends BaseMapper<DataDic,Integer> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(DataDic record);

    Integer insertSelective(DataDic record);

    DataDic selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);

    List<DataDic> queryDataDicByDataDicName(String dataDicName);
}
