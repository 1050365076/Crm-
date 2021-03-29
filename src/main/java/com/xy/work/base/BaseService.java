package com.xy.work.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础Servic类,声明并且实现了，BaseMapper里面的方法
 * 创建Servic时,继承改类,复用里面的方法，继承时声明标识
 */
@SuppressWarnings("all") //抑制所有类型的警告
public abstract class BaseService<T,ID> {

    @Autowired
    private BaseMapper<T,ID> baseMapper;

    /**
     * 添加记录返回行数
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param entity
     * @return java.lang.Integer
     */
    public Integer insertSelective(T entity) throws DataAccessException{
        return baseMapper.insertSelective(entity);
    }

    /**
     * 添加记录返回主键
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param entity
     * @return ID
     */
    public ID insertHasKey(T entity) throws DataAccessException{
        baseMapper.insertHasKey(entity);
        try {
           return (ID) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }


    /**
     * 批量添加
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param entities
     * @return java.lang.Integer
     */
    public Integer insertBatch(List<T> entities) throws DataAccessException{
        return baseMapper.insertBatch(entities);
    }


    /**
     * 根据id 查询详情
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param id
     * @return T
     */
    public T selectByPrimaryKey(ID id) throws DataAccessException{
        return baseMapper.selectByPrimaryKey(id);
    }


    /**
     * 多条件查询
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param baseQuery
     * @return java.util.List<T>
     */
    public List<T> selectByParams(BaseQuery baseQuery) throws DataAccessException{
        return baseMapper.selectByParams(baseQuery);
    }


    /**
     * 更新单条记录
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param entity
     * @return java.lang.Integer
     */
    public Integer updateByPrimaryKeySelective(T entity) throws DataAccessException{
        return baseMapper.updateByPrimaryKeySelective(entity);
    }


    /**
     * 批量更新
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param entities
     * @return java.lang.Integer
     */
    public Integer updateBatch(List<T> entities) throws DataAccessException{
        return baseMapper.updateBatch(entities);
    }

    /**
     * 删除单条记录
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param id
     * @return java.lang.Integer
     */
    public Integer deleteByPrimaryKey(ID id) throws DataAccessException{
        return baseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param ids
     * @return java.lang.Integer
     */
    public Integer deleteBatch(ID[] ids) throws DataAccessException{
        return baseMapper.deleteBatch(ids);
    }


    /**
     * 查询数据表格对应的数据
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param baseQuery
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String, Object> queryByParamsForTable(BaseQuery baseQuery) {
        Map<String,Object> result = new HashMap<String,Object>();
        PageHelper.startPage(baseQuery.getPage(),baseQuery.getLimit());
        PageInfo<T> pageInfo =new PageInfo<T>(selectByParams(baseQuery));
        result.put("count",pageInfo.getTotal());
        result.put("data",pageInfo.getList());
        result.put("code",0);
        result.put("msg","");
        return result;
    }

}
