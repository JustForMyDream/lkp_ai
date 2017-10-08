package com.lkp.dao.impl;

import com.lkp.dao.ProductDao;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkProductEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 产品Dao层实现
 */
@Repository
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<TlkProductEntity> implements ProductDao {
    String queryProduct = "from " + TlkProductEntity.class.getName() + " p " +
            "join fetch p.tlkProductshowEntities s " +
            "join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "left join fetch s.tlkProductshowpicEntities";
    String queryProductById = "select distinct p " +
            "from " + TlkProductEntity.class.getName() + " p " +
            "left join fetch p.tlkProductshowEntities s " +
            "left join fetch s.tlkProductshowpicEntities " +
            "left join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "where p.id=:id";

    String getProductBySysid = "select distinct p " +
            "from " + TlkProductEntity.class.getName() + " p " +
            "where p.itemSys=:id";

    String getZuoyeInforBySysid = "select distinct p " +
            "from " + TlkProductEntity.class.getName() + " p " +
            "join fetch p.tlkProductshowEntities s " +
            "join fetch s.tlkProductshowpicEntities " +
            "join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "where p.itemSys=:id and p.itemCpzt='上线'";

    String getQueryProductByCpbh = "select distinct p " +
            "from " + TlkProductEntity.class.getName() + " p " +
            "join fetch p.tlkProductshowEntities s " +
            "join fetch s.tlkProductshowpicEntities " +
            "join fetch p.tlkCpfwxqEntitys " +
            "left join fetch p.itemZsyj yj " +
            "left join fetch yj.tlkYingjipicEntities " +
            "where p.itemCpbh=:itemCpbh";
    String  getProdutOderderByCount = "SELECT p " +
            " from "+TlkProductEntity .class.getName()+" p " +
            "left join fetch p.tlkProductshowEntities " +
            ", "+ TlkOrderproductEntity.class.getName()+" o "+
            "where o.itemProductid=p.itemCpbh " +
            "and p.itemCpzt='上线'" +
            " GROUP BY p.itemCpbh" +
            " ORDER BY count(o) desc " ;
    String COLLECTION_PRODUCT_LIST = "from " + TlkProductEntity.class.getName() + " p " +
            "where p.id=:id";
    String GET_PRODUCT_BYHDBH="from "+ TlkProductEntity.class.getName() + " p " +
            "where p.itemHdbh=:itemHdbh";
    String getQueryProductBySys = "from "+TlkProductEntity.class.getName()+" p "+
            "where p.itemSys=:itemSys";

    String getProductNum = "select SUM(IF(p.ITEM_SHZT='2',1,0)) AS SHZT,SUM(IF(p.ITEM_CPZT ='上线',1,0)) AS SXCP FROM \n "+
            "tlk_product p\n "+
            "where p.ITEM_SYS=:itemSys";


    public List<TlkProductEntity> getProducts(Integer page, Integer pagesize) {
        Query query = getSession().createQuery(queryProduct);
        query.setFirstResult((page - 1) * pagesize);
        query.setMaxResults(page * pagesize);
        return query.list();
    }

    public TlkProductEntity getProdctsById(Serializable id) {
        Query query = getSession().createQuery(queryProductById);
        query.setParameter("id", id);
        return (TlkProductEntity) query.uniqueResult();
    }

    @Override
    public List<TlkProductEntity> getProductsBySysId(Serializable id) {
        Query query = getSession().createQuery(getProductBySysid);
        query.setParameter("id", id);
        return query.list();
    }



    @Override
    public List<TlkProductEntity> getZuoyeInforBySysid(Serializable id) {
        Query query = getSession().createQuery(getZuoyeInforBySysid);
        query.setParameter("id",id);
        return query.list();
    }

    @Override
    public TlkProductEntity getProdctsByCPBH(String cpbh) {
        Query query = getSession().createQuery(getQueryProductByCpbh);
        query.setParameter("itemCpbh", cpbh);
        return (TlkProductEntity) query.uniqueResult();
    }

    @Override
    public List<TlkProductEntity> getProdutOderderByCount() {
        Query query = getSession().createQuery(getProdutOderderByCount);
        return  query.list();
    }

    @Override
    public TlkProductEntity getCollectionProduct(String id) {
        Query query = getSession().createQuery(COLLECTION_PRODUCT_LIST);
        query.setParameter("id",id);
        return (TlkProductEntity) query.uniqueResult();
    }

    @Override
    public TlkProductEntity getProductByHDBH(String hdbh) {
        Query query = getSession().createQuery(GET_PRODUCT_BYHDBH);
        query.setParameter("itemHdbh",hdbh);
        query.setMaxResults(1);
        return (TlkProductEntity) query.uniqueResult();
    }

    @Override
    public List<TlkProductEntity> getProductBySys(String itemSys) {
        Query query = getSession().createQuery(getQueryProductBySys);
        query.setParameter("itemSys",itemSys);
        return query.list();
    }

//    @Override
//    public List<TlkProductEntity> getProductNum(String itemSys) {
//        Query query = getSession().createSQLQuery(getProductNum);
//        query.setParameter("itemSys",itemSys);
//        return query.list();
//    }

    @Override
    public List<TlkProductEntity> getProductNum(String itemSys) {

//        Query query = getSession().createQuery(FIND_SYS_XJ.toString());
//        query.setMaxResults(2);
//        return  query.list();
        Query TlkProductList = getSession().createSQLQuery(getProductNum);
        TlkProductList.setParameter("itemSys",itemSys);
        return TlkProductList.list();
    }


}
