package com.lkp.dao.impl;

import com.lkp.dao.TlkHdxxbmEntityDao;
import com.lkp.entity.TlkHdxxbmEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkHdxxbmEntityDaoImpl extends BaseDaoImpl<TlkHdxxbmEntity> implements TlkHdxxbmEntityDao {
    String FIND_HDXXBM_BY_ID ="from " + TlkHdxxbmEntity.class.getName()+" bm"+
          "where bm.id =:id";
    String FIND_HDXXBM_BY_HDID_ADN_USERID="from " + TlkHdxxbmEntity.class.getName()+" bm "+
            "where bm.itemHdbh =:itemHdbh and bm.itemUserbh=:userid";
    String FIND_HDXXBM_BY_HDID_ADN_SYSID="from " + TlkHdxxbmEntity.class.getName()+" bm "+
            "where bm.itemHdbh =:itemHdbh and bm.itemSysbh=:sysid";

    @Override
    public TlkHdxxbmEntity findHdxxbmById(String id) {
        Query query = getSession().createQuery(FIND_HDXXBM_BY_ID);
        query.setParameter("id",id);
        return (TlkHdxxbmEntity)query.uniqueResult();
    }

    @Override
    public TlkHdxxbmEntity findByUserIdAndHdId(String userid, String hdid) {
        Query query = getSession().createQuery(FIND_HDXXBM_BY_HDID_ADN_USERID);
        query.setParameter("itemHdbh",hdid);
        query.setParameter("userid",userid);
        query.setMaxResults(1);
        return (TlkHdxxbmEntity)query.uniqueResult();
    }

    @Override
    public TlkHdxxbmEntity findByUserIdAndSysId(String userid, String hdid) {
        Query query = getSession().createQuery(FIND_HDXXBM_BY_HDID_ADN_SYSID);
        query.setParameter("itemHdbh",hdid);
        query.setParameter("sysid",userid);
        query.setMaxResults(1);
        return (TlkHdxxbmEntity)query.uniqueResult();
    }
}
