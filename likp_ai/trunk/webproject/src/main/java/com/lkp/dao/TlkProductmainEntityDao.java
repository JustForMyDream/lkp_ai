package com.lkp.dao;

import com.lkp.entity.TlkProductmainEntity;

import java.util.List;

/**
 *
 */
public interface TlkProductmainEntityDao extends BaseDao<TlkProductmainEntity>{
    /**
     * 获取所有上线的产品主题
     * @return
     */
    List<TlkProductmainEntity> getAllEnabled();

    /**
     * 通过主题主键获取产品列表
     * @param id
     * @return
     */
    List<TlkProductmainEntity> findByid(String id);
}
