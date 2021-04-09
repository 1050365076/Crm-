layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tableIns = table.render({
        elem:"#customerRepList",
        url:ctx+"/customer_reprieve/list?lossId="+$("input[name='id']").val(),
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id: "customerRepListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'measure',title:"暂缓措施",align:"center"},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'updateDate',title:'更新时间',align:'center'},
            {fixed: 'right',title:'操作',align:"center",minWidth:150,templet:'#customerRepListBar'}
        ]]
    })

    //设计行监听，客户机会计划项
    table.on('tool(customerReps)',function (obj) {
        var layEvent = obj.event;
        if(layEvent === 'edit'){
            openAddOrUpdateCustomerRepDialog(obj.data.id);
        }else if(layEvent ==='del') {
                layer.confirm("确认删除当前记录?",{icon: 3, title:"暂缓数据管理"},function(index){
                    $.post(ctx+"/customer_reprieve/delete",{id:obj.data.id},function (data) {
                        if( data.code == 200){
                            layer.msg("操作成功！");
                            tableIns.reload();
                        }else{
                            layer.msg(data.msg,{icon:5});
                        }
                    })
                });
        }
    })

    function openAddOrUpdateCustomerRepDialog(id) {
        var title = "暂缓管理-添加暂缓";
        var url = ctx+"/customer_loss/toAddOrUpdateCustomerReprPage?lossId="+$("input[name='id']").val();
        if(id){
            title ="暂缓管理-更新暂缓";
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
    table.on('toolbar(customerReps)',function (data) {
        if(data.event == 'add'){  //添加暂缓
            openAddOrUpdateCustomerRepDialog();
        }else if(data.event =='confirm'){ //确认流失
            updateCustomerLossState();
        }
    });
    function updateCustomerLossState() {
          layer.confirm("当前客户确认流失？",{icon: 3, title:"暂缓数据管理"},function(index){
          layer.close(index);
          layer.prompt({title:"请输入流失原因",formType:2},function (text,index) {
                layer.close(index)
                $.ajax({
                    type:"post",
                    url:ctx+"/customer_loss/updateCustomerLossStateById",
                    data:{
                        id:$("input[name= 'id']").val(),
                        lossReason:text
                    },
                    dataType:"json",
                    success:function (res) {
                        if(res.code == 200){
                            layer.msg(res.msg);
                            layer.closeAll("iframe");
                            //刷新页面
                            parent.location.reload();
                        }else{
                            layer.msg(res.msg);
                        }
                    }
                })
          })
        });

    }


});
