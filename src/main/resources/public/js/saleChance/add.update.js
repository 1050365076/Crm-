layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;


    //填充指派人下拉框
    $.post(ctx+"/user/queryAllSales",function (res) {
           for (var i =0 ; i<res.length; i++){
               if($("input[name='man']").val() == res[i].id){
                   $("#assignMan").append("<option value=\""+res[i].id+"\" selected='selected'>"+res[i].uname+"</option>");
               }else{
                   $("#assignMan").append("<option value=\""+res[i].id+"\">"+res[i].uname+"</option>");
               }
           };
           //重新渲染下拉框内容
            layui.form.render("select");
    });




    form.on('submit(addOrUpdateSaleChance)',function (data) {
        var index = top.layer.msg("数据提交中,请稍后",{icon:16,time:false,shade:0.8});
        var url = ctx+"/sale_chance/save";
        if($("input[name='id']").val()){
            url = ctx+"/sale_chance/update"
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
