package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;
import com.xy.work.crm.query.CustomerOrderQuery;
import com.xy.work.crm.service.CustomerOrderService;
import com.xy.work.crm.vo.CustomerOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("order")
public class CustomerOrderController extends BaseController {

    @Resource
    private CustomerOrderService customerOrderService;


    @RequestMapping("list")
    @ResponseBody
    private Map<String,Object> queryCustomerOrderByParams(CustomerOrderQuery customerOrderQuery){
        return  customerOrderService.querybyParams(customerOrderQuery);
    }



}

