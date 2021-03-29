package com.xy.work.base;


/**
 * 该类为基础查询类，进行多条件查询，分页查询的时候继承改类
 * 该类保存了，分页方法的起始页page,以及每页的数据条数limit
 */
public class BaseQuery {
    private Integer page=1;
    private Integer limit=10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
