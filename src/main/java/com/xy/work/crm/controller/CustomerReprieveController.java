package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.CustomerReprieveQuery;
import com.xy.work.crm.service.CustomerReprieveService;
import com.xy.work.crm.vo.CustomerReprieve;
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

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteCustomerRepr(Integer id){
        customerReprieveService.deleteCustomerPer(id);
        return success("暂缓数据删除成功");
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(CustomerReprieve customerReprieve){
        customerReprieveService.saveCustomerRep(customerReprieve);
        return success("添加暂缓记录成功！");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(CustomerReprieve customerReprieve){
        customerReprieveService.updateCustomerRep(customerReprieve);
        return success("更新暂缓记录成功！");
    }

}
