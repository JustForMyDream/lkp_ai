package com.lkp.service.impl;

import com.lkp.dao.*;
;
import com.lkp.entity.*;
import com.lkp.service.EventTemplateService;
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
public class EventTemplateServiceImpl implements EventTemplateService {
    @Autowired
    TlkMhdxxEntityDao tlkMhdxxEntityDao;

    @Autowired
    TlkMhdxxbmEntityDao tlkMhdxxbmEntityDao;

    @Autowired
    TlkMhdzdEntityDao tlkMhdzdEntityDao;

    @Autowired
    TlkMhdbmzdEntityDao tlkMhdbmzdEntityDao;

    @Autowired
    UserWxbdDao userWxbdDao;

    @Override
    public TlkMhdxxEntity findHdxxPageById(String id, Date date) {
        return tlkMhdxxEntityDao.findMHdxxPageById(id,date);
    }

    @Override
    public List<TlkMhdzdEntity> findHdzdByHdbh(String Hdbh) {
        return tlkMhdzdEntityDao.findHdzdByHdbh(Hdbh);
    }

    @Override
    public List<TlkMhdbmzdEntity> findHdbmzdByHdbh(String Hdbh) {
        return tlkMhdbmzdEntityDao.findMhdbhzdByHdbh(Hdbh);
    }

    @Override
    public void saveBmxx(TlkMhdxxbmEntity tlkMhdxxbmEntity) {
        tlkMhdxxbmEntityDao.save(tlkMhdxxbmEntity);
    }

    @Override
    public TlkMhdxxbmEntity findByhdIdAndUserId(String Id, String UserId) {
        return tlkMhdxxbmEntityDao.findByhdIdAndUserId(Id,UserId);
    }

    @Override
    public List<TlkPtUserWxbdEntity> findAllCustomer() {
        return userWxbdDao.findAll();
    }

    @Override
    public List<TlkMhdxxbmEntity> findByUserOpenidandDate(String openid, Date date) {
        return tlkMhdxxEntityDao.findByUserOpenidandDate(openid,date);
    }

    @Override
    public void saveHDBM(TlkMhdxxbmEntity tlkMhdxxbmEntity) {
        tlkMhdxxbmEntityDao.update(tlkMhdxxbmEntity);
    }
}
