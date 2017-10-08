package com.lkp.service.impl;

import com.lkp.dao.TlkOrderproductEntityDao;
import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.dao.TlkOrderyingjiEntityDao;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;
import com.lkp.entity.TlkOrderyingjiEntity;
import com.lkp.service.PicturePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class PicturePayServiceImpl implements PicturePayService{
    @Autowired
    TlkOrderproductimgEntityDao tlkOrderproductimgEntityDao;

    @Autowired
    TlkOrderproductEntityDao tlkOrderproductEntityDao;

    @Autowired
    TlkOrderyingjiEntityDao tlkOrderyingjiEntityDao;

    @Override
    public void saveOrderproductimgAndOrderId(TlkOrderproductimgEntity tlkOrderproductimgEntity) {
        tlkOrderproductimgEntityDao.save(tlkOrderproductimgEntity);
    }

    @Override
    public List<TlkOrderproductimgEntity> getPicturesByOrderId(String OrderId) {
        return tlkOrderproductimgEntityDao.getPicturesByOrderId(OrderId) ;
    }

    @Override
    public void deletePicturesById(String pictureId) {
        tlkOrderproductimgEntityDao.deletePicturesById(pictureId);
    }

    @Override
    public TlkOrderproductEntity findOrderIdById(String id) {
        return tlkOrderproductEntityDao.findOrderIdById(id);
    }

    @Override
    public void saveYingByOrderId(TlkOrderyingjiEntity tlkOrderyingjiEntity) {
        tlkOrderyingjiEntityDao.save(tlkOrderyingjiEntity);
    }

    @Override
    public void updateOrderYingByOrderID(TlkOrderyingjiEntity tlkOrderyingjiEntity) {
        tlkOrderyingjiEntityDao.update(tlkOrderyingjiEntity);
    }

    @Override
    public TlkOrderyingjiEntity findOrderByOrderId(String OrderId) {
        return tlkOrderyingjiEntityDao.findOrderByOrderId(OrderId);
    }
}
