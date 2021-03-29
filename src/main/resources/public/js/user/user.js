layui.use(['table','layer','form'],function() {
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tabIns = table.render({
        elem:'#userList',
        url:ctx+"/user/list",
        cellMinWidth:95,
        page:true,
        height:"full-125",
        limits:[10,15,20,25],
        limit:10,
        toolbar:"#toolbarDemo",
        id:"userListTable",
        cols:[[
            {type:"checkbox",fixed:"left",width:50},
            {field:"id",fixed:"true",title:"编号",width:80},
            {field:"userName",fixed:"true",title:"用户名",minWidth:50},
            {field:"email",fixed:"true",title:"用户邮箱",minWidth:100},
            {field:"phone",fixed:"true",title:"手机号",minWidth:100},
            {field:"trueName",fixed:"true",title:"真实姓名",align:'center',minWidth:150},
            {field:"createDate",fixed:"true",title:"创建时间",minWidth:150,align: 'center'},
            {field:"updateDate",fixed:"true",title:"修改时间",minWidth:150,align: 'center'},
            {templet:"#userListBar",fixed:"right",title:"操作",minWidth:150,align:'center'},
        ]]
    });
    //多条件搜索
    $(".search_btn").on("click",function () {
        table.reload("userListTable",{
            page:{
                curr:1
            },
            where:{
                userName:$("input[name='userName']").val(),
                email:$("input[name='email']").val(),
                phone:$("input[name='phone']").val()
            }
        })
    });

    /**
     * 头工具栏
     */
    table.on('toolbar(users)',function (obj) {
        switch (obj.event) {
            case "add":
                openAddOrUpdateUserDialog();
                break;
            case "del":
                delUsers(table.checkStatus(obj.config.id).data);
                break;

        }
    });

    /**
     * 添加用户或者修改用户
     */
    function openAddOrUpdateUserDialog(uid){
         var title = "用户管理-用户添加"
         var url = ctx+"/user/addOrUpdateUsersPage"
         if(uid){
            title = "用户管理-用户修改"
             url = url+"?id="+uid;
         }
         layui.layer.open({
             title:title,
             type:2,
             area:["700px","500px"],
             maxmin:true,
             content:url
         })
    }

    /**
     * 删除用户
     */
    function delUsers(datas) {
        /**
         * 批量删除
         */
        if(datas.length == 0){
            layer.msg("请选择要删除的记录行！")
            return;
        }
        layer.confirm("确定删除选择的记录",{
            btn:['确定','取消']
        },function (index) {
            layer.close(index);
            var ids = "ids=";
            for (var i =0;i<datas.length;i++){
                if(i<datas.length-1){
                    ids = ids + datas[i].id+"&ids="
                }else {
                    ids = ids + datas[i].id
                }
            }
            $.ajax({
                type:"post",
                url:ctx+"/user/delete",
                data:ids,
                dataType:"json",
                success:function (data) {
                    if(data.code == 200){
                        tabIns.reload();
                    }else {
                        layer.msg(data.msg);
                    }
                }
            })

        })

    }





    //行监听，打开编辑,删除操作
    table.on('tool(users)',function(obj) {
        var layEvent = obj.event;
        if(layEvent === 'edit'){
            openAddOrUpdateUserDialog(obj.data.id);
        }else if(layEvent === "del"){
            layer.confirm("确认删除当前记录?",{icon: 3, title:"用户管理"},function(index){
                $.post(ctx+"/user/delete",{ids:obj.data.id},function (data) {
                    if( data.code == 200){
                        layer.msg("操作成功！");
                        tabIns.reload();
                    }else{
                        layer.msg(data.msg,{icon:5});
                    }
                })
            });
        }
    });

});
