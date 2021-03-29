layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer :  top.layer,
        $ = layui.jquery,
        table = layui.table;


    /**
     * 营销机会表展示
     */
    var tableIns = table.render({
        elem: '#saleChanceList',
        url : ctx+'/sale_chance/list',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id: "saleChanceListTable",
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
            {field: 'uname',title:'指派人',align:'center'},
            {field: 'assignTime',title:'分配时间',align:'center'},
            {field: 'state',title:'分配状态',align:'center',
                templet:function(d){
                    return formatterState(d.state);
                }},
            {field: 'devResult',title:'开发状态',align:"center",
                templet:function(d){
                    return formatterDevResult(d.devResult);
                }},
            {field: 'right',title:'操作',align:"center",minWidth:150,templet:'#saleChanceListBar'}
        ]]

    });



    function  formatterState(state) {
        if(state == 0){
            return "<div style='color:yellow'>未分配</div>"
        }else if(state == 1){
            return "<div style='color:green'>已开发</div>"
        }else{
            return "<div style='color:red '>未开发</div>"
        }
    };
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

    //多条件查询
    $(".search_btn").on("click",function () {
            table.reload("saleChanceListTable",{
                page: {
                    curr: 1
                },
                where:{
                    customerName:$("input[name = 'customerName']").val(),
                    createMan:$("input[name = 'createMan']").val(),
                    state:$("#state").val()
                }
            })
    });

    /**
     * 头工具栏
     */
    table.on('toolbar(saleChances)',function (obj) {
        switch (obj.event) {
            case "add":
                openAddOrUpdateSaleChanceDialog();
                break;
            case "del":
                delSaleChance(table.checkStatus(obj.config.id).data);
                break;

        }
    });
    function delSaleChance(datas) {
        /**
         * 批量删除
         * datas选中的待删除记录
         */
        if(datas.length == 0){
            layer.msg("请选择待删除的记录！");
            return;
        }
        layer.confirm("确定删除选中的记录",{
            btn:["确定","取消"]
        },function (index) {
            layer.close(index);
            var ids ="ids=";
            for (var i = 0 ;i<datas.length;i++){
                if(i<datas.length-1){
                    ids = ids+datas[i].id+"&ids=";
                }else{
                    ids = ids+datas[i].id;
                }
            }
            $.ajax({
                type:"post",
                url :ctx+"/sale_chance/delete",
                data:ids,
                dataType:"json",
                success:function (data) {
                    if(data.code == 200){
                        layer.msg("操作成功！");
                        tableIns.reload();
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
        })
    }


    /**
     * 打开添加对话框
     */
    function  openAddOrUpdateSaleChanceDialog(sid) {
        var title = "营销机会管理-机会添加";
        var url = ctx+"/sale_chance/addOrUpdateSaleChancePage";
        if(sid){
            title = "营销机会管理-机会修改";
            url = url + "?id="+sid;
        }
        layui.layer.open({
            title: title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:url
        })
    }
    //行监听，打开编辑,删除操作
    table.on('tool(saleChances)',function(obj) {
            var layEvent = obj.event;
            if(layEvent === 'edit'){
                openAddOrUpdateSaleChanceDialog(obj.data.id);
            }else if(layEvent === "del"){
                layer.confirm("确认删除当前记录?",{icon: 3, title:"机会数据管理"},function(index){
                        $.post(ctx+"/sale_chance/delete",{ids:obj.data.id},function (data) {
                            if( data.code == 200){
                                layer.msg("操作成功！");
                                tableIns.reload();
                            }else{
                                layer.msg(data.msg,{icon:5});
                            }
                        })
                });
            }
    });


});
