package com.lkp.dao;

import com.lkp.entity.TlkOrderyingjiEntity;

import java.util.List;

/**
 *
 */
public interface TlkOrderyingjiEntityDao extends BaseDao<TlkOrderyingjiEntity> {
    /**
     * 通过订单编号查询是否有该订单
     * @param OrderId
     * @return
     */
    TlkOrderyingjiEntity findOrderByOrderId(String OrderId);
}
