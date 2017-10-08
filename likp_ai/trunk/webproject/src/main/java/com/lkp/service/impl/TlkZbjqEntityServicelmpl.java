package com.lkp.service.impl;

import com.lkp.dao.TlkZbjqEntityDao;
import com.lkp.entity.TlkZbjqEntity;
import com.lkp.service.TlkZbjqEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 *
 */
@Service
@Transactional
public class TlkZbjqEntityServicelmpl implements TlkZbjqEntityService {
    @Autowired
    TlkZbjqEntityDao tlkZbjqEntityDao;
    @Override
    public TlkZbjqEntity getZbjqInfobyid(String id) {
        return tlkZbjqEntityDao.getZbjqInfobyid(id);
    }

    @Override
    public List<TlkZbjqEntity> findAll() {
        return tlkZbjqEntityDao.findALLZbjq();
    }

}
