package com.lkp.dao;

import com.lkp.entity.TlkSystjEntity;

import java.util.List;

/**
 *
 */
public interface TlkSystjEntityDao  extends BaseDao<TlkSystjEntity>{
    /**
     * 通过摄影师编号得到摄影的信息
     */
    List<TlkSystjEntity> getSysInforBySysBH();
    List<TlkSystjEntity> getTwoSysInforBySysBH();
}
