package com.lkp.dao.impl;

import com.lkp.dao.TlkHdxxEntityDao;
import com.lkp.entity.TlkHdxxEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public class TlkHdxxEntityDaoImpl extends BaseDaoImpl<TlkHdxxEntity> implements TlkHdxxEntityDao {
    String FIND_HDXX_BY_HDBH = "from "+TlkHdxxEntity.class.getName()+ " hd" +
        " where hd.id =:id";
    String GET_YHBH_BY_YHZF="from " +TlkHdxxEntity.class.getName()+ " hd" +
            " where hd.itemUserchar = :yhzf and hd.itemStartdate <= :date and hd.itemEnddate >= :date";
    String GET_SYSBH_BY_SYSZF="from " +TlkHdxxEntity.class.getName()+ " hd" +
            " where hd.itemSyschar = :syszf and hd.itemStartdate <= :date and hd.itemEnddate >= :date";
    String FIND_YH_PAGE = "select  hd.itemUserpage from  " +TlkHdxxEntity.class.getName()+" hd"+
            "  where hd.itemUserchar = :yhzf";
    String FING_SYS_PAGE="select  hd.itemSyspage from  " +TlkHdxxEntity.class.getName()+" hd"+
            "  where hd.itemSyschar = :syszf";
    @Override
    public TlkHdxxEntity findHdxxByHdbh(String Hdxx) {
        Query query = getSession().createQuery(FIND_HDXX_BY_HDBH);
        query.setParameter("id",Hdxx);
        return (TlkHdxxEntity)query.uniqueResult();
    }

    @Override
    public List<TlkHdxxEntity> getYhBmBYYhzf(String yhzf, Date date) {
        Query query =getSession().createQuery(GET_YHBH_BY_YHZF);
        query.setParameter("yhzf",yhzf);
        query.setParameter("date",date);
        return  query.list();
    }

    @Override
    public List<TlkHdxxEntity> getSysBmBYSyszf(String syszf,Date date) {
       Query query = getSession().createQuery(GET_SYSBH_BY_SYSZF);
        query.setParameter("syszf",syszf);
        query.setParameter("date",date);
        return query.list();
    }

    @Override
    public TlkHdxxEntity FindYhPage(String yhzf) {
        Query query = getSession().createQuery(FIND_YH_PAGE);
        query.setParameter("yhzf",yhzf);
        return  (TlkHdxxEntity)query.uniqueResult();
    }

    @Override
    public TlkHdxxEntity FindSysPage(String syszf) {
        Query query = getSession().createQuery(FING_SYS_PAGE);
        query.setParameter("syszf",syszf);
        return (TlkHdxxEntity)query.uniqueResult();
    }

}
