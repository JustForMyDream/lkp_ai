package com.lkp.dao.impl;

import com.lkp.dao.UserDao;
import com.lkp.entity.TlkUserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<TlkUserEntity> implements UserDao {
    String QUEYR_GET_USERINFO_BY_OPENID="from "+TlkUserEntity.class.getName()+" u " +
            "left join fetch u.wechatInfo uw " +
            "left join fetch uw.tlkWechatuserEntity w " +
            "where w.openid=:openid";
    String QUEYR_GET_USERINFO_BY_ID="from "+TlkUserEntity.class.getName()+" u " +
            "join fetch u.wechatInfo uw " +
            "join fetch uw.tlkWechatuserEntity w " +
            "where u.id=:id";

    /**
     * 通过opendi获取用户信息
     * @param opendi
     * @return
     */
    public TlkUserEntity findByOpenid(String opendi) {
        Query query = getSession().createQuery(QUEYR_GET_USERINFO_BY_OPENID);
        query.setParameter("openid",opendi);
        return (TlkUserEntity) query.uniqueResult();
    }

    /**
     * 通过主键获取用户信息
     * @param id
     * @return
     */
    public TlkUserEntity findById(Serializable id){
        Query query = getSession().createQuery(QUEYR_GET_USERINFO_BY_ID);
        query.setParameter("id",id);
        return (TlkUserEntity) query.uniqueResult();
    }
}
