layui.use(['form','layer'],function () {
    var form = layui.form;
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    form.on("submit(addOrUpdateCustomer)",function (data) {
        var index = top.layer.msg("数据提交中请稍后...",{icon:16,time:false,shade:0.8});
        var url = ctx +"/customer/save"
        if($("input[name = 'id']").val()){
            url = ctx +"/customer/update"
        }
        $.post(url,data.field,function (res) {
              if(res.code == 200){
                  top.layer.msg("操作成功");
                  top.layer.close(index);
                  layer.closeAll("iframe");
                  parent.location.reload();
              }else{
                    layer.msg(res.msg);
              }
        });
        return false;
    })




    $("#closeBtn").on("click",function () {
        var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
        parent.layer.close(index); // 再执行关闭
    });

})


