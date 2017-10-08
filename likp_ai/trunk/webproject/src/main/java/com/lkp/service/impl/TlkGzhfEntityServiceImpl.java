package com.lkp.service.impl;

import com.lkp.dao.TlkGzhfEntityDao;
import com.lkp.entity.TlkGzhfEntity;
import com.lkp.service.TlkGzhfEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class TlkGzhfEntityServiceImpl implements TlkGzhfEntityService {
    @Autowired
    TlkGzhfEntityDao gzhfEntityDao;
    @Override
    public List<TlkGzhfEntity> findAll() {
        return gzhfEntityDao.findAll();
    }
}
