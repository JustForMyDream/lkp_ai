package com.lkp.service.impl;

import com.lkp.dao.OrderproductDao;
import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.entity.OrderState;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;
import com.lkp.service.OrderService;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.OrderproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by wanggan on 2016/11/11.
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
        return  orderproductDao.findById(id).getItemUserid().getWechatInfo().iterator().next().getTlkWechatuserEntity();
    }

    public List<TlkOrderproductEntity> findAllOrderproduct() {
        return orderproductDao.findAllOrderproduct();
    }

}
