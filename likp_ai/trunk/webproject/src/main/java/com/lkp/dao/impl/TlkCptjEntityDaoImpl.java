package com.lkp.dao.impl;

import com.lkp.dao.TlkCptjEntityDao;
import com.lkp.entity.TlkCptjEntity;
import com.lkp.entity.TlkProductEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class TlkCptjEntityDaoImpl extends BaseDaoImpl<TlkCptjEntity> implements TlkCptjEntityDao {

    String getTjProductInfor = " from "+TlkCptjEntity.class.getName()+" p " +
            ", "+ TlkProductEntity.class.getName()+" o "+
            "where (o.id=p.itemCpbh " +
            "OR (p.itemSfwl='1' and p.itemWllj is not null) )" +
            "And p.itemSfzs='1' " +
            "group by p.id" +
            " ORDER BY p.itemZsxh" ;

    @Override
    public List<TlkCptjEntity> getTjProductInfor() {
        Query query = getSession().createQuery(getTjProductInfor);
        return  query.list();
    }
}
