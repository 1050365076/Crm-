layui.use(['table','layer','form'],function() {
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var tabIns = table.render({
        elem:'#dataDicList',
        url:ctx+"/data_dic/list",
        cellMinWidth:95,
        page:true,
        height:"full-125",
        limits:[10,15,20,25],
        limit:10,
        toolbar:"#toolbarDemo",
        id:"dataDicListTable",
        cols:[[
            {type:"checkbox",fixed:"left",width:50},
            {field:"id",fixed:"true",title:"编号",width:80},
            {field:"dataDicName",fixed:"true",title:"字典名称",minWidth:50},
            {field:"dataDicValue",fixed:"true",title:"字典值",minWidth:100},
            {field:"createDate",fixed:"true",title:"创建时间",minWidth:150,align: 'center'},
            {field:"updateDate",fixed:"true",title:"修改时间",minWidth:150,align: 'center'},
            {templet:"#dataDicListBar",fixed:"right",title:"操作",minWidth:150,align:'center'},
        ]]
    });
    //多条件搜索
    $(".search_btn").on("click",function () {
        table.reload("dataDicListTable",{
            page:{
                curr:1
            },
            where:{
                dataDicName:$("input[name='dataDicName']").val(),
            }
        })
    });

    /**
     * 头工具栏
     */
    table.on("toolbar(dataDics)",function (obj) {
        var layEvent = obj.event;
        if(layEvent === "add"){
            openAddOrUpdateDataDicPage();
        }
    })
    table.on("tool(dataDics)",function (obj) {
        switch (obj.event) {
            case "edit":
                openAddOrUpdateDataDicPage(obj.data.id);
                break;
        }
    })
    /**
     * 添加用户或者修改用户
     */
    function openAddOrUpdateDataDicPage(data) {
        var title = "字典管理-字典添加";
        var url = ctx+"/data_dic/openAddOrUpdateDataDicPage";
        if(data){
            title = "字典管理-字典修改";
            url = url +"?id="+data;
        }
        layui.layer.open({
            title:title,
            type:2,
            area:["700px","500px"],
            maxmin:true,
            content:url
        });
    }

    /**
     * 删除用户
     */


});
