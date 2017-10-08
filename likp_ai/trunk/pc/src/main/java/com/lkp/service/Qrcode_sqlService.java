package com.lkp.service;

import com.lkp.entity.Qrcode_sql;

import java.io.Serializable;

/**
 *
 */
public interface Qrcode_sqlService {
    Qrcode_sql getQrcode(String access_token);
    Serializable save(Qrcode_sql qrcode_sql);
}
