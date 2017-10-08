package com.lkp.dao.impl;


import com.lkp.dao.TlkFwzEntityDao;
import com.lkp.entity.TlkFwzEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkFwzEnityDaoImpl extends BaseDaoImpl<TlkFwzEntity> implements TlkFwzEntityDao {

    String getALLFWZ = " from "+TlkFwzEntity.class.getName()+" p " +
            "where p.itemSfzs='1'" +
            " ORDER BY p.itemZsxh" ;


    public TlkFwzEntity findFwzMessageById(String ID) {
        Query query = getSession().createQuery("from  "+TlkFwzEntity.class.getName()+" u  where u.id=:FwzId");
        query.setParameter("FwzId",ID);
        TlkFwzEntity FwzMess = (TlkFwzEntity) query.uniqueResult();
        return FwzMess ;
    }

    @Override
    public List<TlkFwzEntity> findALLFwz() {
        Query query = getSession().createQuery(getALLFWZ);
        return  query.list();
    }
}
