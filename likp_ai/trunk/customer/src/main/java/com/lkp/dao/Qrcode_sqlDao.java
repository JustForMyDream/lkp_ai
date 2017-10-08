package com.lkp.dao;

import com.lkp.entity.Qrcode_sql;
import com.lkp.entity.TlkOrderproductEntity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wanggan on 2016/11/4.
 */
public interface Qrcode_sqlDao extends  BaseDao<Qrcode_sql> {
    Qrcode_sql getID();
}
