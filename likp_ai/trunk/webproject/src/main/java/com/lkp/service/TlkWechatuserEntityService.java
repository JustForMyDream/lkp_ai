package com.lkp.service;

import com.lkp.entity.TlkWechatuserEntity;

import java.util.List;

/**
 *
 */
public interface TlkWechatuserEntityService {
    public void saveOrupdate(TlkWechatuserEntity tlkWechatuserEntity);
    List<TlkWechatuserEntity> findAll();
    TlkWechatuserEntity findByUserbh(String userbh);
    TlkWechatuserEntity findByid(String id);
}
