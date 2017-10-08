package com.lkp.service.impl;

import com.lkp.dao.*;
import com.lkp.entity.*;
import com.lkp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class EventServiceImpl implements EventService{
    @Autowired
    TlkHdxxEntityDao tlkHdxxEntityDao;

    @Autowired
    TlkHdxxbmEntityDao tlkHdxxbmEntityDao;

    @Autowired
    TlkMhdbmzdEntityDao tlkMhdbmzdEntityDao;

    @Autowired
    UserWxbdDao userWxbdDao;
    @Autowired
    UserDao userDao;
    @Override
    public TlkHdxxEntity getHdxxByHdBh(String hdbh) {
        return tlkHdxxEntityDao.findHdxxByHdbh(hdbh);
    }

    @Override
    public TlkHdxxbmEntity getHdxxbmById(String id) {
        return tlkHdxxbmEntityDao.findHdxxbmById(id);
    }

    @Override
    public List<TlkHdxxEntity> getYhBmBYYhzf(String yhzf, Date date) {
        return tlkHdxxEntityDao.getYhBmBYYhzf(yhzf,date);
    }

    @Override
    public List<TlkHdxxEntity> getSysBmBYSyszf(String syszf,Date date) {
        return tlkHdxxEntityDao.getSysBmBYSyszf(syszf,date);
    }
    @Override
    public void saveYh(TlkHdxxbmEntity tlkHdxxbmEntity) {
        tlkHdxxbmEntityDao.save(tlkHdxxbmEntity);
    }
    @Override
    public void saveSys(TlkHdxxbmEntity tlkHdxxbmEntity) {
        tlkHdxxbmEntityDao.save(tlkHdxxbmEntity);
    }

    @Override
    public TlkHdxxEntity FindYhPage(String yhzf) {
        return tlkHdxxEntityDao.FindYhPage(yhzf);
    }

    @Override
    public TlkHdxxEntity FindSysPage(String syszf) {
        return tlkHdxxEntityDao.FindSysPage(syszf);
    }

    @Override
    public TlkHdxxbmEntity findByUserIdAndHdId(String userid, String hdid) {
        return tlkHdxxbmEntityDao.findByUserIdAndHdId(userid, hdid);
    }

    @Override
    public TlkHdxxbmEntity findBySysIdAndHdId(String userid, String hdid) {
        return tlkHdxxbmEntityDao.findByUserIdAndSysId(userid, hdid);
    }

    @Override
    public List<TlkPtUserWxbdEntity> findAllCustomer() {
        return userWxbdDao.findAll();
    }

    @Override
    public List<TlkMhdxxEntity> findAllCustomerChar(String str, Date date) {
        return tlkMhdbmzdEntityDao.findHdxx(str,date);
    }
}
