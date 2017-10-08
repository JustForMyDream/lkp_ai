package com.lkp.dao.impl;

import com.lkp.dao.TlkOrderproductEntityDao;
import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.entity.TlkOrderproductEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkOrderproductEntityDaoImpl extends BaseDaoImpl<TlkOrderproductEntity> implements TlkOrderproductEntityDao {
    String FIND_ORDERID_BY_ID = "from " + TlkOrderproductEntity.class.getName() + " OD " +
            " where OD.id = :id";

    @Override
    public TlkOrderproductEntity findOrderIdById(String id) {
        Query query = getSession().createQuery(FIND_ORDERID_BY_ID);
        query.setParameter("id",id);
        return  (TlkOrderproductEntity) query.uniqueResult();
    }
}
