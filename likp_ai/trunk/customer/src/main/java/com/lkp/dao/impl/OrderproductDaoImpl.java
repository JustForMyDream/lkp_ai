package com.lkp.dao.impl;

import com.lkp.dao.OrderproductDao;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderyingjiEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wanggan on 2016/11/11.
 */
@Repository 
public class OrderproductDaoImpl extends BaseDaoImpl<TlkOrderproductEntity> implements OrderproductDao {
    String QUERY_ORDERINFO_BY_ORDERID="select distinct o  from "+TlkOrderproductEntity.class.getName()+" o " +
            "where o.itemOrderid=:orderid "+
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo ";
    String QUERY_ORDERINFO_BY_ID="select distinct o from "+TlkOrderproductEntity.class.getName()+" o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.id=:id ";
    String QUERY_ORDERLIST_BY_USEROPENID = "from "+TlkOrderproductEntity.class.getName()+" o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "where o.itemUserid.itemOpenid=:userid order by o.itemXdrq";
    String QUERY_ORDERLIST_BY_SYSBH = "select distinct o from "+TlkOrderproductEntity.class.getName()+" o " +
            "left join fetch o.itemProductid p " +
            "left join fetch p.tlkProductshowEntities ps " +
            "left join  fetch p.tlkCpfwxqEntitys fw " +
            "left join fetch o.itemSysid photo " +
            "left join fetch o.orderproductimgEntities img " +
            "where photo.itemBh=:sysbh order by o.itemXdrq";
    String QUERY_ALL_ORDERLIST = "select distinct o from "+TlkOrderproductEntity.class.getName()+" o " +
            "left join fetch o.itemProductid p " +
            "left join fetch p.tlkProductshowEntities ps " +
            "left join  fetch p.tlkCpfwxqEntitys fw " +
            "left join fetch o.itemSysid photo " +
            "left join fetch o.orderproductimgEntities img " +
            "order by o.itemXdrq desc ";
    String Judge_Order = "SELECT o from "+ TlkOrderproductEntity.class.getName()+" p"
            +", " + TlkOrderyingjiEntity.class.getName()+" o"+
            "  WHERE p.itemOrderid = o.itemOrderid  and p.id=:id";
    public TlkOrderproductEntity findOrderProductByOrderid(String orderid) {
        Query query = getSession().createQuery(QUERY_ORDERINFO_BY_ORDERID);
        query.setParameter("orderid",orderid);
        return (TlkOrderproductEntity) query.uniqueResult();
    }

    public List<TlkOrderproductEntity> getOrdersByUserOpenid(String openid) {
        Query query = getSession().createQuery(QUERY_ORDERLIST_BY_USEROPENID);
        query.setParameter("userid",openid);
        return query.list();
    }

    public TlkOrderproductEntity findOrderProductById(String id) {
        Query query = getSession().createQuery(QUERY_ORDERINFO_BY_ID);
        query.setParameter("id",id);
        return (TlkOrderproductEntity) query.uniqueResult();
    }

    public List<TlkOrderproductEntity> findOrderProductBySySBH(String sysbh) {
        Query query = getSession().createQuery(QUERY_ORDERLIST_BY_SYSBH);
        query.setParameter("sysbh",sysbh);
        return  query.list();
    }

    public List<TlkOrderyingjiEntity> judgeOrder(String id) {
        Query query = getSession().createQuery(Judge_Order);
        query.setParameter("id",id);
        return query.list();
    }

    public List findAllOrderproduct() {
        Query query = getSession().createQuery(QUERY_ALL_ORDERLIST);
        return query.list();
    }

}
