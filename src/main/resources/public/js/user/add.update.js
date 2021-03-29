layui.use(['form', 'layer','formSelects'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    var  formSelects = layui.formSelects;


    formSelects.config('selectId',{
        type:"post",
        searchUrl:ctx+"/role/queryAllRoles",
        keyName: "roleName",
        keyVal: 'id'
    },true);



    form.on('submit(addOrUpdateUser)',function (data) {
        var index = top.layer.msg("数据提交中,请稍后",{icon:16,time:false,shade:0.8});
        var url = ctx+"/user/save";
        if($("input[name='id']").val()){
            url = ctx+"/user/update"
        }
        $.post(url,data.field,function (res) {
                if(res.code == 200){
                    top.layer.msg("操作成功");
                    top.layer.close(index);
                    layui.layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }else{
                    layer.msg(res.msg);
                };
        });
        return false;
    });


    $("#closeBtn").on("click",function () {
        var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
        parent.layer.close(index); // 再执行关闭
    });


});
