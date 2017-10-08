package com.lkp.dao.impl;

import com.lkp.dao.TlkProductshowpicEntityDao;
import com.lkp.entity.TlkProductshowpicEntity;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class TlkProductshowpicEntityDaoImpl extends BaseDaoImpl<TlkProductshowpicEntity> implements TlkProductshowpicEntityDao {
    String DELETE_ZUOPING_BY_ID = "delete from " +TlkProductshowpicEntity.class.getName()+" pic "+
            "where pic.tlkProductshowEntity.id=:id";
    @Override
    public void deleteZuopingById(String id) {

    }
}
