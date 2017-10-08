package com.lkp.dao.impl;

import com.lkp.dao.TlkWechatAccesstokenEntityDao;
import com.lkp.entity.TlkWechatAccesstokenEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkWechatAccesstokenEntityDaoImpl extends BaseDaoImpl<TlkWechatAccesstokenEntity> implements TlkWechatAccesstokenEntityDao {
    String QUERY_NEWEST_TOKEN = "from "+TlkWechatAccesstokenEntity.class.getName()+" a order by a.itemUpdatedate desc";
    @Override
    public TlkWechatAccesstokenEntity getTlkWechatAccesstokenEntity() {
        Query query = getSession().createQuery(QUERY_NEWEST_TOKEN);
        query.setMaxResults(1);
        return (TlkWechatAccesstokenEntity) query.uniqueResult();
    }
}
