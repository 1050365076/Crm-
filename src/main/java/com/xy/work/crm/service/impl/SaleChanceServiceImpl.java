package com.xy.work.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.work.base.BaseService;
import com.xy.work.crm.dao.SaleChanceMapper;
import com.xy.work.crm.enums.DevResult;
import com.xy.work.crm.enums.StateStatus;
import com.xy.work.crm.query.SaleChanceQuery;
import com.xy.work.crm.service.SaleChanceService;
import com.xy.work.crm.utils.AssertUtil;
import com.xy.work.crm.utils.PhoneUtil;
import com.xy.work.crm.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SaleChanceServiceImpl extends BaseService<SaleChance,Integer> implements SaleChanceService {
    @Autowired
    private SaleChanceMapper saleChanceMapper;

    @Override
    public Map<String, Object> querSaleChancesByParams(SaleChanceQuery saleChanceQuery) {
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(saleChanceQuery.getPage(),saleChanceQuery.getLimit());
        PageInfo<SaleChance> saleChancePageInfo = new PageInfo<>(saleChanceMapper.selectByParams(saleChanceQuery));
        map.put("code",0);
        map.put("msg","");
        map.put("count",saleChancePageInfo.getTotal());
        map.put("data",saleChancePageInfo.getList());

        return map;
    }

    /**
     * 营销机会添加、修改
     * @param saleChance
     */

    @Override
    public void saveSaleChannce(SaleChance saleChance) {
        /**
         * 1.参数校验
         *     customerName、linkMan 不能为空
         *     linkPhone 非空 11位手机号
         * 2.设置相关参数的默认值
         *      state默认未分配  如果选择分配人 state 为已经分配
         *      assignTime 默认为null  如果选择分配人则为当前系统用户
         *      devResult 默认为未开发  如果选择分配人devResult为开发中 0-未开发 1开发中 2开发成功 3开发失败
         *      isValid 默认有效（1-有效 0-无效）
         *      createTime updateTime 默认系统当前时间
         * 3.执行添加，判断结果
         */
        checkParams(saleChance.getLinkPhone(),saleChance.getCustomerName(),saleChance.getLinkMan());
        saleChance.setState(StateStatus.UNSTATE.getType());
        saleChance.setDevResult(DevResult.UNDEV.getStatus());
        if(StringUtils.isNotBlank(saleChance.getAssignMan())){
            saleChance.setState(StateStatus.STATED.getType());
            saleChance.setDevResult(DevResult.DEVING.getStatus());
            saleChance.setAssignTime(new Date());
        }
        saleChance.setIsValid(1);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
        AssertUtil.isTrue(insertSelective(saleChance)<1,"机会数据添加失败");
    }


    private void checkParams(String linkPhone, String customerName, String linkMan) {
        AssertUtil.isTrue(StringUtils.isBlank(customerName),"请输入客户名！");
        AssertUtil.isTrue(StringUtils.isBlank(linkMan),"请输入联系人！");
        AssertUtil.isTrue(StringUtils.isBlank(linkPhone),"请输入手机号！");
        AssertUtil.isTrue(!(PhoneUtil.isMobile(linkPhone)),"请输入正确的手机号！");

    }

    /**
     * 修改营销机会
     * @param saleChance
     */
    @Override
    public void updateSaleChance(SaleChance saleChance) {
        /**
         * 1.参数校验
         * customerName、linkMan 不能为
         *  linkPhone 非空 11位手机号
         *2.设置相关参数值
         *      updateDate
         *      分配人 未分配 修改后 已分配(分配人是否存在)
         *      state  0--->1
         *      assiginTime 系统当前时间
         *      devResult  0--->1
         *      原生记录已经分配 修改后 未分配
         *      state 1--->0
         *      assiginTime  null
         *      devResult 1--->0
         * 3.执行更新判断结果
         */
        SaleChance temp = selectByPrimaryKey(saleChance.getId());
        AssertUtil.isTrue(null == temp,"待更新记录不存在!");
        checkParams(saleChance.getLinkPhone(),saleChance.getCustomerName(),saleChance.getLinkMan());
        saleChance.setUpdateDate(new Date());
        if(StringUtils.isBlank(temp.getAssignMan())&&StringUtils.isNotBlank(saleChance.getAssignMan())){
                saleChance.setState(StateStatus.STATED.getType());
                saleChance.setAssignTime(new Date());
                saleChance.setDevResult(DevResult.DEVING.getStatus());

        }else if(StringUtils.isNotBlank(temp.getAssignMan()) && StringUtils.isBlank(saleChance.getAssignMan())){
            saleChance.setState(StateStatus.UNSTATE.getType());
            saleChance.setAssignTime(null);
            saleChance.setDevResult(DevResult.UNDEV.getStatus());
            saleChance.setAssignMan("");
        }else if (StringUtils.isNotBlank(temp.getAssignMan())&&StringUtils.isNotBlank(saleChance.getAssignMan())){
            saleChance.setAssignMan(saleChance.getAssignMan());
            saleChance.setAssignTime(temp.getAssignTime());
        }

        AssertUtil.isTrue(updateByPrimaryKeySelective(saleChance)<1,"机会数据更新失败！");
    }

    @Override
    public void  deleteSaleChance(Integer[] ids) {
        AssertUtil.isTrue(null == ids|| ids.length == 0 ,"请选择删除记录!");
        AssertUtil.isTrue(deleteBatch(ids) != ids.length,"记录删除失败!");
    }

    @Override
    public void updateSaleChanceDevResult(Integer id, Integer devResult) {
        AssertUtil.isTrue(null == id ,"待更新记录不存在！");
        SaleChance temp = selectByPrimaryKey(id);
        AssertUtil.isTrue(temp == null,"待更新记录不存！");
        temp.setDevResult(devResult);
        AssertUtil.isTrue(updateByPrimaryKeySelective(temp)<1,"机会数据更新失败！");
    }
}
