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

});
