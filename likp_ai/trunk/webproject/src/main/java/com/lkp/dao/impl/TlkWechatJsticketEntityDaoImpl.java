package com.lkp.dao.impl;

import com.lkp.dao.TlkWechatJsticketEntityDao;
import com.lkp.entity.TlkWechatJsticketEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkWechatJsticketEntityDaoImpl extends BaseDaoImpl<TlkWechatJsticketEntity> implements TlkWechatJsticketEntityDao {
    String QUERY_NEWEST_TICKET = "from "+TlkWechatJsticketEntity.class.getName()+" a order by a.itemUpdatedate desc";
    @Override
    public TlkWechatJsticketEntity getNewestTicket() {
        Query query = getSession().createQuery(QUERY_NEWEST_TICKET);
        query.setMaxResults(1);
        return (TlkWechatJsticketEntity) query.uniqueResult();
    }
}
