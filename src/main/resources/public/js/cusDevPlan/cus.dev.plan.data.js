layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        elem:"#cusDevPlanList",
        url:ctx+"/cus_dev_plan/list?sid="+$("input[name='id']").val(),
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id: "cusDevPlanListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'planItem',title:'计划项',align:"center"},
            {field: 'exeAffect',title:'执行效果',align:'center'},
            {field: 'planDate',title:'执行时间',align:'center'},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'updateDate',title:'更新时间',align:'center'},
            {field: 'right',title:'操作',align:"center",minWidth:150,templet:'#cusDevPlanListBar'}
        ]]

    })

    //设计行监听，客户机会计划项
    table.on('tool(cusDevPlans)',function (obj) {
        var layEvent = obj.event;
        if(layEvent === 'edit'){
            openAddOrUpdateCusDevPlanDialog(obj.data.id);
        }else if(layEvent ==='del'){
            layer.confirm("确定删除当前记录吗？",{icon:3,title:"客户开发机会管理"},function (index) {
                    $.post(ctx+"/cus_dev_plan/delete",{ids:obj.data.id},function (data) {
                        if(data.code == 200){
                            layer.msg("操作成功！");
                            tableIns.reload();
                        }else{
                            layer.msg(data.msg,{icon:5});
                        }
                    });
            })
        }
    })

    function openAddOrUpdateCusDevPlanDialog(id) {
         var title = "计划项管理-添加计划项";
         var url = ctx+"/cus_dev_plan/addOrUpdateCusDevPlanPage?sid="+$("input[name='id']").val();
         if(id != null && id !=""){
             title = "计划项管理-更新计划项";
             url +="&id="+id;
         }
         layui.layer.open({
            title:title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:url
        })
    }
    //设置头工具栏监听
    table.on('toolbar(cusDevPlans)',function (data) {
            if(data.event == 'add'){  //添加计划
                 openAddOrUpdateCusDevPlanDialog();
            }else if(data.event =='success'){ //开发成功
                updateSaleChanceDevResult(2);
            }else if (data.event =='failed'){ //开发失败
                updateSaleChanceDevResult(3);
            }
    });
    function  updateSaleChanceDevResult(data){
        layer.confirm('您确认执行该操作吗',{icon:3,title:"营销机会管理"},function (index) {
            var sId = $("[name=id]").val();
            $.post(ctx+"/sale_chance/updateCusDevPlanDevResult",{id:sId,devResult: data},function (result) {
                if( result.code == 200){
                    layer.msg("更新成功！");
                    layer.closeAll("iframe");
                    parent.location.reload();
                }else {
                    layer.msg(result.msg, {icon: 5});
                }
            });
        })
    }


});
