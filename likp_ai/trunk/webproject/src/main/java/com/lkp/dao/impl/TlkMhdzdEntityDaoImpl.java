package com.lkp.dao.impl;

import com.lkp.dao.TlkMhdzdEntityDao;
import com.lkp.entity.TlkMhdzdEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkMhdzdEntityDaoImpl extends BaseDaoImpl<TlkMhdzdEntity> implements TlkMhdzdEntityDao {
    String FIND_HDZD_BY_HDBH = "from "+TlkMhdzdEntity.class.getName()+ " hhzd "+
            "where hhzd.itemHdbh = :Hdbh";
    @Override
    public List<TlkMhdzdEntity> findHdzdByHdbh(String Hdbh) {
        Query query = getSession().createQuery(FIND_HDZD_BY_HDBH);
        query.setParameter("Hdbh",Hdbh);
        return query.list();
    }
}
