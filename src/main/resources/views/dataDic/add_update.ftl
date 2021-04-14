<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <#-- 用户ID -->
    <input name="id" type="hidden" value="${(dataDic.id)!}"/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">字典类型明名称</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input dataDicName"
                   lay-verify="required" name="dataDicName" id="dataDicName"  value="${(dataDic.dataDicName)!}" placeholder="请输入字典名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">字典值</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input dataDicValue"
                   lay-verify="required" name="dataDicValue" id="dataDicValue" value="${(dataDic.dataDicValue)!}" placeholder="请输入字典内容">
        </div>
    </div>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addOrUpdateDataDic">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx}/js/dataDic/add.update.js"></script>
</body>
</html>
