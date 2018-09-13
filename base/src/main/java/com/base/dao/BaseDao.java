package com.base.dao;

import java.util.List;

/**
 * @param <T>
 * @author ms
 */
public interface BaseDao<T, E> {


    /**
     * 获取分页列表
     *
     * @param t
     * @return
     */
    List<E> getPageList(T t);

    /**
     * 根据相关字段获取信息
     *
     * @param t
     * @return
     */
    T getConditionsByInfo(T t);

    /**
     * 查询条数
     *
     * @param t
     * @return
     */
    Integer queryCount(T t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    Integer add(T t);

    /**
     * 根据ID获取详情
     *
     * @param t
     * @return
     */
    T getIdByInfo(T t);


    /**
     * 根据ID修改
     *
     * @param t
     * @return
     */
    Integer getIdByUpdate(T t);


    /**
     * 选择性修改
     */
    Integer updateBySelective(T t);


}
