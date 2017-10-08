package com.lkp.dao.impl;

import com.lkp.dao.TlkMhdxxbmEntityDao;
import com.lkp.entity.TlkHdxxbmEntity;
import com.lkp.entity.TlkMhdxxbmEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkMhdxxbmEntityDaoImpl extends BaseDaoImpl<TlkMhdxxbmEntity> implements TlkMhdxxbmEntityDao {
String FIND_BY_HDID_AND_USERID = " from "+ TlkMhdxxbmEntity.class.getName()+" Mhd"+
        " where  Mhd.itemHdbh = :Id and Mhd.itemYhbh = :UserId ";
    @Override
    public TlkMhdxxbmEntity findByhdIdAndUserId(String Id, String UserId) {
        Query query = getSession().createQuery(FIND_BY_HDID_AND_USERID);
        query.setParameter("Id",Id);
        query.setParameter("UserId",UserId);
        return (TlkMhdxxbmEntity)query.uniqueResult();
    }
}
