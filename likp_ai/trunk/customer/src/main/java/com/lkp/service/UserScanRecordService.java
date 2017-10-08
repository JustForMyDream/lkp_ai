package com.lkp.service;

import com.lkp.entity.UserScanRecord;

import java.io.Serializable;

/**
 * Created by wanggan on 2016/11/5.
 */
public interface UserScanRecordService {
    Serializable save(UserScanRecord userScanRecord);
    UserScanRecord getById(String id);
    void release(String id);

}
