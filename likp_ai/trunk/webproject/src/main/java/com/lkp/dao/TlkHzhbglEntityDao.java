package com.lkp.dao;

import com.lkp.entity.TlkHzhbglEntity;

import java.util.List;

/**
 *
 */
public interface TlkHzhbglEntityDao extends BaseDao<TlkHzhbglEntity> {
    /**
     * 查找所有合作伙伴
     */
    List<TlkHzhbglEntity> getAllHZHB();
}
