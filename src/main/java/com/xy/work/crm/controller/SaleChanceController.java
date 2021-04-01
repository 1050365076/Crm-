package com.xy.work.crm.controller;


import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.annotaion.RequirePermission;
import com.xy.work.crm.query.SaleChanceQuery;
import com.xy.work.crm.service.impl.SaleChanceServiceImpl;
import com.xy.work.crm.service.impl.UserServiceImpl;
import com.xy.work.crm.utils.LoginUserUtil;
import com.xy.work.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.Map;


@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {

    @Resource
    private SaleChanceServiceImpl saleChanceServiceImpl;

    @Resource
    private UserServiceImpl userService;

    /**
     * 营销登录管理界面
     */
    @RequestMapping("index")
    @RequirePermission(code = "1010") //通过注解的方式拦截访问资源菜单
    public String index(){
        return "saleChance/sale_chance";
    }

    @GetMapping("list")
    @ResponseBody
    @RequirePermission(code = "101001")
    public Map<String,Object> querySaleChanceByParams(Integer flag,SaleChanceQuery query,HttpServletRequest request){
        if(flag !=null && flag == 1){
            //分配给指导用户的数据
            query.setAssignMan(LoginUserUtil.releaseUserIdFromCookie(request));
        }
        return  saleChanceServiceImpl.querSaleChancesByParams(query);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequirePermission(code = "101002")
    public ResultInfo saleSaleChance(HttpServletRequest request,SaleChance saleChance){
        saleChance.setCreateMan(userService.selectByPrimaryKey(LoginUserUtil.releaseUserIdFromCookie(request)).getTrueName());
        saleChanceServiceImpl.saveSaleChannce(saleChance);
        return  success("机会数据添加成功");
    }

    @RequestMapping("addOrUpdateSaleChancePage")
    public String addOrUpdateSaleChancePage(Integer id, Model model){
        if(null != id){
            model.addAttribute("saleChance",saleChanceServiceImpl.selectByPrimaryKey(id));
        }

        return "saleChance/add_update";
    }


    @RequestMapping("update")
    @ResponseBody
    @RequirePermission(code = "101004")
    public ResultInfo updateSaleChance(SaleChance saleChance){
        saleChanceServiceImpl.updateSaleChance(saleChance);
        return  success("机会数据更新成功");
    }



    @RequestMapping("delete")
    @ResponseBody
    @RequirePermission(code = "101003")
    public ResultInfo deleteSaleChance(Integer[] ids){
        saleChanceServiceImpl.deleteSaleChance(ids);
        return  success("机会数据更新成功");
    }

    @RequestMapping("updateCusDevPlanDevResult")
    @ResponseBody
    public ResultInfo updateCusDevPlanDevResult (Integer id ,Integer devResult){
       saleChanceServiceImpl.updateSaleChanceDevResult(id,devResult);
        return success("开发状态更新成功！");
    }


}
