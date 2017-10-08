package com.lkp.dao;

import com.lkp.entity.TlkWechatuserEntity;

/**
 *
 */
public interface TlkWechatuserEntityDao extends BaseDao <TlkWechatuserEntity>{
    /**
     * 通过openid获取用户信息
     * @param openid
     * @return
     */
    TlkWechatuserEntity findByOpenId(String openid);

    TlkWechatuserEntity findByUserBh(String userbh);
}
