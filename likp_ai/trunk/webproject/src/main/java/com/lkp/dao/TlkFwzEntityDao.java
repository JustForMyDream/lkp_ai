package com.lkp.dao;

import com.lkp.entity.TlkFwzEntity;

import java.util.List;

/**
 *
 */
public interface TlkFwzEntityDao extends  BaseDao<TlkFwzEntity>{
    /**
     * 通过服务站 ID 获取服务站相关信息
     */
    TlkFwzEntity findFwzMessageById(String ID);
    List<TlkFwzEntity> findALLFwz();
}
