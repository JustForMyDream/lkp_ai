package com.lkp.dao.impl;

import com.lkp.dao.UserWechatInfoDao;
import com.lkp.entity.TlkUserwechatinfoEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Repository
public class UserWechatInfoDaoImpl extends BaseDaoImpl<TlkUserwechatinfoEntity> implements UserWechatInfoDao {
    String QUERY_USERWECHATINFO_BY_OPENID="from "+TlkUserwechatinfoEntity.class.getName()+" uw join fetch uw.tlkWechatuserEntity w join fetch uw.uwitemUserid where w.openid = :openid";
    String QUERY_USERWECHATINFO_BY_USERID="from "+TlkUserwechatinfoEntity.class.getName()+" uw join fetch uw.tlkWechatuserEntity w join fetch uw.uwitemUserid u where u.id = :id";
    /**
     * 通过Openid获取用户信息
     * @param openid
     * @return
     */
    public TlkUserwechatinfoEntity findUserTlkUserWechatInfoByOpenid(String openid) {
        Query query = getSession().createQuery(QUERY_USERWECHATINFO_BY_OPENID);
        query.setParameter("openid",openid);
        return (TlkUserwechatinfoEntity) query.uniqueResult();
    }

    /**
     * 通过用户编号查询用户微信信息
     * @param userid
     * @return
     */
    public List<TlkUserwechatinfoEntity> findUserTlkUserWechatInfoByUserId(String userid) {
        Query query = getSession().createQuery(QUERY_USERWECHATINFO_BY_USERID);
        query.setParameter("id",userid);
        return query.list();
    }
}
