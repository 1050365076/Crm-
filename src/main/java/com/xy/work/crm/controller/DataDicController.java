package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.DataDicQuery;
import com.xy.work.crm.service.DataDicService;
import com.xy.work.crm.vo.DataDic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("data_dic")
public class DataDicController extends BaseController {

    @Resource
    private DataDicService dataDicService;

    @RequestMapping("index")
    public String index(){
        return "dataDic/data_dic";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryDataDicByParams(DataDicQuery dataDicQuery){
        return dataDicService.queryDataDicByParams(dataDicQuery);
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveDataDic(DataDic dataDic){
        dataDicService.saveDataDic(dataDic);
        return success("字典记录添加成功！");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateDataDic(DataDic dataDic){
        dataDicService.updateDataDic(dataDic);
        return success("字典记录修改成功！");
    }

    @RequestMapping("openAddOrUpdateDataDicPage")
    public String openAddOrUpdateDataDicPage(Integer id, Model model){
        model.addAttribute("dataDic",dataDicService.selectByPrimaryKey(id));
        return "dataDic/add_update";
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteDataDic(Integer id){
        dataDicService.deleteDataDic(id);
        return success("字典记录删除成功！");
    }
}
