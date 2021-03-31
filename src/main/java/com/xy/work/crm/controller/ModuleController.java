package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.service.impl.ModuleServiceImpl;
import com.xy.work.crm.vo.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.List;

@Controller
@RequestMapping("module")
public class ModuleController extends BaseController {
    @Resource
    private ModuleServiceImpl moduleService;

    @RequestMapping("queryAllModules")
    @ResponseBody
    public List<TreeDto> queeyAllModules(Integer roleId){
       return moduleService.queryAllModules(roleId);
    }

}
