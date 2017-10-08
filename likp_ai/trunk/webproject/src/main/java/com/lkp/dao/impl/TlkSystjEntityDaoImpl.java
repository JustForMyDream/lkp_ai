package com.lkp.dao.impl;

import com.lkp.dao.TlkSystjEntityDao;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkSystjEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkSystjEntityDaoImpl extends BaseDaoImpl<TlkSystjEntity> implements TlkSystjEntityDao {

    String getSysInforBySysBH = " from "+TlkSystjEntity.class.getName()+" p " +
            ", "+ TlkPhotographerEntity.class.getName()+" o "+
            "where o.id=p.itemSysbh AND p.itemSfzs='1'" +
            " ORDER BY p.itemZsxh" ;
    String getTwoSysInforBySysBH = " select top 2 from "+TlkSystjEntity.class.getName()+" p " +
            ", "+ TlkPhotographerEntity.class.getName()+" o "+
            "where o.id=p.itemSysbh AND p.itemSfzs='1'" +
            " ORDER BY p.itemZsxh" ;

    @Override
    public List<TlkSystjEntity> getSysInforBySysBH() {
        Query query = getSession().createQuery(getSysInforBySysBH);
        return  query.list();
    }


    @Override
    public List<TlkSystjEntity> getTwoSysInforBySysBH() {
//        Query query = getSession().createQuery(getTwoSysInforBySysBH);

        Query query = getSession().createQuery(getTwoSysInforBySysBH.toString());
        query.setMaxResults(2);
        return  query.list();
    }

}
