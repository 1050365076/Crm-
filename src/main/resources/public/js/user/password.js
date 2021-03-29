layui.use(['form','jquery','jquery_cookie'],function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery,
            $ = layui.jquery_cookie($);



        form.on('submit(saveBtn)',function (data) {
            data = data.field;

            $.ajax({
                type:"post",
                url:ctx+"/user/updatePassword",
                data:{
                    oldPassword:data.old_password,
                    newPassword:data.new_password,
                    cofirmPassword:data.again_password
                },
                dataType:"json",
                success:function (data) {
                    if(data.code == 200){
                        layer.msg("密码修改成功，系统将在3秒后自动退出....",function () {
                            /**
                             * 修改密码成功后清除cookie
                             */
                             $.removeCookie("userIdStr",{domain:"localhost",path:"/crm"});
                            $.removeCookie("userName",{domain:"localhost",path:"/crm"});
                            $.removeCookie("trueName",{domain:"localhost",path:"/crm"});
                             setTimeout(function () {
                                window.parent.location.href = ctx+"/index";
                             },3000);
                        });
                    }else{
                        layer.msg(data.msg);
                    }
                }

            })
        })

})
