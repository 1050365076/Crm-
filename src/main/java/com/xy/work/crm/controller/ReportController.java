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
        }else if (flag == 1){
            //客户构成分析
            return "report/customer_make";
        }else if (flag == 3){
            return "report/customer_loss";
        }else {
            return "";
        }
    }
}
