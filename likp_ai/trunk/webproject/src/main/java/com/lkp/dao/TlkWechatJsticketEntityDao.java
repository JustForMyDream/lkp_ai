package com.lkp.dao;

import com.lkp.entity.TlkWechatJsticketEntity;

/**
 *
 */
public interface TlkWechatJsticketEntityDao extends BaseDao<TlkWechatJsticketEntity> {
    TlkWechatJsticketEntity getNewestTicket();
}
