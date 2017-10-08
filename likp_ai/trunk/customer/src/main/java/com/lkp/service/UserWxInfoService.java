package com.lkp.service;

import com.lkp.entity.TlkWechatuserEntity;

/**
 * Created by wanggan on 2016/11/5.
 */
public interface UserWxInfoService {
    TlkWechatuserEntity getByOpenid(String openid);
}
