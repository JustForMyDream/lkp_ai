package com.lkp.dao;

import com.lkp.entity.TlkUserwechatinfoEntity;

/**
 *
 * 用户微信信息dao
 */
public interface TlkUserwechatinfoEntityDao extends BaseDao<TlkUserwechatinfoEntity> {
    /**
     * 通过openid获取用户和微信信息的关联
     * @param openid
     * @return
     */
    TlkUserwechatinfoEntity getTlkUserwechatinfoEntityByOpenid(String openid);
}
