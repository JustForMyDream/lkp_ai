package com.lkp.dao.impl;

import com.lkp.dao.TlkProductmainEntityDao;
import com.lkp.entity.TlkProductmainEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkProductmainEntityDaoImpl extends BaseDaoImpl<TlkProductmainEntity> implements TlkProductmainEntityDao {
    String QUERY_GET_MAINLIST_ENABLED="select distinct m from "+TlkProductmainEntity.class.getName()+" m " +
            "left join fetch m.productEntitySet p " +
            "left join fetch p.tlkProductshowEntities ps " +
            "left join fetch ps.tlkProductshowpicEntities " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "where m.itemState='上线' and p.itemCpzt='上线'";
    String QUERY_GET_MAINLIST_ENABLED_BY_ID="select distinct m from "+TlkProductmainEntity.class.getName()+" m " +
            "left join fetch m.productEntitySet p " +
            "left join fetch p.tlkProductshowEntities ps " +
            "left join fetch  ps.tlkProductshowpicEntities " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "where m.id=:id and p.itemCpzt='上线'";
    @Override
    public List<TlkProductmainEntity> getAllEnabled() {
        return getSession().createQuery(QUERY_GET_MAINLIST_ENABLED).list();
    }

    @Override
    public List<TlkProductmainEntity> findByid(String id) {
        Query query = getSession().createQuery(QUERY_GET_MAINLIST_ENABLED_BY_ID);
        query.setParameter("id",id);
        return query.list();
    }
}
