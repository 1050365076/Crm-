layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        elem:"#customerOrderList",
        url:ctx+"/order/list?cusId="+$("input[name ='id']").val(),
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#customerOrderListBar",
        id: "customerOrderListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'orderNo',title:'订单编号',align:"center"},
            {field: 'orderDate',title:'订单日期',align:'center'},
            {field: 'address',title:'收货地址',align:'center'},
            {field: 'state',title:'支付状态',align:'center',templet:function (d) {
                    if(d.state == 1){
                        return "已支付";
                    }else{
                        return "未支付";
                    }
                }},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'updateDate',title:'更新时间',align:'center'},
            {fixed: 'right',title:'操作',align:"center",minWidth:150,templet:'#customerOrderListBar'}
        ]]

    })


    //设计行监听，客户机会计划项
    table.on('tool(customerOrders)',function (obj) {
        var layEvent = obj.event;
        if (layEvent === 'info') {
            openOrderDetailsDialog(obj.data.id);
        }
    });

    function openOrderDetailsDialog(id) {
        layui.layer.open({
            title:"客户管理-订单详情查看",
            maxmin:true,
            area:["700px","500px"],
            content:ctx+"/customer/orderDetailPage?orderId="+id,
            type:2
        })
    }


});
