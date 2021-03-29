layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    //layui 用户登录表单提交
    form.on('submit(login)',function (data) {
        //获取表单元素

        data = data.field;

        /**
         * 用户名校验
         */
        if(data.username=="undefined" || data.username=="" || data.username.trim()==""){
            layer.msg("用户名不能为空！");
            return false;
        }

        if(data.password=="undefined" || data.password=="" || data.password.trim()==""){
            layer.msg("用户密码不能为空！");
            return false;
        }

        $.ajax({
             type:"post",
             url:ctx+"/user/login",
             data:{
                 userName:data.username,
                 userPwd:data.password
             },
             dataType:"json",
             success:function (data) {
                 if(data.code==200){
                    layer.msg("用户登录成功！",function () {
                        var result = data.result;

                        $.cookie("userIdStr",result.userIdstr);
                        $.cookie("userName",result.userName);
                        $.cookie("trueName",result.trueName);
                        //判断是否点击 记住密码
                        if($("input[type='checkbox']").is(":checked")){
                            $.cookie("userIdStr",result.userIdstr,{expires:7});
                            $.cookie("userName",result.userName,{expires:7});
                            $.cookie("trueName",result.trueName,{expires:7});
                        }
                        window.location.href=ctx+"/main";
                    })
                 }else{
                     layer.msg(data.msg);
                 }

             }

        });


        return false;
    })
});
