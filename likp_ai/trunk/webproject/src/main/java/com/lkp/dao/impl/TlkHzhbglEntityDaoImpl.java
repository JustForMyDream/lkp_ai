package com.lkp.dao.impl;

import com.lkp.dao.TlkHzhbglEntityDao;
import com.lkp.entity.TlkHzhbglEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class TlkHzhbglEntityDaoImpl extends BaseDaoImpl<TlkHzhbglEntity> implements TlkHzhbglEntityDao {

    String GET_ALL_HZHB = " from "+TlkHzhbglEntity.class.getName()+" p " +
            "where p.itemSfzs='1'" +
            " ORDER BY p.itemZsxh" ;
    @Override
    public List<TlkHzhbglEntity> getAllHZHB() {
        Query query = getSession().createQuery(GET_ALL_HZHB);
        return  query.list();
    }
}
