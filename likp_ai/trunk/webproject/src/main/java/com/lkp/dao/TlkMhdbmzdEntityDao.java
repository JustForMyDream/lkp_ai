package com.lkp.dao;

import com.lkp.entity.TlkMhdbmzdEntity;
import com.lkp.entity.TlkMhdxxEntity;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface TlkMhdbmzdEntityDao extends BaseDao<TlkMhdbmzdEntity> {
    List<TlkMhdbmzdEntity> findMhdbhzdByHdbh(String Hdbh);
    List<TlkMhdxxEntity> findHdxx(String str, Date date);
}
