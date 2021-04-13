layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;


    var tableIns = table.render({
        elem:"#customerLossList",
        url:ctx+"/customer_loss/list?state=1",
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        id: "customerLossListTable",
        cols: [[
            {field: 'cusNo',title:"客户编号",align:"center"},
            {field: 'cusName',title:"客户名称",align:'center'},
            {field: 'cusManager',title:"客户经理",align:'center'},
            {field: 'lastOrderTime',title:"最后下单时间",align:'center'},
            {field: 'lossReason',title:"流失原因",align:'center'},
            {field: 'confirmLossTime',title:"确认流失时间",align:'center'},
        ]]
    })

    $(".search_btn").on("click",function () {
        table.reload("customerLossListTable",{
            page:{
                curr:1
            },
            where:{
                cusNo:$("input[name='cusNo']").val(),
                cusName:$("input[name='cusName']").val()
            }
        })
    })



});
