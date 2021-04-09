layui.use(['form','layer'],function () {
    var form = layui.form;
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    form.on("submit(addOrUpdateCustomerRep)",function (data) {
        var index = top.layer.msg("数据提交中,请稍后",{icon:16,time:false,shade:0.8});
        var url = ctx+"/customer_reprieve/save"
        if($("input[name = 'id']").val()){
            url = ctx+"/customer_reprieve/update"
        }
        $.post(url,data.field,function (res) {
            if(res.code == 200){
                top.layer.msg("操作成功！");
                top.layer.close(index);
                layui.layer.closeAll("iframe");
                //刷新父界面
                parent.location.reload();
            }else{
                layer.msg(res.msg,{
                    icon:6
                });
            };
        });
        return false;
    })

    $("#closeBtn").on("click",function () {
        var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
        parent.layer.close(index); // 再执行关闭
    });
})


