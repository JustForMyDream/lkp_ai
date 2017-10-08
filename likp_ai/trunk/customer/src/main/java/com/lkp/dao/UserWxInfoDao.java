package com.lkp.dao;


import com.lkp.entity.TlkWechatuserEntity;

/**
 * Created by wanggan on 2016/11/5.
 */
public interface UserWxInfoDao extends BaseDao<TlkWechatuserEntity> {
    TlkWechatuserEntity getByOpenid(String openid);
}
