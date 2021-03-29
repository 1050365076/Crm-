layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //机会数据列表展示
    var tableIns = table.render({
        elem:"#saleChanceList",
        url:ctx+"/sale_chance/list?state=1&flag=1",
        cellMinWidth:95,
        page:true,
        height:"full-125",
        limits:[10,15,20,25],
        limit:10,
        toolbar:"#toolbarDemo",
        id :"saleChanceListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'chanceSource',title:'机会来源',align:"center"},
            {field: 'customerName',title:'客户名称',align:'center'},
            {field: 'cgjl',title:'成功几率',align:'center'},
            {field: 'overview',title:'概要',align:'center'},
            {field: 'linkMan',title:'联系人',align:'center'},
            {field: 'linkPhone',title:'联系电话',align:'center'},
            {field: 'description',title:'描述',align:'center'},
            {field: 'createMan',title:'创建人',align:'center'},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'devResult',title:'开发状态',align:"center",
                templet:function(d){
                    return formatterDevResult(d.devResult);
                }},
            {field: 'right',title:'操作',align:"center",minWidth:150,templet:"#op"}
        ]]

    });

    function formatterDevResult(value) {
        if(value == 0){
            return "<div style='color:yellow'>未开发</div>"
        }else if(value == 1){
            return "<div style='color:#00FF00'>开发中</div>"
        }else if(value == 2){
            return "<div style='color:#00B83F'>开发成功</div>"
        }else if(value == 3){
            return "<div style='color:red'>开发失败</div>"
        }else{
            return "<div style='color:#af0000'>未知</div>"
        }
    }


    /**
     * 多条件查询
     */
    //多条件查询
    $(".search_btn").on("click",function () {
        table.reload("saleChanceListTable",{
            page: {
                curr: 1
            },
            where:{
                customerName:$("input[name = 'customerName']").val(),
                createMan:$("input[name = 'createMan']").val(),
                devResult:$("#devResult").val()
            }
        })
    });

    //行监听
    table.on("tool(saleChances)",function (obj) {
       var layEvent = obj.event;
       if(layEvent === "dev"){
           openCusDevPlanDialog("计划项数据维护",obj.data.id);
       }else if(layEvent === "info"){
           openCusDevPlanDialog("计划项数据详情",obj.data.id);
       }
    })

    //行监听打开详情，或者开发
    function openCusDevPlanDialog(title,sid) {
        layui.layer.open({
            title:title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:ctx+"/cus_dev_plan/toCusDevPlanDataPage?sid="+sid
        })
    }
});
