package com.lkp.dao.impl;

import com.lkp.dao.OrderDao;
import com.lkp.entity.OrderState;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl<TlkOrderproductEntity> implements OrderDao {
    String QUERY_ORDERINFO_BY_ORDERID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities "+
            "where o.itemOrderid=:orderid" ;
    String QUERY_ORDERINFO_BY_ID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.id=:id ";
    String QUERY_ORDERLIST_BY_USERBH = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemUserid.itemBh=:userid";
    String QUERY_IMG_BY_ID = " from "+TlkOrderproductimgEntity.class.getName()+" o "+
            "where o.parent=:id";
    String QUERY_ORDERIMG_LIST = "select distinct o from "+TlkOrderproductEntity.class.getName()+" o "+
            "join fetch o.orderproductimgEntities i "+
            "left join fetch o.itemProductid "+
            "where o.itemUserid.itemBh=:userid "+
            "order by o.created desc ";

    String QUERY_UNFINISH_ORDER_BYUSERID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemUserid.itemBh=:userid "+
            "and (o.itemState='"+ OrderState.WAITE_TO_PAY+ "' "+
            "or o.itemState='"+ OrderState.PAYED_WAITE_SET_PHOTOGRAPHER+ "' "+
            "or o.itemState='"+ OrderState.WAITE_TO_UPLOADIMG+ "' "+
            "or o.itemState='"+ OrderState.WAITE_TO_CONFIRM+"')";
    String QUERY_FINISH_ORDER_BYUSERID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemUserid.itemBh=:userid "+
            "and o.itemState='"+OrderState.FINISHED+"'";
    String QUERY_CANCELED_ORDER_BYUSERID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemUserid.itemBh=:userid "+
            "and o.itemState='"+OrderState.CANCELED+"'";
    String GET_PINGLUN_BY_SYSID = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:id";

    @Override
    public TlkOrderproductEntity findOrderProductByOrderid(String orderid) {
        Query query = getSession().createQuery(QUERY_ORDERINFO_BY_ORDERID);
        query.setParameter("orderid", orderid);
        return (TlkOrderproductEntity) query.uniqueResult();
    }

    @Override
    public List<TlkOrderproductEntity> getOrdersByUserbh(String userBH) {
        Query query = getSession().createQuery(QUERY_ORDERLIST_BY_USERBH);
        query.setParameter("userid", userBH);
        return query.list();
    }

    @Override
    public TlkOrderproductEntity findOrderProductById(String id) {
        Query query = getSession().createQuery(QUERY_ORDERINFO_BY_ID);
        query.setParameter("id", id);
        return (TlkOrderproductEntity) query.uniqueResult();
    }

    @Override
    public List<TlkOrderproductimgEntity> getImgById(String id) {
        Query query = getSession().createQuery(QUERY_IMG_BY_ID);
        query.setParameter("id", id);
        return query.list();
    }


    @Override
    public List<TlkOrderproductEntity> getOrderImgList(String userid) {
        Query query = getSession().createQuery(QUERY_ORDERIMG_LIST);
        query.setParameter("userid", userid);
        return query.list();
    }

    @Override
    public List<TlkOrderproductEntity> getUnfinishOrder(String userid) {
        Query query = getSession().createQuery(QUERY_UNFINISH_ORDER_BYUSERID);
        query.setParameter("userid", userid);
        return query.list();
    }

    @Override
    public List<TlkOrderproductEntity> getfinishOrder(String userid) {
        Query query = getSession().createQuery(QUERY_FINISH_ORDER_BYUSERID);
        query.setParameter("userid", userid);
        return query.list();
    }

    @Override
    public List<TlkOrderproductEntity> getCanceledOrder(String userid) {
        Query query = getSession().createQuery(QUERY_CANCELED_ORDER_BYUSERID);
        query.setParameter("userid", userid);
        return query.list();
    }

//    @Override
//    public List<TlkOrderproductEntity> getOrderBySysId(String id) {
//        Query query = getSession().createQuery(GET_PINGLUN_BY_SYSID);
//        query.setParameter("id",id);
//        return query.list();
//    }
}
