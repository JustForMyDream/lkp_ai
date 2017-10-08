package com.lkp.dao;

import com.lkp.entity.TlkOrderyingjiEntity;

/**
 *
 */
public interface OrderYingjiDao extends BaseDao<TlkOrderyingjiEntity> {
    TlkOrderyingjiEntity findByOrderid(String item_orderid);
}
