package com.lkp.service.impl;

import com.lkp.dao.UserWxInfoDao;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.UserWxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wanggan on 2016/11/5.
 */
@Service
public class UserWxInfoServiceImpl implements UserWxInfoService {

    @Autowired
    UserWxInfoDao userWxInfoDao;

    @Transactional
    public TlkWechatuserEntity getByOpenid(String openid) {
        return userWxInfoDao.getByOpenid(openid);
    }
}
