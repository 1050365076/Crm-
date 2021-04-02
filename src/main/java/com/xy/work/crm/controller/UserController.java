package com.xy.work.crm.controller;

import com.xy.work.base.BaseController;
import com.xy.work.base.ResultInfo;
import com.xy.work.crm.exceptions.ParamsException;
import com.xy.work.crm.model.UserModel;
import com.xy.work.crm.query.UserQuery;
import com.xy.work.crm.service.UserService;
import com.xy.work.crm.service.impl.UserServiceImpl;
import com.xy.work.crm.utils.LoginUserUtil;
import com.xy.work.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Resource
    private UserServiceImpl userService;

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    @PostMapping("user/login")
    @ResponseBody
    public ResultInfo login(String userName,String userPwd){
        ResultInfo resultInfo = new ResultInfo();
        try {
            UserModel userModel = userService.login(userName,userPwd);
            /**
             * 1.登录成功后用户登录信息放到session中
             * 2.将用户信息返回给客户端由cookie保存
             * */
            resultInfo.setResult(userModel);
        }catch (ParamsException e){
            e.printStackTrace();
            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setCode(500);
            resultInfo.setMsg("操作失败");
        }

        return resultInfo;
    }


    /**
     * 修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @param cofirmPassword
     * @return
     */
    @PostMapping("user/updatePassword")
    @ResponseBody
    public ResultInfo updatePassword(HttpServletRequest request,String oldPassword,String newPassword,String cofirmPassword){
        ResultInfo resultInfo = new ResultInfo();
        userService.updateUserPwd(LoginUserUtil.releaseUserIdFromCookie(request),oldPassword,newPassword,cofirmPassword);

        return resultInfo;
    };


    /**
     * 转发修改密码界面
     * @return
     */
    @RequestMapping("user/toPasswordPage")
    public String toPasswordPage(){
        return "/user/password";
    }

    @RequestMapping("user/queryAllSales")
    @ResponseBody
    public List<Map<String,Object>> queryAllSales(){
        return userService.queryAllSale();
    }


    @RequestMapping("user/list")
    @ResponseBody
    public Map<String,Object> queryAllUsers(UserQuery query){
        return userService.queryUsersbyParams(query);
    }

    @RequestMapping("user/index")
    public String index(){
        return "user/user";
    }

    @RequestMapping("user/save")
    @ResponseBody
    public ResultInfo saveUser(User user){
        userService.saveUser(user);
        return success("用户记录添加成功！");
    }

    @RequestMapping("user/update")
    @ResponseBody
    public ResultInfo updateUser(User user){
        userService.updateUser(user);
        return success("用户记录修改成功！");
    }

    /**
     * 添加或者修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("user/addOrUpdateUsersPage")
    public String addOrUpdateUsersPage(Integer id, Model model){
        model.addAttribute("userInfo",userService.selectByPrimaryKey(id));
     return "user/add_update";
    }

    @RequestMapping("user/delete")
    @ResponseBody
    public ResultInfo deleteSaleChance(Integer[] ids){
        userService.deleteUser(ids);
        return  success("用户数据删除成功!");
    }
}
