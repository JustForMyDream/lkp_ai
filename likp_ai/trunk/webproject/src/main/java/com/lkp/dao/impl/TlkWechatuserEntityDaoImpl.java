package com.lkp.dao.impl;

import com.lkp.dao.TlkWechatuserEntityDao;
import com.lkp.entity.TlkUserwechatinfoEntity;
import com.lkp.entity.TlkWechatuserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkWechatuserEntityDaoImpl extends BaseDaoImpl<TlkWechatuserEntity> implements TlkWechatuserEntityDao {
    String QUERY_FIND_BY_OPENID = "from " + TlkWechatuserEntity.class.getName() + " w where w.openid=:openid";
    String QUERY_FIND_BY_USERBH = "select w.tlkWechatuserEntity from " + TlkUserwechatinfoEntity.class.getName() + " w where w.uwitemUserid.itemBh=:userbh";

    /**
     * 通过openid获取用户信息
     * @param openid
     * @return
     */
    public TlkWechatuserEntity findByOpenId(String openid) {
        Query query = getSession().createQuery(QUERY_FIND_BY_OPENID);
        query.setParameter("openid", openid);
        return (TlkWechatuserEntity) query.uniqueResult();
    }

    @Override
    public TlkWechatuserEntity findByUserBh(String userbh) {
        Query query = getSession().createQuery(QUERY_FIND_BY_USERBH);
        query.setParameter("userbh", userbh);
        query.setMaxResults(1);
        return (TlkWechatuserEntity) query.uniqueResult();
    }
}
