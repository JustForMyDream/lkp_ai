package com.lkp.service.impl;

import com.lkp.dao.XXJLDao;
import com.lkp.entity.TlkXxjlEntity;
import com.lkp.service.XXJLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class XXJLServiceImpl implements XXJLService {
    @Autowired
    XXJLDao xxjlDao;

    @Transactional
    public Serializable save(TlkXxjlEntity tlkXxjlEntity) {
        return xxjlDao.save(tlkXxjlEntity);
    }

    @Transactional
    public List getUnreadMsg(String yhbh) {
        return xxjlDao.getUnreadMsg(yhbh);
    }

    @Override
    public int getWeiDuMsg(String yhbh) {
        return xxjlDao.getWeiDuMsg(yhbh);
    }

    @Transactional
    public TlkXxjlEntity getById(Serializable id) {
        return xxjlDao.findById(id);
    }

    @Transactional
    public void updateMsgState(TlkXxjlEntity tlkXxjlEntity) {
        xxjlDao.update(tlkXxjlEntity);
    }

    @Transactional
    public void DeleteAllMsg(String yhbh) {
        xxjlDao.DeleteAllMsg(yhbh);
    }
    @Override
    public void DeleteMsg(String Msgid) {
        xxjlDao.DeleteMsg(Msgid);
    }



}
