package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.DataDicMapper;
import com.xy.work.crm.query.DataDicQuery;
import com.xy.work.crm.service.DataDicService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.DataDic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDicServiceImpl extends BaseService<DataDic,Integer> implements DataDicService {

    @Autowired
    private DataDicMapper dataDicMapper;

    @Override
    public Map<String, Object> queryDataDicByParams(DataDicQuery dataDicQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(dataDicQuery.getPage(),dataDicQuery.getLimit());
        PageInfo<DataDic> pageInfo = new PageInfo<DataDic>(selectByParams(dataDicQuery));
        map.put("msg","");
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @Override
    public void saveDataDic(DataDic dataDic) {
        /**
         * 1.参数校验
         * 2.默认值设置
         * 3.提交添加
         */
        AssertUtil.isTrue(StringUtils.isBlank(dataDic.getDataDicName()),"请输入字典类型名称！");
        AssertUtil.isTrue(StringUtils.isBlank(dataDic.getDataDicValue()),"请输入字典值！");
        List<DataDic> dataDics = dataDicMapper.queryDataDicByDataDicName(dataDic.getDataDicName());
        dataDics.forEach(d->{
            AssertUtil.isTrue(dataDic.getDataDicValue().equals(d.getDataDicValue()),"同一类型字典下值已存在！");
        });
        dataDic.setCreateDate(new Date());
        dataDic.setUpdateDate(new Date());
        dataDic.setIsValid((byte)1);
        AssertUtil.isTrue(insertSelective(dataDic)<1,"字典添加失败!");
    }

    @Override
    public void updateDataDic(DataDic dataDic) {
        /**
         * 1.参数校验
         * 2.默认值设置
         * 3.提交添加
         */
        AssertUtil.isTrue(selectByPrimaryKey(dataDic.getId())==null,"待修改的字典记录不存在！");
        AssertUtil.isTrue(StringUtils.isBlank(dataDic.getDataDicValue()),"请输入字典值！");
        List<DataDic> dataDics = dataDicMapper.queryDataDicByDataDicName(dataDic.getDataDicName());
        dataDics.forEach(d->{
            AssertUtil.isTrue(dataDic.getDataDicValue().equals(d.getDataDicValue()),"同一类型字典下值已存在！");
        });
        dataDic.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(dataDic)<1,"字典添加失败!");
    }

    @Override
    public void deleteDataDic(Integer id) {
       AssertUtil.isTrue(id == null ,"待删除的字典记录不存在！");
       AssertUtil.isTrue(deleteByPrimaryKey(id)<1,"删除字典记录失败！");
    }
}
