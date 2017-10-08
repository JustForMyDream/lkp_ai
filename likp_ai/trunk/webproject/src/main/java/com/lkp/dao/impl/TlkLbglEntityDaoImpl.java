package com.lkp.dao.impl;

import com.lkp.dao.TlkLbglEntityDao;
import com.lkp.entity.TlkLbglEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkLbglEntityDaoImpl extends BaseDaoImpl<TlkLbglEntity> implements TlkLbglEntityDao {

    String  getLbtpOrderByPxxh = " from "+TlkLbglEntity.class.getName()+" p " +
            " ORDER BY p.itemPxxh" ;

    @Override
    public List<TlkLbglEntity> getLbtpOrderByPxxh() {
        Query query = getSession().createQuery(getLbtpOrderByPxxh);
        return  query.list();
    }
}
