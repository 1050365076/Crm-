package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.query.DataDicQuery;
import com.xy.work.crm.vo.DataDic;

import java.util.Map;

public interface DataDicService extends BaseMapper<DataDic,Integer> {

    Map<String,Object> queryDataDicByParams(DataDicQuery dataDicQuery);

    void saveDataDic(DataDic dataDic);

    void updateDataDic(DataDic dataDic);

    void deleteDataDic(Integer id);
}
