package com.lkp.service;

import com.lkp.entity.UserScanRecord;

import java.io.Serializable;

/**
 *
 */
public interface UserScanRecordService {
    Serializable save(UserScanRecord userScanRecord);
    UserScanRecord getById(String id);
    void release(String id);

}
