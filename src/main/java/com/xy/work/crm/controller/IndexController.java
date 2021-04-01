package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.crm.service.impl.PermissionServiceImpl;
import com.xy.work.crm.service.impl.UserServiceImpl;
import com.xy.work.crm.utils.LoginUserUtil;
import com.xy.work.crm.vo.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统初始控制器
 * 登录成功的时候讲 Cookie中的Id传到页面
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private PermissionServiceImpl permissionService;
    /**
     * 系统登录界面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * 系统欢迎界面
     * @return
     */
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 后台管理主界面
     * 把登陆用户传到主界面
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request){
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        request.setAttribute("user",userService.selectByPrimaryKey(userId));
        /**
         * 用户登录，通过获得userId查询菜单
         **/
        List<String> permissions =  permissionService.queryUserHasRoleIdsHasModuleIds(userId);
        request.getSession().setAttribute("permissions",permissions);
        return "main";
    }

}
