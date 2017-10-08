package com.lkp.dao.impl;

import com.lkp.dao.TlkMhdbmzdEntityDao;
import com.lkp.entity.TlkMhdbmzdEntity;
import com.lkp.entity.TlkMhdxxEntity;
import com.lkp.entity.TlkMhdxxbmEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public class TlkMhdbmzdEntityDaoIpml extends BaseDaoImpl<TlkMhdbmzdEntity> implements TlkMhdbmzdEntityDao {
    String FIND_MHDBHZD_BY_Hdbh = "from "+TlkMhdbmzdEntity.class.getName()+" hdbmzd " +
            " where hdbmzd.itemHdbmbh = :Hdbh";
    String FIND_MHDBHZD_customer_date = "from "+TlkMhdxxEntity.class.getName() +" mhd " +
            "where mhd.itemUserchar=:str and :date between mhd.itemStartdate and mhd.itemEnddate";
    @Override
    public List<TlkMhdbmzdEntity> findMhdbhzdByHdbh(String Hdbh) {
        Query query =  getSession().createQuery(FIND_MHDBHZD_BY_Hdbh);
        query.setParameter("Hdbh",Hdbh);
        return query.list();
    }
    public List<TlkMhdxxEntity> findHdxx(String str,Date date){
        Query query =  getSession().createQuery(FIND_MHDBHZD_customer_date);
        query.setParameter("str",str);
        query.setParameter("date",date);
        return query.list();
    }
}
