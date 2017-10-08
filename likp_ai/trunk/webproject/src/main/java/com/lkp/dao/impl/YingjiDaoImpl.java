package com.lkp.dao.impl;

import com.lkp.dao.YingjiDao;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderyingjiEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkYingjiEntity;
import org.hibernate.Query;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Repository
public class YingjiDaoImpl extends BaseDaoImpl<TlkYingjiEntity> implements YingjiDao {
    String QUERY_BY_ID = "from " + TlkYingjiEntity.class.getName() + " y " +
            "join fetch y.tlkYingjipicEntities " +
            "where y.id=:id " +
            "order by y.created desc ";
    String QUERY_LIST_BY_BH="select distinct y from " + TlkYingjiEntity.class.getName() + " y " +
            "join fetch y.tlkYingjipicEntities " +
            "where y.itemUserid=:userbh " +
            "order by y.created desc ";
    String QUERY_YINGJI_BY_BH = "select distinct o " +
            " from  "+ TlkYingjiEntity.class.getName() + " o  ," +
              TlkOrderyingjiEntity.class.getName()+" y "+
            "  where " +" o.itemBh = y.itemYingjiid " +
            " and"+
            "  y.itemOrderid = :itemOrderId";
    String QUERY_ORDER_BY_YINGJIID = "select distinct o " +
            "from "+ TlkOrderproductEntity.class.getName()+" o ," +
            TlkOrderyingjiEntity.class.getName()+ " oy "+
            " where oy.itemYingjiid  = (" +
            "       select y.itemBh " +
            "       from  "+ TlkYingjiEntity.class.getName() + " y " +
            "       where y.id = :id" +
            "   ) " +
            "and o.itemOrderid=oy.itemOrderid";
    String DELETE_YINGJI = " DELETE FROM  " +TlkYingjiEntity.class.getName()+" y "+
        "  WHERE y.itemBh = (SELECT o.itemYingjiid from " +TlkOrderyingjiEntity.class.getName() + " o "+
        "   WHERE o.itemOrderid = :id)";
    String DELETE_ORDER_YINGJI="delete from "+TlkOrderyingjiEntity.class.getName()+" o  "+" where o.itemOrderid =:itemOrderid ";
    String DELETE_YINGJI_BY_USERID="delete from "+TlkYingjiEntity.class.getName()+" y "+
        " where y.itemUserid = :UserId and y.id = :id";
    String DELETE_ORDERYINGJI__BY_USERID="delte from " +TlkOrderyingjiEntity.class.getName()+ " o" +
            "where o.id = :id";
    @Override
    public TlkYingjiEntity findById(Serializable id) {
        Query query = getSession().createQuery(QUERY_BY_ID);
        query.setParameter("id", id);
        return (TlkYingjiEntity) query.uniqueResult();
    }
    @Override
    public List<TlkYingjiEntity> getYingjiListByUserbh(String userbh) {
        Query query = getSession().createQuery(QUERY_LIST_BY_BH);
        query.setParameter("userbh", userbh);
        return query.list();
    }

    @Override
    public TlkYingjiEntity findByItemOrderId(String itemOrderId) {
        Query query = getSession().createQuery(QUERY_YINGJI_BY_BH);
        query.setParameter("itemOrderId",itemOrderId);
        return (TlkYingjiEntity) query.uniqueResult();
    }

    @Override
    public TlkOrderproductEntity getOrderByYingjiId(String id) {
        Query query = getSession().createQuery(QUERY_ORDER_BY_YINGJIID);
        query.setParameter("id",id);
        return (TlkOrderproductEntity) query.uniqueResult();
    }

    @Override
    public void deleteYingji(String id) {
       Query query = getSession().createQuery(DELETE_YINGJI);
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public void deleteOrderYingji(String itemOrderid) {
        Query query = getSession().createQuery(DELETE_ORDER_YINGJI);
        query.setParameter("itemOrderid",itemOrderid);
        query.executeUpdate();
    }

    @Override
    public void deleteYingjiByUserId(String UserId,String id) {
           Query query = getSession().createQuery(DELETE_YINGJI_BY_USERID);
           query.setParameter("UserId",UserId);
           query.setParameter("id",id);
           query.executeUpdate();
    }

    @Override
    public void deleteOrderYingjiByUserId(String id) {
           Query query = getSession().createQuery(DELETE_ORDERYINGJI__BY_USERID);
           query.setParameter("id",id);
           query.executeUpdate();
    }
}
