package com.xy.work.crm.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xy.work.base.BaseController;
import com.xy.work.crm.query.CustomerLossQuery;
import com.xy.work.crm.service.CustomerLossService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("customer_loss")
public class CustomerLossController extends BaseController {
    @Resource
    private CustomerLossService customerLossService;

    @RequestMapping("index")
    public String index(){
        return "customerLoss/customer_loss";
    }






    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object>queryByParams(CustomerLossQuery customerLossQuery){
        return customerLossService.queryByParams(customerLossQuery);
    }

    @RequestMapping("toCustomerReprPage")
    public String toCustomerReprPage(Integer cusId, Model model){
        model.addAttribute("customerLoss",customerLossService.selectByPrimaryKey(cusId));
        return "customerLoss/customer_rep";
    }

}
