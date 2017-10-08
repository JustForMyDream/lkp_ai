package com.lkp.dao;

import com.lkp.entity.TlkUserEntity;

/**
 *
 */
public interface UserDao extends BaseDao<TlkUserEntity> {
    /**
     * 通过微信openid 获取用户信息
     * @param opendi
     * @return
     */
    TlkUserEntity findByOpenid(String opendi);
}
