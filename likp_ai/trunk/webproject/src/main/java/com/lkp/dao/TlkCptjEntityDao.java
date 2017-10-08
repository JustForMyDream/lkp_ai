package com.lkp.dao;

import com.lkp.entity.TlkCptjEntity;

import java.util.List;

/**
 *
 */
public interface TlkCptjEntityDao extends BaseDao<TlkCptjEntity> {
    /**
     * 通过推荐产品信息
     */
    List<TlkCptjEntity> getTjProductInfor();
}
