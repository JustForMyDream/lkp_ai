package com.lkp.dao;

import com.lkp.entity.TlkOrderproductEntity;

/**
 *
 */
public interface TlkOrderproductEntityDao extends BaseDao<TlkOrderproductEntity> {
    /**
     * 通过id找到orderid
     * @param id
     * @return
     */
    TlkOrderproductEntity findOrderIdById(String id);
}
