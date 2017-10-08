package com.lkp.dao;

import com.lkp.bean.QueryResult;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 基础dao
 */
public interface BaseDao<T> {
    Serializable save(T entity);
    void update(T entity);
    void saveOrupdate(T entity);
    void delete(T entity);
    void delete(Serializable id);
    T findById(Serializable id);
    List<T> findByHQL(final String hql, String... params) ;
    List<T> findByHQL(String hql, Object... params);
    List<T> findAll();
}
