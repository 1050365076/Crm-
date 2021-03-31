$(function () {
    loadMouldInfo();
})
var zTreeObj;
function  loadMouldInfo(){
    $.ajax({
        type:"post",
        url:ctx+"/module/queryAllModules?roleId="+$("input[name='roleId']").val(),
        dataType:"json",
        success:function (data) {
            console.log(data);
            //生成菜单树
            var setting = {
                callback:{
                    onCheck:zTreeOnCheck
                },
                check:{
                    enable:true
                },
                data:{
                    simpleData:{
                        enable:true
                    }
                }
            };
            zTreeObj = $.fn.zTree.init($("#test1"),setting,data);
        }
    })
}

function zTreeOnCheck(event,treeId,treeNode) {
     // alert(treeNode.tId+","+treeNode.name +","+treeNode.checked);
    var nodes = zTreeObj.getCheckedNodes(true);
    var mids="mids=";
    for (var i = 0;i< nodes.length;i++){
        if(i<nodes.length-1){
            mids = mids + nodes[i].id+"&mids=";
        }else{
            mids = mids + nodes[i].id;
        }
    }
    //授权,将mid以及roleId传到后台
    $.ajax({
        type:"post",
        url:ctx+"/role/addGrant",
        data:mids+"&roleId="+$("input[name='roleId']").val(),
        dataType:"json",
        success:function (data) {

        }

    })
};
