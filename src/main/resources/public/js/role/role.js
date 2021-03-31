layui.use(['table','layer','form'],function() {
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tabIns = table.render({
        elem:'#roleList',
        url:ctx+"/role/list",
        cellMinWidth:95,
        page:true,
        height:"full-125",
        limits:[10,15,20,25],
        limit:10,
        toolbar:"#toolbarDemo",
        id:"roleListTable",
        cols:[[
            {type:"checkbox",fixed:"left",width:50},
            {field:"id",fixed:"true",title:"编号",width:80},
            {field:"roleName",fixed:"true",title:"角色名",minWidth:50},
            {field:"roleRemark",fixed:"true",title:"角色描述",minWidth:100},
            {field:"createDate",fixed:"true",title:"创建时间",minWidth:150,align: 'center'},
            {field:"updateDate",fixed:"true",title:"修改时间",minWidth:150,align: 'center'},
            {templet:"#roleListBar",fixed:"right",title:"操作",minWidth:150,align:'center'},
        ]]
    });

    $(".search_btn").on("click",function () {
        table.reload("roleListTable",{
            page:{
                curr:1
            },
            where:{
                roleName:$("input[name='roleName']").val()
            }
        })
    });

    //头工具栏
    table.on("toolbar(roles)",function (obj) {
        switch (obj.event) {
            case "add":
                openAndOrUpdateRoleDialog();
                break;
            case "grant":
                openAddGrantDialog(table.checkStatus(obj.config.id).data);
                break;
        }
    })

    //打开权限对话框
    function openAddGrantDialog(datas) {
        if(datas.length == 0){
            layer.msg("请选择待授权的角色记录!",{icon:5});
            return;
        }
        if(datas.length > 1){
            layer.msg("暂不支持批量角色授权!",{icon:5});
            return;
        }
        layui.layer.open({
            title:"角色管理——角色授权",
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:ctx+"/role/toAddGrantPage?roleId="+datas[0].id
        });

    }
    function openAndOrUpdateRoleDialog(id){
        var title = "角色管理-角色添加";
        var url = ctx +"/role/addOrUpdateRolePage";
        if(id){
            title = "角色管理-角色修改";
            url = url +"?id="+id;
        }
        layui.layer.open({
            title:title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:url
        })
    }

    //行监听
    table.on("tool(roles)",function (obj) {
        var layEvent = obj.event;
        if(layEvent === 'edit'){
            openAndOrUpdateRoleDialog(obj.data.id);
        }else if(layEvent === 'del'){
            layer.confirm("确定删除当前记录?",{icon:3,title:"角色管理"},function (index) {
                $.post(ctx+"/role/delete",{id:obj.data.id},function (data) {
                        if(data.code == 200){
                            layer.msg("删除成功");
                            tabIns.reload();
                        }else{
                            layer.msg(result.msg);
                        }
                })
            })
        }
    })



});
