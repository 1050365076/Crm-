package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerLossMapper;
import com.xy.work.crm.dao.CustomerMapper;
import com.xy.work.crm.dao.CustomerOrderMapper;
import com.xy.work.crm.query.CustomerQuery;
import com.xy.work.crm.service.CustomerService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.utils.PhoneUtil;
import com.xy.work.crm.vo.Customer;
import com.xy.work.crm.vo.CustomerLoss;
import com.xy.work.crm.vo.CustomerOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomerServiceImpl extends BaseService<Customer,Integer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerLossMapper customerLossMapper;

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

    @Override
    public void updateCustomerState() {
        /**
         * 流失客户的转移
         *
         * 1.查询流失的客户数据
         * 2.批量添加进入客户流失表
         * 3.批量更新客户流失状态
         * 4.通过定时任务 定时流转客户数据到客户流失表中
         *
         */
        List<Customer> customers = customerMapper.queryLossCustomer();
        if(null != customers && customers.size()>0){
            List<CustomerLoss> customerLossList = new ArrayList<CustomerLoss>();
            List<Integer> lossCusIds = new ArrayList<Integer>();
            customers.forEach(c->{
                CustomerLoss customerLoss = new CustomerLoss();
                //流失状态暂缓 0 1-确流失无价值
                customerLoss.setState(0);
                customerLoss.setCreateDate(new Date());
                customerLoss.setCusManager(c.getCusManager());
                customerLoss.setCusName(c.getName());
                customerLoss.setCusNo(c.getKhno());
                customerLoss.setIsValid(1);
                customerLoss.setUpdateDate(new Date());
                //查询客户最后一次下单时间
                CustomerOrder customerOrder = customerOrderMapper.queryLastCustomerOrderByCusId(c.getId());
                if(null != customerOrder){
                    customerLoss.setLastOrderTime(customerOrder.getOrderDate());
                }
                customerLossList.add(customerLoss);
                lossCusIds.add(c.getId());
            });

            AssertUtil.isTrue(customerLossMapper.insertBatch(customerLossList)!=customerLossList.size(),"客户流转数据失败！");
            AssertUtil.isTrue(customerMapper.updateCustomerStateByIds(lossCusIds)!= lossCusIds.size(),"客户数据流转失败！");
        }



    }

    @Override
    public Map<String, Object> queryCustomerContributionByParams(CustomerQuery customerQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(customerQuery.getPage(),customerQuery.getLimit());
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(customerMapper.queryCustomerContributionByParams(customerQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public Map<String, Object> countCustomerMake() {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> list = customerMapper.countCustomerMake();
        List<String> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        /**
         * result
         *     data1:["大客户"，'合作伙伴']
         *     data2:["10","20"]
         */
        list.forEach(m->{
            data1.add(m.get("level").toString());
            data2.add(Integer.parseInt(m.get("total").toString()));
        });
        result.put("data1",data1);
        result.put("data2",data2);
        return result;
    }

    @Override
    public Map<String, Object> countCustomerMake02() {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> list = customerMapper.countCustomerMake();
        List<String> data1 = new ArrayList<>();
        List<Map<String,Object>> data2= new ArrayList<>();
        /**
         * result
         *     data1:["大客户"，'合作伙伴']
         *     data2:["10","20"]
         */
        list.forEach(m->{
            data1.add(m.get("level").toString());
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("name",m.get("level"));
            tmp.put("value",m.get("total"));
            data2.add(tmp);
        });
        result.put("data1",data1);
        result.put("data2",data2);
        return result;
    }

}
