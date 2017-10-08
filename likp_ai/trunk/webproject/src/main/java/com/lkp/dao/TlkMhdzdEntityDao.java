package com.lkp.dao;

import com.lkp.entity.TlkMhdzdEntity;

import java.util.List;

/**
 *
 */
public interface TlkMhdzdEntityDao extends BaseDao<TlkMhdzdEntity> {
   List <TlkMhdzdEntity> findHdzdByHdbh(String Hdbh);
}
