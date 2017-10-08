package com.lkp.service.impl;

import com.lkp.dao.OrderproductDao;
import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.entity.*;
import com.lkp.service.OrderService;
import com.lkp.service.OrderproductService;
import com.lkp.service.SYSUPloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
@Transactional
public class OrderproductServiceImpl implements OrderproductService {

    @Autowired
    OrderproductDao orderproductDao;

    @Autowired
    TlkOrderproductimgEntityDao orderproductimgEntityDao;

    @Autowired
    OrderService orderService;

    public TlkOrderproductEntity findOrderProductByOrderid(String orderid) {
        return orderproductDao.findOrderProductByOrderid(orderid);
    }

    public List<TlkOrderproductEntity> getOrdersByUserOpenid(String openid) {
        return orderproductDao.getOrdersByUserOpenid(openid);
    }


    public TlkOrderproductEntity findOrderProductById(String id) {
        return orderproductDao.findOrderProductById(id);
    }

    public List<TlkOrderproductEntity> findOrderProductBySySBH(String sysbh) {
        return orderproductDao.findOrderProductBySySBH(sysbh);
    }

    public Serializable SaveOrderPic(TlkOrderproductimgEntity orderproductimgEntity) {
        return orderproductimgEntityDao.save(orderproductimgEntity);
    }

    public void updateOrderSate(String id, OrderState orderState) {
        TlkOrderproductEntity orderproductEntity = orderproductDao.findOrderProductById(id);
        orderproductEntity.setItemState(orderState);
        orderService.orderstateChangeTempleMessage(orderproductEntity,orderState);
    }

    public List findOrderJudge(String id) {
        return  orderproductDao.judgeOrder(id);
    }

    public Set<TlkOrderproductimgEntity> findOrderImg(String id) {
        return findOrderProductById(id).getOrderproductimgEntities();
    }

    public TlkWechatuserEntity findWechatuser(String id) {
        TlkOrderproductEntity orderproductEntity = orderproductDao.findById(id);
        TlkUserEntity userEntity = orderproductEntity.getItemUserid();
        TlkUserwechatinfoEntity userwechatinfoEntity = userEntity.getWechatInfo().iterator().next();
        return  userwechatinfoEntity.getTlkWechatuserEntity();
    }

}
