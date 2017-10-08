package com.lkp.dao.impl;

import com.lkp.dao.Qrcode_sqlDao;
import com.lkp.entity.Qrcode_sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wanggan on 2016/11/4.
 */
@Repository
public class QrcodeDaoImpl extends BaseDaoImpl<Qrcode_sql> implements Qrcode_sqlDao {

    public Qrcode_sql getID() {
        List<Qrcode_sql> access_tokenList = getSession().createQuery("from "+Qrcode_sql.class.getName() + " a order by a.updateDate desc "
        ).setMaxResults(1).list();
        if(access_tokenList.size()==1){
            return access_tokenList.get(0);
        }
        return null;
    }
}
