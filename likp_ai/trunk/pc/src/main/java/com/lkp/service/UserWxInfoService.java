package com.lkp.service;

import com.lkp.entity.TlkWechatuserEntity;

/**
 *
 */
public interface UserWxInfoService {
    TlkWechatuserEntity getByOpenid(String openid);
}
