package com.lkp.service.impl;

import com.cxt.wechat.entity.qrcode.Action_info;
import com.cxt.wechat.entity.qrcode.Action_name;
import com.cxt.wechat.entity.qrcode.Qrcode;
import com.cxt.wechat.qrcode.QrcodeImpl;
import com.google.gson.Gson;
import com.lkp.dao.Qrcode_sqlDao;
import com.lkp.entity.Qrcode_sql;
import com.lkp.service.Qrcode_sqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 *
 */

@Service
public class Qrcode_sqlServiceImpl implements Qrcode_sqlService {

    @Autowired
    Qrcode_sqlDao qrcode_sqlDao;


    @Transactional
    public Qrcode_sql getQrcode(String access_token) {
        //通过access_token创建tiket;
        //讲相应的数据保存进入数据库
        //然后得到Qrcode_sql对象进行返回
        QrcodeImpl qrcodeImpl = new QrcodeImpl();
        Qrcode qrcode = new Qrcode();

        //设置qrcode
        qrcode.setExpire_seconds(2592000);
        qrcode.setAction_name(Action_name.QR_SCENE);
        //设置Action_info scene_id
        String scene_id = getRandomString_NUM(9);
        Action_info action_info = new Action_info(Integer.parseInt(scene_id));

        qrcode.setAction_info(action_info);
        //解析返回的字符串
        String result = qrcodeImpl.create(qrcode, access_token);
        Qrcode_sql qrcode_sql = new Gson().fromJson(result, Qrcode_sql.class);
        //成功返回
        if (qrcode_sql.getTicket() != null) {
            Qrcode_sql qrcode_sql1 = new Qrcode_sql();
            qrcode_sql1.setExpire_seconds(qrcode_sql.getExpire_seconds());
            qrcode_sql1.setSceneId(scene_id);
            qrcode_sql1.setTicket(qrcode_sql.getTicket());
            qrcode_sql1.setUrl(qrcode_sql.getUrl());
            qrcode_sql1.setUseful(true);
            //设置超时时间
            Date date = new Date();
            Date date1 = new Date(date.getTime() + (2592000 * 1000));
            qrcode_sql1.setOverDate(date1);
            qrcode_sql1.setUpdateDate(date);
            qrcode_sql1.setVersion(1);
            String id = (String) qrcode_sqlDao.save(qrcode_sql1);
            System.out.println("保存信息成功");
            return qrcode_sqlDao.findById(id);
        } else {

            return null;
        }

    }

    @Transactional
    public Serializable save(Qrcode_sql qrcode_sql) {
        Serializable id = qrcode_sqlDao.save(qrcode_sql);
        return id;
    }

    public static String getRandomString_NUM(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(9);
            sb.append(str.charAt(number));
        }

        return sb.toString();
    }
}
