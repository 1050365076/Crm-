package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.CustomerServeQuery;
import com.xy.work.crm.service.CustomerServeService;
import com.xy.work.crm.utils.LoginUserUtil;
import com.xy.work.crm.vo.CustomerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.Map;

@Controller
@RequestMapping("customer_serve")
public class CustomerServeController extends BaseController {

    @Autowired
    private CustomerServeService customerServeService;

    @RequestMapping("index/{type}")
    public String index (@PathVariable Integer type){
        if(null != type){
            if (type == 1){
                return "customerServe/customer_serve";
            }else if (type == 2){
                return "customerServe/customer_serve_assign";
            }else if (type == 3){
                return "customerServe/customer_serve_proce";
            }else if (type == 4){
                return "customerServe/customer_serve_feed_back";
            }else if (type == 5){
                return "customerServe/customer_serve_archive";
            }else {
                return "";
            }
        }else {
            return "";
        }
    }
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryByParams(HttpServletRequest request, Integer flag, CustomerServeQuery customerServeQuery){
        if (flag != null){
            //按照分配人执行
           customerServeQuery.setAssigner( LoginUserUtil.releaseUserIdFromCookie(request));
        }
        return customerServeService.queryByParams(customerServeQuery);
    }

    @RequestMapping("toSaveCustomerServePage")
    public String toSaveCustomerServePage(){
     return "customerServe/customer_serve_add";
    }


    @RequestMapping("addCustomerServeAssignPage")
    public String addCustomerServeAssignPage(Integer id, Model model){
        model.addAttribute("customerServe",customerServeService.selectByPrimaryKey(id));
        return "customerServe/customer_serve_assign_add";
    }
    @RequestMapping("addCustomerServeBackPage")
    public String addCustomerServeBackPage(Integer id, Model model){
        model.addAttribute("customerServe",customerServeService.selectByPrimaryKey(id));
        return "customerServe/customer_serve_feed_back_add";
    }


    @RequestMapping("addCustomerServeProcePage")
    public String  addCustomerServeProcePage(Integer id, Model model){
        model.addAttribute("customerServe",customerServeService.selectByPrimaryKey(id));
        return "customerServe/customer_serve_proce_add";
    }



    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveCustomerServe(CustomerServer customerServer){
        customerServeService.saveCustomerServe(customerServer);
        return success("客户服务创建成功！");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateCustomerServe(CustomerServer customerServer){
        customerServeService.updateCustomerServe(customerServer);
        return success("客户服务更新成功!");
    }


    @RequestMapping("countCustomerServe")
    @ResponseBody
    public Map<String,Object> countCustomerServe(){
        return customerServeService.countCustomerServe();
    }

    @RequestMapping("countCustomerServe02")
    @ResponseBody
    public Map<String,Object> countCustomerServe02(){
        return customerServeService.countCustomerServe02();
    }



}
