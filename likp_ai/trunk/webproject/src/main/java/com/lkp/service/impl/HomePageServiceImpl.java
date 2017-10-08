package com.lkp.service.impl;

import com.lkp.dao.TlkCptjEntityDao;
import com.lkp.dao.TlkHzhbglEntityDao;
import com.lkp.dao.TlkLbglEntityDao;
import com.lkp.dao.TlkSystjEntityDao;
import com.lkp.entity.TlkCptjEntity;
import com.lkp.entity.TlkHzhbglEntity;
import com.lkp.entity.TlkLbglEntity;
import com.lkp.entity.TlkSystjEntity;
import com.lkp.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    TlkLbglEntityDao tlkLbglEntityDao;

    @Autowired
    TlkSystjEntityDao tlkSystjEntityDao;

    @Autowired
    TlkCptjEntityDao tlkCptjEntityDao;

    @Autowired
    TlkHzhbglEntityDao tlkHzhbglEntityDao;

    @Override
    public List<TlkLbglEntity> findAllLbgl() {
        return tlkLbglEntityDao.getLbtpOrderByPxxh();
    }

    @Transactional
    public List<TlkSystjEntity> findAllSysInforBySysBh() {
        return tlkSystjEntityDao.getSysInforBySysBH();
    }


    @Transactional
    public List<TlkSystjEntity> findTwoSysInforBySysBh() {
        return tlkSystjEntityDao.getTwoSysInforBySysBH();
    }

    @Override
    public List<TlkCptjEntity> findTjProductInfor() {
        return tlkCptjEntityDao.getTjProductInfor();
    }

    @Override
    public List<TlkHzhbglEntity> findAllHZHB() {
        return tlkHzhbglEntityDao.getAllHZHB();
    }


}
