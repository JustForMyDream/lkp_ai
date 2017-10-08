package com.lkp.dao;


import com.lkp.entity.TlkWechatuserEntity;

/**
 *
 */
public interface UserWxInfoDao extends BaseDao<TlkWechatuserEntity> {
    TlkWechatuserEntity getByOpenid(String openid);
}
