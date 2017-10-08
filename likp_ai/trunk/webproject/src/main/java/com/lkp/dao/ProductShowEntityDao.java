package com.lkp.dao;

import com.lkp.entity.TlkProductshowEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface ProductShowEntityDao extends BaseDao<TlkProductshowEntity> {
//    通过id找到作品的列表
    TlkProductshowEntity  findById(Serializable id);
    List<TlkProductshowEntity> findBySysId(String sys);
}
