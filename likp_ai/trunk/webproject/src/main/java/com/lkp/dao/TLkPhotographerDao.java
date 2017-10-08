package com.lkp.dao;

import com.lkp.entity.OrderState;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.vo.SelectXJEntity;

import java.util.List;

/**
 *
 */
public interface TLkPhotographerDao extends BaseDao<TlkPhotographerEntity> {
    TlkPhotographerEntity getPhotoGrapherByOpenid(String openid);
    TlkPhotographerEntity getPhotoGrapherBySysid(String sysid);
    TlkPhotographerEntity getPhotoGrapherByID(String ID);
    List<TlkOrderproductEntity> getPhotographerOrderListByBh(String itemBh);
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
     * 得到某种状态的摄影师订单数量
     * @param state
     * @param sysid
     * @return
     */
    long getOrderCountByStateSysId(OrderState state, String sysid);


    /**
     * 得到某种状态的摄影师订单列表
     * @param state
     * @param sysid
     * @return
     */
    List<TlkOrderproductEntity> getOrderByStateSysId(OrderState state,String sysid);

    /**
     * 查询摄影师订单列表，只查orderproduct表
     * @param sysid
     * @return
     */
    List<TlkOrderproductEntity> getOrderListOnlyOne(String sysid);

    List<TlkOrderproductEntity> getOrderListBySysid(String sysid);

    int getOrderNumBySysid(String sysid);
    /**
     * 查询摄影师所有订单数量
     * @param sysid
     * @return
     */
    long getCountAllOrder(String sysid);

    /**
     * 通过摄影师编号得到摄影师历史转账总金额,现阶段转账总金额等于收入
     * @param sysid
     * @return
     */
    double getHisZzSum(String sysid);

    /**
     * 得到摄影师账户余额
     * @param sysid
     * @return
     */
    double getZhyeBySysid(String sysid);


    /**
     * 得到订单收入
     * @param sysid
     * @return
     */
    double getIncome(String sysid);


    /**
     * 分页查询摄影师
     *
     * @param page
     * @param pagesize
     * @return
     */
    List<TlkPhotographerEntity> GetSysFY(Integer page, Integer pagesize);

    List <SelectXJEntity>TestSql();

    List <SelectXJEntity>FingTwoSql();
}
