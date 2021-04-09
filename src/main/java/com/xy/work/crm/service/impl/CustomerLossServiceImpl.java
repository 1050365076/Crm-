package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerLossMapper;
import com.xy.work.crm.query.CustomerLossQuery;
import com.xy.work.crm.service.CustomerLossService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.CustomerLoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerLossServiceImpl extends BaseService<CustomerLoss,Integer> implements CustomerLossService{

    @Autowired
    private CustomerLossMapper customerLossMapper;


    @Override
    public Map<String, Object> queryByParams(CustomerLossQuery customerLossQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerLossQuery.getPage(),customerLossQuery.getLimit());
        PageInfo<CustomerLoss> pageInfo = new PageInfo<CustomerLoss>(customerLossMapper.selectByParams(customerLossQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public void updateCustomerLossStateById(Integer id, String lossReason) {
      CustomerLoss customerLoss = selectByPrimaryKey(id);
        AssertUtil.isTrue(customerLoss == null,"待流失的客户记录不存在！");
        customerLoss.setState(1);
        customerLoss.setLossReason(lossReason);
        customerLoss.setConfirmLossTime(new Date());
        customerLoss.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(customerLoss)<1,"确认流失失败！");
    }
}
