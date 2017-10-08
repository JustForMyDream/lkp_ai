package com.lkp.service;

import com.lkp.entity.*;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface EventService {
    TlkHdxxEntity getHdxxByHdBh(String hdbh);
    TlkHdxxbmEntity getHdxxbmById(String id);
    List<TlkHdxxEntity> getYhBmBYYhzf(String yhzf, Date date);
    List<TlkHdxxEntity> getSysBmBYSyszf(String syszf,Date date);
    public void saveYh(TlkHdxxbmEntity tlkHdxxbmEntity);
    public void saveSys(TlkHdxxbmEntity tlkHdxxbmEntity);
    TlkHdxxEntity FindYhPage(String yhzf);
    TlkHdxxEntity FindSysPage(String syszf);
    TlkHdxxbmEntity findByUserIdAndHdId(String userid,String hdid);
    TlkHdxxbmEntity findBySysIdAndHdId(String userid,String hdid);
    List<TlkPtUserWxbdEntity> findAllCustomer();
    List<TlkMhdxxEntity> findAllCustomerChar(String str , Date date ) ;
}
