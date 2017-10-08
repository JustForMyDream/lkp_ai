package com.lkp.dao;

import com.lkp.entity.TlkUserwechatinfoEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 用户微信信息接口
 */
public interface UserWechatInfoDao extends BaseDao<TlkUserwechatinfoEntity>{
    /**
     * 通过Openid获取用户信息
     * @param openid
     * @return
     */
    TlkUserwechatinfoEntity findUserTlkUserWechatInfoByOpenid(String openid);

    /**
     * 通过用户编号查询用户微信信息
     * @param userid
     * @return
     */
    List<TlkUserwechatinfoEntity> findUserTlkUserWechatInfoByUserId(String userid);
}
