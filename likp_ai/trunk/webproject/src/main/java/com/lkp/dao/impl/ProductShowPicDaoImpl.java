package com.lkp.dao.impl;

import com.lkp.dao.ProductShowPicDao;
import com.lkp.entity.TlkProductshowpicEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class ProductShowPicDaoImpl extends BaseDaoImpl<TlkProductshowpicEntity> implements ProductShowPicDao {

    @Override
    public List<TlkProductshowpicEntity> getAllPicsByZuopingID(String id) {
        return null;
    }
}
