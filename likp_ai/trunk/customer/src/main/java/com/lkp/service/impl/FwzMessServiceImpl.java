package com.lkp.service.impl;

import com.lkp.dao.TlkFwzEntityDao;
import com.lkp.service.FwzMessService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 1010 on 2017/1/20.
 */
public class FwzMessServiceImpl implements FwzMessService {

    @Autowired
    TlkFwzEntityDao tlkFwzEntityDao;

    public TlkFwzEntity findFwzMessageById(String ID) {
        return tlkFwzEntityDao.findFwzMessageById(ID) ;
    }
}
