package com.xy.work.crm.controller;



import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.CustomerLossQuery;
import com.xy.work.crm.service.CustomerLossService;
import com.xy.work.crm.service.CustomerReprieveService;
import com.xy.work.crm.vo.CustomerReprieve;
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

    @Resource
    private CustomerReprieveService customerReprieveService;

    @RequestMapping("index")
    public String index(){
        return "customerLoss/customer_loss";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object>queryByParams(CustomerLossQuery customerLossQuery){
        return customerLossService.queryByParams(customerLossQuery);
    }

    @RequestMapping("toCustomerRepPage")
    public String toCustomerReprPage(Integer cusId, Model model){
        model.addAttribute("customerLoss",customerLossService.selectByPrimaryKey(cusId));
        return "customerLoss/customer_rep";
    }

    @RequestMapping("toAddOrUpdateCustomerReprPage")
    public String toAddOrUpdateCustomerReprPage(Integer id,Integer lossId,Model model){
        model.addAttribute("customerRep",customerReprieveService.selectByPrimaryKey(id));
        model.addAttribute("lossId",lossId);
        return "customerLoss/customer_rep_add_update";
    }

    @RequestMapping("updateCustomerLossStateById")
    @ResponseBody
    public ResultInfo updateCustomerLossStateById(Integer id,String lossReason){
        customerLossService.updateCustomerLossStateById(id,lossReason);
        return success("客户流失确认！");
    }



}
