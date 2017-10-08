package com.lkp.dao.impl;

import com.lkp.dao.TlkSctjDao;
import com.lkp.entity.TlkSctjEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Repository
public class SctjDaoImpl extends BaseDaoImpl<TlkSctjEntity> implements TlkSctjDao {
    String QUERY_FIND_SCTJMAS = "from " + TlkSctjEntity.class.getName() + " p " +
            "where p.id=:id";

    String QUERY_FIND_ALL_SCTJ = "from " + TlkSctjEntity.class.getName() + " p " +
            "where p.itemSfzs='1' " +
            " ORDER BY p.itemZsxh" ;

    @Override
    public TlkSctjEntity getsctiByid(Serializable id) {
        Query query = getSession().createQuery(QUERY_FIND_SCTJMAS);
        query.setParameter("id", id);
        return (TlkSctjEntity) query.uniqueResult();
    }

    @Override
    public List<TlkSctjEntity> getALlSctj() {
        Query query = getSession().createQuery(QUERY_FIND_ALL_SCTJ);
        return  query.list();
    }


}

