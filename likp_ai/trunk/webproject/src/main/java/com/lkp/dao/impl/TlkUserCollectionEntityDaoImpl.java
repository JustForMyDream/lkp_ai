package com.lkp.dao.impl;

import com.lkp.dao.TlkUserCollectionEntityDao;
import com.lkp.entity.TlkUserCollectionEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Repository
public class TlkUserCollectionEntityDaoImpl extends BaseDaoImpl<TlkUserCollectionEntity> implements TlkUserCollectionEntityDao {
    String QUERY_COLLECTION_BY_USERBH_ZPMC = "from " + TlkUserCollectionEntity.class.getName() + " o " +
            "where o.itemName=:userbh and " +
            "o.itemZpmc=:zmpc";
    String QUERY_ALL_COLLECTION_BY_USERBH = "from " + TlkUserCollectionEntity.class.getName() + " o " +
            "where o.itemName=:userbh";
    String DELETE_COLLECTION_BY_COLID = "delete from "+TlkUserCollectionEntity.class.getName()+" o "+
            "where o.id=:colid";
    String DELETE_ALL_COLLECTION = "delete from "+TlkUserCollectionEntity.class.getName()+" o "+
            "where o.itemName=:userbh";

    @Override
    public TlkUserCollectionEntity getCollectionByUserbhZpmc(String userbh, String Zmpc) {
        Query query = getSession().createQuery(QUERY_COLLECTION_BY_USERBH_ZPMC);
        query.setParameter("userbh", userbh);
        query.setParameter("zmpc", Zmpc);
        return (TlkUserCollectionEntity) query.uniqueResult();
    }

    @Override
    public List<TlkUserCollectionEntity> getAllCollectionByUserbh(String userbh) {
        Query query = getSession().createQuery(QUERY_ALL_COLLECTION_BY_USERBH);
        query.setParameter("userbh", userbh);
        return query.list();
    }

    @Override
    public void deleteCollectionByUserbhZpmc(String collectionId) {
        Query query = getSession().createQuery(DELETE_COLLECTION_BY_COLID);
        query.setParameter("colid",collectionId);
        query.executeUpdate();
    }

    @Override
    public void deleteAllCollectionByUserbh(String userBh) {
        Query query = getSession().createQuery(DELETE_ALL_COLLECTION);
        query.setParameter("userbh",userBh);
        query.executeUpdate();
    }

}
