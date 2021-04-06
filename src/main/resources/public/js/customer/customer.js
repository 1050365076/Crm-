layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer :  top.layer,
        $ = layui.jquery,
        table = layui.table;


    /**
     * 营销机会表展示
     */
    var tableIns = table.render({
        elem: '#customerList',
        url : ctx+'/customer/list',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limits: [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id: "customerListTable",
        cols: [[
            {type: "checkbox",fixed:"center"},
            {field: "id",title:"编号",fixed:"true"},
            {field: 'name',title:'客户名',align:"center"},
            {field: 'fr',title:'法人',align:'center'},
            {field: 'khno',title:'客户编号',align:'center'},
            {field: 'area',title:'地区',align:'center'},
            {field: 'cusManager',title:'客户经理',align:'center'},
            {field: 'myd',title:'满意度',align:'center'},
            {field: 'level',title:'客户级别',align:'center'},
            {field: 'xyd',title:'信用度',align:'center'},
            {field: 'address',title:'详细地址',align:'center'},
            {field: 'postCode',title:'邮编',align:'center'},
            {field: 'phone',title:'电话',align:'center'},
            {field: 'webSite',title:'网站',align:'center'},
            {field: 'fax',title:'传真',align:'center'},
            {field: 'zczj',title:'注册基金',align:'center'},
            {field: 'yyzzzch',title:'营业执照',align:'center'},
            {field: 'khyh',title:'开户行',align:'center'},
            {field: 'khzh',title:'开户账号',align:'center'},
            {field: 'gsdjh',title:'国税',align:'center'},
            {field: 'dsdjh',title:'地税',align:'center'},
            {field: 'createDate',title:'创建时间',align:'center'},
            {field: 'updateDate',title:'修改时间',align:'center'},
            {fixed: 'right',title:'操作',align:"center",minWidth:150,templet:'#customerListBar'}
        ]]

    });


    $(".search_btn").on("click",function () {
           table.reload("customerListTable",{
                page:{
                    curr: 1
                },
               where:{
                    cusName:$("input[name = 'name']").val(),//客户名
                    cusNo:$("input[name = 'khno']").val(),//客户编号
                    level:$("#level").val()//客户级别
               }
           })
    })

    table.on("toolbar(customers)",function (obj) {
            switch (obj.event) {
                case "add":
                    openAddOrUpdateCustomerDialog();
                    break;

            }

    })


    table.on("tool(customers)",function (obj) {
        var layEvent =  obj.event;
        if(layEvent === "edit"){
            openAddOrUpdateCustomerDialog(obj.data.id);
        }else if(layEvent === "del"){
            layer.confirm("确定删除当前记录吗？",{icon:3,title:"客户管理"},function (index) {
                $.post(ctx +"/customer/delete",{id:obj.data.id},function (data) {
                    if(data.code == 200){
                        layer.msg("删除成功！");
                        tableIns.reload();
                    }else{
                        layer.msg(data.msg,{
                            icon:5
                        })
                    }
                })
            })
        }
    })

    function  openAddOrUpdateCustomerDialog(data) {
        var title = "客户管理-客户添加"
        var url = ctx+"/customer/addOrUpdatePage"
        if(data){
            title = "客户管理-客户更新"
            url = url + "?id="+data;
        }
        layui.layer.open({
            title:title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:url
        })
    }

});
