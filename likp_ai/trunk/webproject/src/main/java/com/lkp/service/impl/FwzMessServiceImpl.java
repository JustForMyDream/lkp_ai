package com.lkp.service.impl;

import com.lkp.dao.TlkFwzEntityDao;
import com.lkp.entity.TlkFwzEntity;
import com.lkp.service.FwzMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class FwzMessServiceImpl implements FwzMessService {

    @Autowired
    TlkFwzEntityDao tlkFwzEntityDao;

    public TlkFwzEntity findFwzMessageById(String ID) {
        return tlkFwzEntityDao.findFwzMessageById(ID) ;
    }

    @Override
    public List<TlkFwzEntity> findAll() {
        return tlkFwzEntityDao.findALLFwz();
    }
}
