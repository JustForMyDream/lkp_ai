package com.lkp.dao;

import com.lkp.entity.TlkMhdxxbmEntity;

/**
 *
 */
public interface TlkMhdxxbmEntityDao extends BaseDao<TlkMhdxxbmEntity> {

    TlkMhdxxbmEntity findByhdIdAndUserId(String Id,String UserId);
}
