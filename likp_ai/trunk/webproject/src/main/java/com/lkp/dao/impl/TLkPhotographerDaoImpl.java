package com.lkp.dao.impl;

import com.lkp.dao.TLkPhotographerDao;
import com.lkp.entity.OrderState;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.vo.SelectXJEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TLkPhotographerDaoImpl extends BaseDaoImpl<TlkPhotographerEntity> implements TLkPhotographerDao {
    String QUERY_FIND_PHOTOGRAPHER_BY_OPENID = "from " + TlkPhotographerEntity.class.getName() + " p " +
            "join fetch p.itemOpenid w " +
            "where w.openid=:openid";
    String QUERY_FIND_PHOTOGRAPHER_BY_Sysid  ="from " + TlkPhotographerEntity.class.getName() + " p " +
            "where p.itemBh=:sysid";

    String QUERY_FIND_PHOTOGRAPHER_BY_ID  ="from " + TlkPhotographerEntity.class.getName() + " p " +
            "left join fetch p.itemOpenid " +
            "where p.id=:sysid";
    String QUERY_PHOTOGRAPHER_ORDERLIST_BY_BH = " from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemSysid.itemBh=:itemBh";
    String QUERY_UNFINISH_ORDER_BYUSERID = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemSysid.itemBh=:userid " +
            "and (o.itemState='" + OrderState.WAITE_TO_PAY + "' " +
            "or o.itemState='" + OrderState.PAYED_WAITE_SET_PHOTOGRAPHER + "' " +
            "or o.itemState='" + OrderState.WAITE_TO_UPLOADIMG + "' " +
            "or o.itemState='" + OrderState.WAITE_TO_CONFIRM + "')";
    String QUERY_FINISH_ORDER_BYUSERID = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemSysid.itemBh=:userid " +
            "and o.itemState='" + OrderState.FINISHED + "'";
    String QUERY_CANCELED_ORDER_BYUSERID = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch o.itemProductid p " +
            "left join fetch o.itemSysid photo " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch o.orderproductimgEntities " +
            "where o.itemSysid.itemBh=:userid " +
            "and o.itemState='" + OrderState.CANCELED + "'";
    String QUERY_ORDER_STATE_BYSYSID = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid " +
            "and o.itemState=:state";
    String QUERY_COUNT_STATE_BYSYSID = "select count(o) from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid " +
            "and o.itemState=:state";
    String QUERY_ORDERLIST_ONLYONE = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid and o.itemZzzt = '1'";

    String GET_ORDER_DY_SYSID = "select distinct o from " + TlkOrderproductEntity.class.getName() + " o " +
            "left join fetch  o.itemUserid u " +
            "left join fetch u.wechatInfo uw " +
            "left join fetch uw.tlkWechatuserEntity wu " +
            "where o.itemSysid.itemBh=:sysid AND o.itemPjnr IS NOT NULL";

    String GET_OrderNum_DY_SYSID = "select count(*)  from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid AND o.itemPjnr IS NOT NULL";

    String QUERY_COUNT_ORDER = "select count(o) from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid";
    String QUERY_SUM_ZZ_BYSYSID = "select sum(o.itemZzje) from " + TlkOrderproductEntity.class.getName() + " o " +
            "where o.itemSysid.itemBh=:sysid";
    String QUERY_ZHYE_BYSYSID = "SELECT SUM(o.itemProductnum*o.itemPrice) FROM " + TlkOrderproductEntity.class.getName() + " o WHERE o.itemSysid.itemBh=:sysid and o.itemZzzt ='1'";
    String FIND_ALL_SYS = "from " + TlkPhotographerEntity.class.getName();

    String FIND_SYS_XJ = "select p.ID,p.ITEM_NAME,avg(o.ITEM_PJXJ) as PJXJ,p.ITEM_HEADIMG,w.ITEM_HEADIMGURL,p.ITEM_SYSHDLX,w.ITEM_COUNTRY,w.ITEM_PROVINCE,w.ITEM_CITY FROM \n" +
            "tlk_photographer p \n" +
            "LEFT JOIN tlk_orderproduct o ON o.ITEM_SYSID = p.ITEM_BH \n" +
            "LEFT JOIN tlk_wechatuser w ON p.ITEM_OPENID=w.ITEM_OPENID\n" +
            "GROUP BY p.ITEM_BH";


    String FIND_TwoSYS_XJ = "select p.ID,p.ITEM_NAME,AVG(o.ITEM_PJXJ) AS PJXJ,p.ITEM_HEADIMG,w.ITEM_HEADIMGURL,p.ITEM_SYSHDLX,q.ITEM_SFWL,q.ITEM_WLLJ,q.ITEM_PXXH,SUM(IF(o.ITEM_PJNR IS NOT NULL,1,0)) AS PJNum FROM \n" +
            "tlk_photographer p\n" +
            "LEFT JOIN tlk_orderproduct o ON o.ITEM_SYSID = p.ITEM_BH\n" +
            "LEFT JOIN tlk_wechatuser w ON p.ITEM_OPENID=w.ITEM_OPENID\n" +
            "LEFT JOIN tlk_systj q ON p.ID=q.ITEM_SYSBH \n" +
            "WHERE q.ITEM_SFZS='1'\n"+
            "GROUP BY p.ITEM_BH \n"+
            "ORDER BY q.ITEM_ZSXH DESC";

    String GetIncome = "SELECT SUM(o.itemProductnum*o.itemPrice) FROM " + TlkOrderproductEntity.class.getName() + " o WHERE o.itemSysid.itemBh=:sysid and o.itemState = 'FINISHED'";


    @Override
    public TlkPhotographerEntity getPhotoGrapherByOpenid(String openid) {
        Query query = getSession().createQuery(QUERY_FIND_PHOTOGRAPHER_BY_OPENID);
        query.setParameter("openid", openid);
        query.setMaxResults(1);
        return (TlkPhotographerEntity) query.uniqueResult();
    }

    @Override
    public TlkPhotographerEntity getPhotoGrapherBySysid(String sysid) {
        Query query = getSession().createQuery(QUERY_FIND_PHOTOGRAPHER_BY_Sysid);
        query.setParameter("sysid", sysid);
        return (TlkPhotographerEntity) query.uniqueResult();
    }

    @Override
    public TlkPhotographerEntity getPhotoGrapherByID(String ID) {
        Query query = getSession().createQuery(QUERY_FIND_PHOTOGRAPHER_BY_ID);
        query.setParameter("sysid", ID);
        return (TlkPhotographerEntity) query.uniqueResult();
    }

    @Override
    public List<TlkOrderproductEntity> getPhotographerOrderListByBh(String itemBh) {
        Query query = getSession().createQuery(QUERY_PHOTOGRAPHER_ORDERLIST_BY_BH);
        query.setParameter("itemBh", itemBh);
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

    @Override
    public long getOrderCountByStateSysId(OrderState state, String sysid) {
        Query query = getSession().createQuery(QUERY_COUNT_STATE_BYSYSID);
        query.setParameter("sysid", sysid);
        query.setParameter("state", state);
        return (long) query.uniqueResult();
    }


    @Override
    public List<TlkOrderproductEntity> getOrderByStateSysId(OrderState state, String sysid) {
        Query query = getSession().createQuery(QUERY_ORDER_STATE_BYSYSID);
        query.setParameter("sysid", sysid);
        query.setParameter("state", state);
        return query.list();
    }

    @Override
    public List<TlkOrderproductEntity> getOrderListOnlyOne(String sysid) {
        Query query = getSession().createQuery(QUERY_ORDERLIST_ONLYONE);
        query.setParameter("sysid", sysid);
        return query.list();
    }

    @Override
    public List<TlkOrderproductEntity> getOrderListBySysid(String sysid) {
        Query query = getSession().createQuery(GET_ORDER_DY_SYSID);
        query.setParameter("sysid", sysid);
        return query.list();
    }

    @Override
    public int getOrderNumBySysid(String sysid) {
        Query query = getSession().createQuery(GET_OrderNum_DY_SYSID);
        query.setParameter("sysid", sysid);
        return  ((Number)query.uniqueResult()).intValue();
    }


    @Override
    public long getCountAllOrder(String sysid) {
        Query query = getSession().createQuery(QUERY_COUNT_ORDER);
        query.setParameter("sysid", sysid);
        return (long) query.uniqueResult();
    }

    @Override
    public double getHisZzSum(String sysid) {
        Query query = getSession().createQuery(QUERY_SUM_ZZ_BYSYSID);
        query.setParameter("sysid", sysid);
        double lsztnum = 0;
        if (query.uniqueResult() != null) {
            String temp = query.uniqueResult().toString();
            lsztnum =  Double.parseDouble(temp);
        }
        return lsztnum;
    }


    @Override
    public double getIncome(String sysid) {
        Query query = getSession().createQuery(QUERY_ZHYE_BYSYSID);
        query.setParameter("sysid", sysid);
        String temp1 = query.uniqueResult().toString();
        double orderje = Double.parseDouble(temp1);
        return orderje;
    }


    @Override
    public double getZhyeBySysid(String sysid) {
        Query query = getSession().createQuery(QUERY_ZHYE_BYSYSID);
        query.setParameter("sysid", sysid);
        double orderje = 0, zzje = 0;
        if (query.uniqueResult() != null) {
            String temp1 = query.uniqueResult().toString();
//            String temp2 = temp1.substring(0, temp1.indexOf(".") + 4);
            orderje = Double.parseDouble(temp1);
        }
        Query query2 = getSession().createQuery(QUERY_SUM_ZZ_BYSYSID);
        query2.setParameter("sysid", sysid);
        if (query2.uniqueResult() != null) {
            String temp1 = query2.uniqueResult().toString();
            zzje = Double.parseDouble(temp1);
        }
        return orderje - zzje;
    }

    @Override
    public List<TlkPhotographerEntity> GetSysFY(Integer page, Integer pagesize) {
        Query query = getSession().createQuery(FIND_ALL_SYS);
        query.setFirstResult((page - 1) * pagesize);
        query.setMaxResults(pagesize);
        return query.list();
    }

    @Override
    public List<SelectXJEntity> TestSql(){
        List SelectXJList = getSession().createSQLQuery(FIND_SYS_XJ).list();
        return SelectXJList;
    }

    @Override
    public List<SelectXJEntity> FingTwoSql() {

//        Query query = getSession().createQuery(FIND_SYS_XJ.toString());
//        query.setMaxResults(2);
//        return  query.list();
        List SelectXJList = getSession().createSQLQuery(FIND_TwoSYS_XJ).setMaxResults(2).list();
        return SelectXJList;
    }
}
