package com.lkp.dao.impl;

import com.lkp.dao.TlkZbjqEntityDao;
import com.lkp.entity.TlkZbjqEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkZbjqEntityDaolmpl extends BaseDaoImpl<TlkZbjqEntity> implements TlkZbjqEntityDao {

    String getALLZbjq = " from "+TlkZbjqEntity.class.getName()+" p " +
            "where p.itemSfzs='1'" +
            " ORDER BY p.itemZsxh" ;

    @Override
    public TlkZbjqEntity getZbjqInfobyid(String id) {
        Query query = getSession().createQuery("from  "+TlkZbjqEntity.class.getName()+" u  where u.id=:ZbjqId");
        query.setParameter("ZbjqId",id);
        TlkZbjqEntity ZbjqMess = (TlkZbjqEntity) query.uniqueResult();
        return ZbjqMess ;
    }

    @Override
    public List<TlkZbjqEntity> findALLZbjq() {
        Query query = getSession().createQuery(getALLZbjq);
        return  query.list();
    }
}
