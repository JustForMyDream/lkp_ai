package com.lkp.service.impl;

import com.lkp.dao.TlkWechatuserEntityDao;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.TlkWechatuserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class TlkWechatuserEntityServiceImpl implements TlkWechatuserEntityService {
    @Autowired
    TlkWechatuserEntityDao tlkWechatuserEntityDao;

    @Transactional
    public void saveOrupdate(TlkWechatuserEntity tlkWechatuserEntity) {
        tlkWechatuserEntityDao.saveOrupdate(tlkWechatuserEntity);
    }

    @Override
    public List<TlkWechatuserEntity> findAll() {
        return tlkWechatuserEntityDao.findAll();
    }

    @Override
    public TlkWechatuserEntity findByUserbh(String userbh) {
        return tlkWechatuserEntityDao.findByUserBh(userbh);
    }

    @Override
    public TlkWechatuserEntity findByid(String id) {
        return tlkWechatuserEntityDao.findById(id);
    }
}
