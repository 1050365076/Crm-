package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.CustomerMapper;
import com.xy.work.crm.dao.CustomerServerMapper;
import com.xy.work.crm.dao.UserMapper;
import com.xy.work.crm.enums.CustomerServeStatus;
import com.xy.work.crm.query.CustomerServeQuery;
import com.xy.work.crm.service.CustomerServeService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.utils.LoginUserUtil;
import com.xy.work.crm.vo.Customer;
import com.xy.work.crm.vo.CustomerServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServeServiceImpl extends BaseService<CustomerServer,Integer> implements CustomerServeService {

    @Autowired
    private CustomerServerMapper customerServerMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> queryByParams(CustomerServeQuery serveQuery) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(serveQuery.getPage(),serveQuery.getLimit());
        PageInfo<CustomerServer> pageInfo = new PageInfo<CustomerServer>(selectByParams(serveQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @Override
    public void saveCustomerServe(CustomerServer customerServer) {
        /**
         * 1.参数校验
         *     客户名  非空
         *     服务类型 非空
         *     服务请求内容 非空
         * 2.默认参数设置
         *    state  已创建 fw_001
         *    is_valid create_date updateDate
         * 3.执行添加
         */
       AssertUtil.isTrue(StringUtils.isBlank(customerServer.getCustomer()),"请指定客户！");
       AssertUtil.isTrue(StringUtils.isBlank(customerServer.getServeType()),"请指定服务的类型！");
       AssertUtil.isTrue(StringUtils.isBlank(customerServer.getServiceRequest()),"请指定服务请求内容！");
       Customer customer = customerMapper.queryCustomerByCusName(customerServer.getCustomer());
       AssertUtil.isTrue(customer == null ,"客户记录不存在！");
       customerServer.setCreateDate(new Date());
       customerServer.setState(CustomerServeStatus.CREATE.getState());
       customerServer.setUpdateDate(new Date());
       customerServer.setIsValid(1);
       AssertUtil.isTrue(insertSelective(customerServer)<1,"服务记录创建失败！");
    }



    @Override
    public void updateCustomerServe(CustomerServer customerServer) {
        /**
         * 1.参数校验
         *     id存在
         *   1.1.如果状态为分配状态  fw_002
         *    设置服务更新时间，分配时间，分配人
         *   1.2如果状态为服务处理 fw_003
         *     服务处理时间，服务更新时间，服务处理内容非空
         *   1.3如果服务状态为反馈状态 fw_004
         *     服务反馈内容 非空，服务反馈满意度 非空 更新时间 设置服务状态为归档状态
         * 3.执行更新
         */
        CustomerServer temp = selectByPrimaryKey(customerServer.getId());
        AssertUtil.isTrue(temp == null ,"待更新的服务记录不存在！");
        if (customerServer.getState().equals(CustomerServeStatus.ASSIGNED.getState())) {
            //执行分配
            AssertUtil.isTrue( null == userMapper.selectByPrimaryKey(Integer.parseInt(customerServer.getAssigner())),"待分配的用户不存在！");
            customerServer.setAssignTime(new Date());
        }else if(customerServer.getState().equals(CustomerServeStatus.PROCED.getState())){
            AssertUtil.isTrue(StringUtils.isBlank(customerServer.getServiceProce()),"请指定处理内容！");
            customerServer.setServiceProceTime(new Date());
        } else if (customerServer.getState().equals(CustomerServeStatus.FEE_BACK.getState())) {
            AssertUtil.isTrue(StringUtils.isBlank(customerServer.getServiceProceResult()),"请指定反馈内容！");
            AssertUtil.isTrue(StringUtils.isBlank(customerServer.getMyd()),"请指定反馈满意度！");
            customerServer.setState(CustomerServeStatus.ARCHIVED.getState());
        }
        customerServer.setUpdateDate(new Date());
        AssertUtil.isTrue(updateByPrimaryKeySelective(customerServer)<1,"服务记录更新失败！");
    }
}
