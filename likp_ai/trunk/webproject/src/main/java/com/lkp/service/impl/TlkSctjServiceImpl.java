package com.lkp.service.impl;

import com.lkp.dao.TlkSctjDao;
import com.lkp.entity.TlkSctjEntity;
import com.lkp.service.TlkSctjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class TlkSctjServiceImpl implements TlkSctjService{
    @Autowired
    private TlkSctjDao tlkSctjDao;
    @Transactional
    public TlkSctjEntity find(Serializable id) {
        return tlkSctjDao.getsctiByid(id);
    }

    @Override
    public List<TlkSctjEntity> findAll() {
        return tlkSctjDao.getALlSctj();
    }

}
