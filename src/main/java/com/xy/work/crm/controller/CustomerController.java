package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.CustomerQuery;
import com.xy.work.crm.service.CustomerOrderService;
import com.xy.work.crm.service.CustomerService;
import com.xy.work.crm.vo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;


@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerOrderService customerOrderService;

    @RequestMapping("index")
    public String index(){
        return "customer/customer";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCustomerByParams(CustomerQuery customerQuery){
        return customerService.queryCustomerByParams(customerQuery);
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return success("添加客户记录成功！");
    }
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return success("更新客户记录成功！");
    }

    @RequestMapping("addOrUpdatePage")
    public String addOrUpdatePage(Integer id, Model model){
        model.addAttribute("customer",customerService.selectByPrimaryKey(id));
        return "customer/add_update";
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteCustomer(Integer id){
        customerService.deleteCustomer(id);
        return success("客户记录删除成功!") ;
    }

    @RequestMapping("orderInfoPage")
    public String orderInfoPage(Integer cid,Model model){
        model.addAttribute("customer",customerService.selectByPrimaryKey(cid));
        return  "customer/customer_order";
    }

    @RequestMapping("orderDetailPage")
    public String orderDetailPage(Integer orderId,Model model){
        model.addAttribute("order",customerOrderService.queryCustomerOrderByOrderId(orderId));
        return "customer/customer_order_detail";
    }


    @RequestMapping("queryCustomerContributionByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerContributionByParams(CustomerQuery customerQuery){
        return customerService.queryCustomerContributionByParams(customerQuery);
    }

    @RequestMapping("countCustomerMake")
    @ResponseBody
    public Map<String,Object> countCustomerMake(){
        return customerService.countCustomerMake();
    }

    @RequestMapping("countCustomerMake02")
    @ResponseBody
    public Map<String,Object> countCustomerMake02(){
        return customerService.countCustomerMake02();
    }




}
