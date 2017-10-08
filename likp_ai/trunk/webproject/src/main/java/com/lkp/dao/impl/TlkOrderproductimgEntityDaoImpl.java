package com.lkp.dao.impl;

import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.entity.TlkOrderproductimgEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkOrderproductimgEntityDaoImpl extends BaseDaoImpl<TlkOrderproductimgEntity> implements TlkOrderproductimgEntityDao {
    String GET_PICTURES_BY_ORDERID = "from " + TlkOrderproductimgEntity.class.getName()+ " OPI"+
            " where OPI.parent = :OrderId";

    String DELETE_PICTURES_BY_ID = "delete from "+ TlkOrderproductimgEntity.class.getName()+ " OPI"+
            " where OPI.id = :pictureId";

    @Override
    public List<TlkOrderproductimgEntity>  getPicturesByOrderId(String OrderId) {
        Query query =  getSession().createQuery(GET_PICTURES_BY_ORDERID);
        query.setParameter("OrderId",OrderId);
        return query.list();
    }

    @Override
    public void deletePicturesById(String pictureId) {
        Query query = getSession().createQuery(DELETE_PICTURES_BY_ID);
        query.setParameter("pictureId",pictureId);
        query.executeUpdate();
    }
}
