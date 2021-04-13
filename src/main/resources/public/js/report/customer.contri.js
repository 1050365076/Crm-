layui.use(['table','layer','laydate'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table,
        laydate = layui.laydate;

        laydate.render({
            elem:"#time"
        })
    var tableIns = table.render({
        elem:"#contriList",
        url:ctx+"/customer/queryCustomerContributionByParams",
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        id: "customerContriListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: 'name',title:'客户名',align:"center"},
            {field: 'total',title:"总金额(¥)",align:'center'},
        ]]
    })

    $(".search_btn").on("click",function () {
        table.reload("customerContriListTable",{
            page:{
                curr:1
            },
            where:{
                cusName:$("input[name='customerName']").val(),
                type:$("#type").val(),
                time:$("input[name='time']").val()
            }
        })
    })



});
