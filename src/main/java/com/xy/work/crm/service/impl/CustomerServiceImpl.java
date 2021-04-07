package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerMapper;
import com.xy.work.crm.dao.CustomerOrderMapper;
import com.xy.work.crm.query.CustomerQuery;
import com.xy.work.crm.service.CustomerService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.utils.PhoneUtil;
import com.xy.work.crm.vo.Customer;
import com.xy.work.crm.vo.CustomerOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl extends BaseService<Customer,Integer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Override
    public Map<String, Object> queryCustomerByParams(CustomerQuery customerQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerQuery.getPage(),customerQuery.getLimit());
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(selectByParams(customerQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }


    @Override
    public void saveCustomer(Customer customer) {
        /**
         * 1.参数校验
         *   cusName 非空唯一
         *   phone 非空，合法
         *   fr 法人 非空
         * 2.默认参数
         *  is_valid
         *  createDate
         *  updateDate
         *  state 流失状态 0-false未流失 1-true流失
         * 3.提交
         */
        checkParams(customer.getName(),customer.getPhone(),customer.getFr());
        Customer temp  = customerMapper.queryCustomerByCusName(customer.getName());
        AssertUtil.isTrue(temp !=null ,"客户名已经存在！");
        customer.setIsValid(1);
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
        customer.setState(0);
        //设置客户编号
        String khno = "KH_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        customer.setKhno(khno);
        AssertUtil.isTrue(insertSelective(customer)<1,"客户记录添加失败！");
    }

    private void checkParams(String name, String phone, String fr) {
        AssertUtil.isTrue(StringUtils.isBlank(name),"请指定客户名称！");
        AssertUtil.isTrue(!(PhoneUtil.isMobile(phone)),"请输入真确的手机号！");
        AssertUtil.isTrue(StringUtils.isBlank(fr),"法人不能为空！");

    }


    @Override
    public void updateCustomer(Customer customer) {

        /**
         * 1.参数校验
         *   id存在
         *   cusName 非空唯一
         *   phone 非空，合法
         *   fr 法人 非空
         * 2.默认参数
         *  is_valid
         *  createDate
         *  updateDate
         *  state 流失状态 0-false未流失 1-true流失
         * 3.提交
         */
        Customer temp =  selectByPrimaryKey(customer.getId());

        AssertUtil.isTrue(temp == null ,"待更新的记录不存在!");
        checkParams(customer.getName(),customer.getPhone(),customer.getFr());

        temp  = customerMapper.queryCustomerByCusName(customer.getName());
        AssertUtil.isTrue(temp !=null && !(temp.getId().equals(customer.getId() )) ,"客户名已经存在！");
        customer.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(customer)<1,"客户记录更新失败！");
    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = selectByPrimaryKey(id);
        AssertUtil.isTrue(customer ==null,"待删除的客户记录不存在！");
        customer.setIsValid(0);
        AssertUtil.isTrue(updateByPrimaryKeySelective(customer)<1,"删除客户记录失败！");

    }




}
