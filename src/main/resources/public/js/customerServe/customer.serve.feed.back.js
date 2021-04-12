layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        elem:"#customerServeList",
        url:ctx+"/customer_serve/list?state=fw_003",
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id: "customerServerListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'customer',title:'客户名',align:"center"},
            {field: 'dicValue',title:"服务类型",align:'center'},
            {field: 'overview',title:'概要信息',align:'center'},
            {field: 'createPeople',title:'创建人',align:'center'},
            {field: 'assigner',title:'分配人',align:'center'},
            {field: 'serviceProcePeople',title:'处理人',align:'center'},
            {field: 'serviceProceTime',title:'处理时间',align:'center'},
            {field: 'assignTime',title:'分配时间',align:'center'},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'updateDate',title:'更新时间',align:'center'},
            {title:"操作",minWidth:150,templet:'#customerServeListBar',fixed:"right",align:"center"}
        ]]
    })

    $(".search_btn").on("click",function () {
        table.reload("customerServerListTable",{
            page:{
                curr:1
            },
            where:{
                customer:$("input[name='customer']").val(),
                serverType:$("#type").val()
            }
        })
    })



    table.on("tool(customerServes)",function (obj) {
        switch (obj.event) {
            case "back":
                openCustomerBackDialog(obj.data.id);
                break;
        }
    })
    function openCustomerBackDialog(id) {
        layui.layer.open({
            type:2,
            area:["700px","500px"],
            title:"服务管理-服务处理",
            content:ctx+"/customer_serve/addCustomerServeBackPage?id="+id,
            maxmin:true
        })
    }
});
