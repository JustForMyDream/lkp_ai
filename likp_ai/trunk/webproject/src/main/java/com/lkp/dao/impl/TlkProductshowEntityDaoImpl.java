package com.lkp.dao.impl;

import com.lkp.dao.TlkProductshowEntityDao;
import com.lkp.entity.TlkProductshowEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkProductshowEntityDaoImpl extends BaseDaoImpl<TlkProductshowEntity> implements TlkProductshowEntityDao {
    String GET_ZUOPING_BY_SYSID = " select distinct p from " + TlkProductshowEntity.class.getName() + " p " +
            "left join fetch p.tlkProductshowpicEntities " +
           "where p.itemSysbh = :id order by p.created desc" ;

    String GET_PRODUCTSHOW_BYZUOPINGID = "from " + TlkProductshowEntity.class.getName() + " p " +
            "left join fetch p.tlkProductshowpicEntities " +
            "where p.id = :id" ;

    @Override
    public List<TlkProductshowEntity> getZuopingBySysid(String id) {
        Query query = getSession().createQuery(GET_ZUOPING_BY_SYSID);
        query.setParameter("id",id);
        return query.list();
    }

    @Override
    public TlkProductshowEntity getProductshowByZuopingid(String id) {
        Query query = getSession().createQuery(GET_PRODUCTSHOW_BYZUOPINGID);
        query.setParameter("id",id);
        return (TlkProductshowEntity)query.uniqueResult();
    }

}
