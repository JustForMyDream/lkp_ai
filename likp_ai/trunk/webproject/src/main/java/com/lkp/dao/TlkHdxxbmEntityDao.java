package com.lkp.dao;

import com.lkp.entity.TlkHdxxbmEntity;

/**
 *
 */
public interface TlkHdxxbmEntityDao extends BaseDao<TlkHdxxbmEntity> {
    TlkHdxxbmEntity findHdxxbmById(String id);
    TlkHdxxbmEntity findByUserIdAndHdId(String userid,String hdid);
    TlkHdxxbmEntity findByUserIdAndSysId(String userid,String hdid);
}
