package com.lkp.dao;

import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderyingjiEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 *
 */
public interface OrderproductDao extends BaseDao<TlkOrderproductEntity> {
    /**
     * 通过订单编号获取订单信息
     * @param orderid 订单编号
     * @return
     */
    TlkOrderproductEntity findOrderProductByOrderid(String orderid);

    /**
     * 通过用户编号获取订单列表
     * @param openid
     * @return
     */
    List<TlkOrderproductEntity> getOrdersByUserOpenid(String openid);

    /**
     * 通过订单id编号获取订单信息
     * @param id 订单编号
     * @return
     */
    TlkOrderproductEntity findOrderProductById(String id);

    /**
     * 通过摄影师编号获取订单列表
     * @param sysbh
     * @return
     */
    List<TlkOrderproductEntity> findOrderProductBySySBH(String sysbh);
    /**
     * 判断订单是否存在与影集相同的编号*/
    List<TlkOrderyingjiEntity> judgeOrder(String id);


}
