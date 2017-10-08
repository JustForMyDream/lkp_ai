package com.lkp.dao.impl;

import com.lkp.dao.UserWxInfoDao;
import com.lkp.entity.TlkWechatuserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by wanggan on 2016/11/5.
 */
@Repository
public class UserWxInfoDaoImpl extends BaseDaoImpl<TlkWechatuserEntity> implements UserWxInfoDao {
    public TlkWechatuserEntity getByOpenid(String openid) {
        Query query = getSession().createQuery("from  "+TlkWechatuserEntity.class.getName()+" u  where u.itemOpenid=:openid");
        query.setParameter("openid",openid);
        return (TlkWechatuserEntity) query.uniqueResult();
    }
}
