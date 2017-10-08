package com.lkp.dao.impl;

import com.lkp.dao.TlkUserwechatinfoEntityDao;
import com.lkp.entity.TlkUserwechatinfoEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public class TlkUserwechatinfoEntityDaoImpl extends BaseDaoImpl<TlkUserwechatinfoEntity> implements TlkUserwechatinfoEntityDao {
    String QUERY_FIND_BY_OPENID = "from "+TlkUserwechatinfoEntity.class.getName()+" uw where uw.tlkWechatuserEntity.openid=:openid";
    /**
     * 通过openid获取用户和微信信息的关联
     * @param openid
     * @return
     */
    public TlkUserwechatinfoEntity getTlkUserwechatinfoEntityByOpenid(String openid) {
        Query query = getSession().createQuery(QUERY_FIND_BY_OPENID);
        query.setParameter("openid",openid);
        return (TlkUserwechatinfoEntity) query.uniqueResult();
    }
}
