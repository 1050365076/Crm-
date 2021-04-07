package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.crm.query.OrderDetailsQuery;
import com.xy.work.crm.service.OrderDetailsService;
import com.xy.work.crm.vo.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("order_details")
public class OrderDetailsController extends BaseController {

    @Resource
    private OrderDetailsService detailsService;

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryByParams(OrderDetailsQuery orderDetailsQuery){
        return  detailsService.queryByParams(orderDetailsQuery);
    }

}
