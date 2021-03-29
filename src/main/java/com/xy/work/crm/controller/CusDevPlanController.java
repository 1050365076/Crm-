package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.query.CusDevPlanQuery;

import com.xy.work.crm.service.impl.CusDevPlanServiceImpl;
import com.xy.work.crm.service.impl.SaleChanceServiceImpl;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.vo.CusDevPlan;
import com.xy.work.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 客户开发计划
 */
@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController extends BaseController {

    @Resource
    private SaleChanceServiceImpl saleChanceService;

    @Resource
    private CusDevPlanServiceImpl cusDevPlanService;

    @RequestMapping("index")
    public String index(){ return "cusDevPlan/cus_dev_plan"; }


    /**
     * 客户详情计划项
     */
    @RequestMapping("toCusDevPlanDataPage")
    public String toCusDevPlanDataPage(Integer sid, Model model){
        model.addAttribute("saleChance",saleChanceService.selectByPrimaryKey(sid));
        return "cusDevPlan/cus_dev_plan_data";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryCusDevPlansByParams(CusDevPlanQuery cusDevPlanQuery){
        return  cusDevPlanService.queryCusDevPlanByParams(cusDevPlanQuery);
    };

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveCusDevPlan(CusDevPlan cusDevPlan){
        cusDevPlanService.saveCusDetPlan(cusDevPlan);
        return success("计划项数据添加成功！");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateCusDevPlan(CusDevPlan cusDevPlan){
        cusDevPlanService.updateCusDevPlan(cusDevPlan);
        return success("计划项数据修改成功！");
    }


    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteCusDevPlan(Integer  ids){
        cusDevPlanService.deleteCusDevPlan(ids);
        return success("计划项数据删除成功！");
    }

    @RequestMapping("addOrUpdateCusDevPlanPage")
    public String addOrUpdateCusDevPlanPage(Integer sid,Integer id,Model model){
            model.addAttribute("sid",sid);
            model.addAttribute("cusDevPlan",cusDevPlanService.selectByPrimaryKey(id));

    return "cusDevPlan/add_update";
    }

}
