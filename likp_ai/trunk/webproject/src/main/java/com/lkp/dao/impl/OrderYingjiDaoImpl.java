package com.lkp.dao.impl;

import com.lkp.dao.OrderYingjiDao;
import com.lkp.entity.TlkOrderyingjiEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class OrderYingjiDaoImpl extends BaseDaoImpl<TlkOrderyingjiEntity> implements OrderYingjiDao {
    String FIND_BY_ITEM_ORDEROD="from "+TlkOrderyingjiEntity.class.getName()+" oy " +
            "where oy.itemOrderid=:itemOrderid";
    @Override
    public TlkOrderyingjiEntity findByOrderid(String item_orderid) {
        Query query = getSession().createQuery(FIND_BY_ITEM_ORDEROD);
        query.setParameter("itemOrderid",item_orderid);
        return (TlkOrderyingjiEntity) query.uniqueResult();
    }
}
