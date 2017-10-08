package com.lkp.dao;

import com.lkp.entity.TlkHdxxEntity;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface TlkHdxxEntityDao extends BaseDao<TlkHdxxEntity> {
    TlkHdxxEntity findHdxxByHdbh(String Hdxx);
    List<TlkHdxxEntity> getYhBmBYYhzf(String yhzf, Date date);
    List<TlkHdxxEntity> getSysBmBYSyszf( String syszf,Date date);
    TlkHdxxEntity FindYhPage(String yhzf);
    TlkHdxxEntity FindSysPage(String syszf);
}
