package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("data_dic")
public class DataDicController extends BaseController {

    @RequestMapping("index")
    public String index(){
        return "dataDic/data_dic";
    }
}
