package com.lkp.service;

import com.lkp.entity.TlkFwzEntity;

import java.util.List;

/**
 *
 */
public interface FwzMessService {
    /**
     * 通过服务站 ID 获取服务站相关信息
     * @param ID
     * @return
     */
    TlkFwzEntity findFwzMessageById(String ID);
    List<TlkFwzEntity> findAll();
}
