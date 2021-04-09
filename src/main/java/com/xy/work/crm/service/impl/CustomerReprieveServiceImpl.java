package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerLossMapper;
import com.xy.work.crm.dao.CustomerReprieveMapper;
import com.xy.work.crm.query.CustomerReprieveQuery;
import com.xy.work.crm.service.CustomerReprieveService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.CustomerLoss;
import com.xy.work.crm.vo.CustomerReprieve;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class CustomerReprieveServiceImpl extends BaseService<CustomerReprieve,Integer> implements CustomerReprieveService {

    @Autowired
    private CustomerReprieveMapper customerReprieveMapper;

    @Autowired
    private CustomerLossMapper customerLossMapper;


    @Override
    public Map<String, Object> queryByParams(CustomerReprieveQuery customerReprieveQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerReprieveQuery.getPage(),customerReprieveQuery.getLimit());
        PageInfo<CustomerReprieve> pageInfo = new PageInfo<CustomerReprieve>(selectByParams(customerReprieveQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public void deleteCustomerPer(Integer id) {
        CustomerReprieve customerReprieve  =  selectByPrimaryKey(id);
        if(customerReprieve != null){
            customerReprieve.setIsValid(0);
            AssertUtil.isTrue(updateByPrimaryKeySelective(customerReprieve)<1,"暂缓记录删除失败！");
        }
    }

    @Override
    public void saveCustomerRep(CustomerReprieve customerReprieve) {
        /**
         *1.参数校验
         *  客户流失Id 非空
         *  暂缓错误
         * 2.参数默认值
         *  is_valid
          */
        AssertUtil.isTrue( null == customerReprieve.getLossId() || customerLossMapper.selectByPrimaryKey(customerReprieve.getLossId()) == null,"请指定流失客户的Id");
        AssertUtil.isTrue(StringUtils.isBlank(customerReprieve.getMeasure()),"请指定措施项！");
        customerReprieve.setIsValid(1);
        customerReprieve.setCreateDate(new Date());
        customerReprieve.setUpdateDate(new Date());
        AssertUtil.isTrue(insertSelective(customerReprieve)<1,"暂缓措施添加失败！");
    }

    @Override
    public void updateCustomerRep(CustomerReprieve customerReprieve) {
        /**
         *1.参数校验
         *  id记录必须存在
         *  客户流失Id 非空
         *  暂缓错误
         * 2.参数默认值
         *  is_valid
         */
        AssertUtil.isTrue(selectByPrimaryKey(customerReprieve.getId()) == null,"待更新暂缓记录不存在！");
        AssertUtil.isTrue( null == customerReprieve.getLossId() || customerLossMapper.selectByPrimaryKey(customerReprieve.getLossId()) == null,"请指定流失客户的Id");
        AssertUtil.isTrue(StringUtils.isBlank(customerReprieve.getMeasure()),"请指定措施项！");
        customerReprieve.setIsValid(1);
        customerReprieve.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(customerReprieve)<1,"暂缓措施更新失败！");
    }



}
