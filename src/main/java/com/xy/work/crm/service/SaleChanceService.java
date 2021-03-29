package com.xy.work.crm.service;


import com.xy.work.crm.query.SaleChanceQuery;
import com.xy.work.crm.vo.SaleChance;


import java.util.Map;

public interface SaleChanceService    {
    /**
     * 按条件查询
     * @param saleChanceQuery
     * @return
     */
    public Map<String,Object> querSaleChancesByParams(SaleChanceQuery saleChanceQuery);

    public void saveSaleChannce(SaleChance saleChance);

    public void updateSaleChance(SaleChance saleChance);

    public void deleteSaleChance(Integer[] ids);

    public void updateSaleChanceDevResult(Integer id ,Integer devResult);

}
