package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;

import com.xy.work.base.ResultInfo;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.service.ModuleService;

import com.xy.work.crm.vo.Module;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("module")
public class ModuleController extends BaseController {
    @Resource
    private ModuleService moduleService;

    @RequestMapping("index")
    public String index(){
        return "module/module";
    }

    @RequestMapping("queryAllModules")
    @ResponseBody
    public List<TreeDto> queeyAllModules(Integer roleId){
       return moduleService.queryAllModules(roleId);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryModuls(){
       return moduleService.queryModuls();
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo savaModule(Module module){
        moduleService.saveModule(module);
        return success("菜单添加成功！");
    }

    @RequestMapping("addModulePage")
    public String addModulePage(Integer grade, Integer parentId, Model model){
        model.addAttribute("grade",grade);
        model.addAttribute("parentId",parentId);
        return "module/add";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateModule(Module module){
        moduleService.updateModule(module);
        return success("菜单更新成功！");
    }

    @RequestMapping("updateModulePage")
    public String updateModulePage(Integer id,Model model){
        model.addAttribute("module",moduleService.selectByPrimaryKey(id));
        return "module/update";
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteModule(Integer mid){
        moduleService.deleteModule(mid);
        return success("菜单记录删除成功！");
    }




}
