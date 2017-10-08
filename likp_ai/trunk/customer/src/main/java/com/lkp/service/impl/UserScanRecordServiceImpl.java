package com.lkp.service.impl;

import com.lkp.dao.UserScanRecordDao;
import com.lkp.entity.UserScanRecord;
import com.lkp.service.UserScanRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by wanggan on 2016/11/5.
 */
@Service
public class UserScanRecordServiceImpl implements UserScanRecordService {

    @Autowired
    UserScanRecordDao userScanRecordDao;

    @Transactional
    public Serializable save(UserScanRecord userScanRecord) {
        return userScanRecordDao.save(userScanRecord);
    }

    @Transactional
    public UserScanRecord getById(String id) {
        return userScanRecordDao.findById(id);
    }

    @Transactional
    public void release(String id) {
        UserScanRecord userScanRecord = userScanRecordDao.findById(id);
        userScanRecord.setUsed(true);
        userScanRecordDao.update(userScanRecord);
    }
}
