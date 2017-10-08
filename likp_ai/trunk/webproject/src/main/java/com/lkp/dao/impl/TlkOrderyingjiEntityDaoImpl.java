package com.lkp.dao.impl;

import com.lkp.dao.TlkOrderyingjiEntityDao;
import com.lkp.entity.TlkOrderyingjiEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkOrderyingjiEntityDaoImpl extends BaseDaoImpl<TlkOrderyingjiEntity> implements TlkOrderyingjiEntityDao {
    String FIND_ORDERBY_ORDERID = " from " + TlkOrderyingjiEntity.class.getName()+" OYJ " +
            " where OYJ.itemOrderid = :OrderId";

    @Override
    public TlkOrderyingjiEntity findOrderByOrderId(String OrderId) {
        Query query = getSession().createQuery(FIND_ORDERBY_ORDERID);
        query.setParameter("OrderId",OrderId);
        return (TlkOrderyingjiEntity)query.uniqueResult();
    }
}
