package com.lkp.service;

import com.lkp.entity.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 */
public interface OrderService {
    /**
     * 创建订单\
     * @param userid 用户编号
     * @param productId 产品编号
     * @param orderDate 预约日期
     * @param username 用户姓名
     * @param phone 预约地那好
     * @param address 大概地址
     * @param detailposition 详细地址
     * @return 订单编号
     */
    Serializable creatOrder(String userid,String productId, Date orderDate, String username, String phone, String sex,String address, String detailposition);

    /**
     * 通过订单主键获取微信支付prepay——id
     * @param id
     * @return
     */
    String create_prepay_id_by_id(String id,String ip);

    /**
     * 通过订单号获取微信支付prepay——id
     * @param orderid
     * @return
     */
    String create_prepay_id_by_orderId(String orderid);

    /**
     * 通过订单编号获取订单信息
     * @param id 订单编号
     * @return
     */
    TlkOrderproductEntity findOrderProductById(String id);

    TlkOrderproductEntity findById(String id);

    /**
     * 通过商户订单号out_trade_no/或微信支付订单号transaction_id更新订单支付信息
     * @param out_trade_no
     * @param transaction_id
     */
    boolean updateOrderPayState(String out_trade_no, String transaction_id);

    /**
     * 通过用户编号获取用户订单
     * @param userId
     * @return
     */
    List<TlkOrderproductEntity> getOrdersByUserBH(String userId);

    TlkOrderproductimgEntity getOrderimgByImgid(String imgid);

    /**
     * 通过订单编号获取订单相关联的成片
     * @param id 订单编号
     * @return
     */
    List<TlkOrderproductimgEntity> getImgById(String id);

    /**
     * 通过userid获得用户的相册
     * @param userid 订单编号
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

    /**
     * 更新订单状态
     * @param id 订单编号
     * @param ordersate    订单状态
     */
    void updateOrderSate(String id, OrderState ordersate);

    TlkOrderproductimgEntity getOrderproductimgById(Serializable id);

    Serializable saveOrderYingji(TlkOrderyingjiEntity orderyingjiEntity);

    void orderstateChangeTempleMessage(TlkOrderproductEntity tlkOrderproductEntity,OrderState orderState);
    boolean updateOrderDate(String id,Date date);
    boolean updateOrderPosition(String id,String position);
    boolean updateOrderDetailPosition(String id,String detailposition);
//
//    /**
//     * 通过摄影师id得到订单信息
//     */
//    List<TlkOrderproductEntity> getOrdersBySysid(String id);
    boolean updateSyspj(String id, String num,String btn,String words,Date date);
}
