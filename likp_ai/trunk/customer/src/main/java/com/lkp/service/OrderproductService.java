package com.lkp.service;

import com.lkp.entity.OrderState;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;
import com.lkp.entity.TlkWechatuserEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by wanggan on 2016/11/11.
 */
public interface OrderproductService {
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
     * 根据摄影师编号获取订单列表
     * @param sysbh
     * @return
     */
    List<TlkOrderproductEntity> findOrderProductBySySBH(String sysbh);

    /**
     * 保存订单图片
     * @param orderproductimgEntity
     * @return
     */
    Serializable SaveOrderPic(TlkOrderproductimgEntity orderproductimgEntity);

    /**
     * 更新订单状态
     * @param id 订单id
     * @param orderState 要更新的状态
     */
    void updateOrderSate(String id, OrderState orderState);
    /**
     * 判断订单产品是否有相同的影集编号*/
    List findOrderJudge(String id);
    /**
     *判断摄影师是否上传照片*/
   public Set<TlkOrderproductimgEntity> findOrderImg(String id);
    /**
     * 得到用户下单时的基本信息*/
    public TlkWechatuserEntity findWechatuser(String id);

    /**
     * 查询所有订单
     * @return
     */
    List<TlkOrderproductEntity> findAllOrderproduct();
}
