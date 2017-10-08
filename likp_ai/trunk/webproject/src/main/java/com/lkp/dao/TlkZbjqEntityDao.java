package com.lkp.dao;

import com.lkp.entity.TlkZbjqEntity;

import java.util.List;

/**
 *
 */
public interface TlkZbjqEntityDao extends BaseDao<TlkZbjqEntity> {
    /**
     * 通过景区编号获取景区信息
     * @param id 景区编号
     * @return
     */
    TlkZbjqEntity getZbjqInfobyid(String id);

    List<TlkZbjqEntity> findALLZbjq();
}
