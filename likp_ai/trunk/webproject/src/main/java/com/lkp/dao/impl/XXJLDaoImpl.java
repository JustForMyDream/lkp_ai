package com.lkp.dao.impl;

import com.lkp.dao.XXJLDao;
import com.lkp.entity.TlkXxjlEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class XXJLDaoImpl extends BaseDaoImpl<TlkXxjlEntity> implements XXJLDao {
    String QUEYR_GET_UNREADMSG_BY_OPENID="from "+TlkXxjlEntity.class.getName()+" x " +
            "where x.itemYhzh=:yhbh  order by x.itemXxzt,x.itemFssj desc";

    String QUEYR_DELETE_ALLMSG_BY_OPENID="delete from "+TlkXxjlEntity.class.getName()+" x "+
            "where x.itemYhzh= :yhbh";
    String QUEYR_DELETE_MSG_BY_OPENID=" delete from "+TlkXxjlEntity.class.getName()+" x "+
            " where  x.id=:id";
    String QUEYR_GET_WeiDuMSG_BY_OPENID = "select count(*) from "+TlkXxjlEntity.class.getName()+" x where x.itemYhzh=:yhbh and x.itemXxzt='0'";

    @Override
    public List getUnreadMsg(String yhbh) {
        Query query = getSession().createQuery(QUEYR_GET_UNREADMSG_BY_OPENID);
        query.setParameter("yhbh",yhbh);
        return query.list();
    }

    @Override
    public int getWeiDuMsg(String yhbh) {
        Query query = getSession().createQuery(QUEYR_GET_WeiDuMSG_BY_OPENID);
        query.setParameter("yhbh",yhbh);
        System.out.println("query=="+query);
        return  ((Number)query.uniqueResult()).intValue();
    }

    @Override
    public void DeleteAllMsg(String yhbh) {
        Query query = getSession().createQuery(QUEYR_DELETE_ALLMSG_BY_OPENID);
        query.setParameter("yhbh",yhbh);
        query.executeUpdate();
    }

    @Override
    public void DeleteMsg( String Msgid) {
        Query query = getSession().createQuery(QUEYR_DELETE_MSG_BY_OPENID);
        query.setParameter("id",Msgid);
        query.executeUpdate();
    }
}
