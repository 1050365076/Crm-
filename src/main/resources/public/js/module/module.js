layui.use(["table","treetable"],function () {
    var $ = layui.jquery;
    table = layui.table;
    treeTable = layui.treetable;

    treeTable.render({
        treeColIndex:1,
        treeSpid:-1,
        treeIdName:"id",//菜单Id
        treePidName:"parentId",//上级菜单Id
        elem:"#munu-table",
        url:ctx+"/module/list",
        toolbar:"#toolbarDemo",
        treeDefaultClose:true,
        page:true,
        cols:[[
            {type:"numbers"},
            {field:"moduleName",minWidth:100,title:"菜单名称"},
            {field:"optValue",title:"权限码"},
            {field:"url",title:"菜单地址"},
            {field:"createDate",title:"创建时间"},
            {field:"updateDate",title:"修改时间"},
            {
                filed:"grade",width:80,align:"center",templet:function (d) {
                    if(d.grade == 0){
                        return "<span class='layui-badge layui-bg-blue'>目录</span>";
                    }
                    if(d.grade == 1){
                        return "<span class='layui-badge-rim'>菜单</span>";
                    }
                    if(d.grade == 2){
                        return "<span class='layui-badge layui-bg-gray'>按钮</span>";
                    }
                },title:"类型"
            },
            {templet:"#auth-state",width: 200,align: "center",title:"操作"}
        ]],
        //
        done:function () {
            layer.closeAll("loading");
        }

    })

    table.on("toolbar(munu-table)",function (obj) {
        switch (obj.event) {
            case "add":
                openAddModuleDialog(0,-1);
                break;
            case "expand":
                  treeTable.expandAll("#munu-table");
                break;
            case "fold":
                treeTable.foldAll("#munu-table");
                break;
        }
    })

    table.on("tool(munu-table)",function (obj) {
        var layEvent = obj.event;

        if(layEvent === "add"){
            if(obj.data.grade == 2){
                layer.msg("暂不支持四级菜单添加操作");
                return;
            }
            openAddModuleDialog(obj.data.grade+1,obj.data.id);

        }else if(layEvent === 'edit'){
            openUpdateModuleDialog(obj.data.id);
        }else if(layEvent === "del"){
            layer.confirm("确认删除当前记录?",{icon: 3, title:"菜单管理"},function(index){
                $.post(ctx+"/module/delete",{mid:obj.data.id},function (data) {
                    if( data.code == 200){
                        layer.msg("操作成功！");
                        treeTable.reload();
                    }else{
                        layer.msg(data.msg,{icon:5});
                    }
                })
            });
        }
    })

    //添加菜单
    function openAddModuleDialog(grade,parentId) {
        layui.layer.open({
            title:"菜单管理-菜单添加",
            type: 2,
            area:["700px","500px"],
            maxmin:true,
            content:ctx+"/module/addModulePage?grade="+grade+"&parentId="+parentId
        })
    }

    //更新菜单
    function openUpdateModuleDialog(id) {
        layui.layer.open({
            title:"菜单管理-菜单更新",
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:ctx+"/module/updateModulePage?id="+id

        })
    }

});
