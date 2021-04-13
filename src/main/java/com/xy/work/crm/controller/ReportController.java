package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("report")
public class ReportController extends BaseController {

    @RequestMapping("/{flag}")
    public String index(@PathVariable Integer flag){
        if (flag == 0){
            //客户贡献分析
            return "report/customer_contri";
        }else{
            return "";
        }
    }
}
