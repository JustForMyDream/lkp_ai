package com.lkp.dao;

import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;

import java.util.List;

/**
 *
 */
public interface OrderDao extends BaseDao<TlkOrderproductEntity> {
    /**
     * 通过订单编号获取订单信息
     * @param orderid 订单编号
     * @return
     */
    TlkOrderproductEntity findOrderProductByOrderid(String orderid);

    /**
     * 通过用户编号获取订单列表
     * @param userbh
     * @return
     */
    List<TlkOrderproductEntity> getOrdersByUserbh(String userbh);

    /**
     * 通过订单id编号获取订单信息
     * @param id 订单编号
     * @return
     */
    TlkOrderproductEntity findOrderProductById(String id);


    /**
     * 通过订单编号获取订单相关联的成片
     * @param id 订单编号
     * @return
     */
    List<TlkOrderproductimgEntity> getImgById(String id);

    /**
     * 通过userid获取用户的订单列表
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getOrderImgList(String userid);


    /**
     * 通过userid获取用户未完成订单
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getUnfinishOrder(String userid);


    /**
     * 通过userid获取用户已完成订单
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getfinishOrder(String userid);


    /**
     * 通过userid获取用户取消订单
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getCanceledOrder(String userid);
}
