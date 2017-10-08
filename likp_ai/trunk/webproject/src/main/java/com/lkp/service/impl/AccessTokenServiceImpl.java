package com.lkp.service.impl;

import com.lkp.dao.TlkWechatAccesstokenEntityDao;
import com.lkp.dao.TlkWechatJsticketEntityDao;
import com.lkp.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    TlkWechatAccesstokenEntityDao accesstokenEntityDao;

    @Autowired
    TlkWechatJsticketEntityDao jsticketEntityDao;
    @Override
    public String getAccessToken() {
        return accesstokenEntityDao.getTlkWechatAccesstokenEntity().getItemAccessToken();
    }

    @Override
    public String getJsticket() {
        return jsticketEntityDao.getNewestTicket().getItemTicket();
    }
}
