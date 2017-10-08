package com.lkp.dao.impl;

import com.lkp.dao.TlkMhdxxEntityDao;
import com.lkp.entity.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public class TlkMhdxxEntityDaoImpl extends BaseDaoImpl<TlkMhdxxEntity> implements TlkMhdxxEntityDao {
    String FIND_MHDXX_PAGE_BY_ID="from "+TlkMhdxxEntity.class.getName()+" hdm " +
            " where hdm.id= :id and hdm.itemStartdate <= :date and hdm.itemEnddate >= :date";
    String FIND_MHDXX_PAGE_BY_UserOpenid_And_Date="select hdbm from "+TlkMhdxxbmEntity.class.getName()+" hdbm ," +
            TlkMhdxxEntity.class.getName() +" hd "+
            " where hdbm.itemHdbh= hd.id and hdbm.itemYhbh = :userid and hd.itemStartdate <= :date and hd.itemEnddate >= :date";
    @Override
    public TlkMhdxxEntity findMHdxxPageById(String id, Date date) {
        Query query = getSession().createQuery(FIND_MHDXX_PAGE_BY_ID);
        query.setParameter("id",id);
        query.setParameter("date",date);
        return (TlkMhdxxEntity)query.uniqueResult();
    }

    @Override
    public TlkMhdxxEntity findByHdid(String Id) {
        return null;
    }

    @Override
    public List<TlkMhdxxbmEntity> findByUserOpenidandDate(String openid, Date date) {
        Query query = getSession().createQuery(FIND_MHDXX_PAGE_BY_UserOpenid_And_Date);
        query.setParameter("userid",openid);
        query.setParameter("date",date);
        return query.list();
    }
}
