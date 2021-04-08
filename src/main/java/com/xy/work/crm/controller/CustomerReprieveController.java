package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.crm.query.CustomerReprieveQuery;
import com.xy.work.crm.service.CustomerReprieveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;


@Controller
@RequestMapping("customer_reprieve")
public class CustomerReprieveController extends BaseController {

    @Resource
    private CustomerReprieveService customerReprieveService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryByParams(CustomerReprieveQuery customerReprieveQuery){
        return customerReprieveService.queryByParams(customerReprieveQuery);
    }
}
