package com.lkp.service;

import com.lkp.entity.TlkZbjqEntity;

import java.util.List;

/**
 *
 */
public interface TlkZbjqEntityService {
    /**
     * 通过景区id（即编号）得到景区的信息
     * @param id
     * @return
     */
    TlkZbjqEntity getZbjqInfobyid(String id);
    List<TlkZbjqEntity> findAll();

}
