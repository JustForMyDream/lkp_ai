package com.lkp.service;

import com.lkp.entity.*;
import com.lkp.entity.vo.SelectXJEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface TLkPhotograoherService {
    TlkPhotographerEntity getPhotographerByOpenid(String openid);

    TlkPhotographerEntity getPhotographerBySysid(String sysid);

    TlkPhotographerEntity getPhotoGrapherByID(String id);

    List<TlkOrderproductEntity> getPhotographerOrderListByBh(String itemBh);

    /**
     * 通过userid获取用户未完成订单
     *
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getUnfinishOrder(String userid);


    /**
     * 通过userid获取用户已完成订单
     *
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getfinishOrder(String userid);


    /**
     * 通过userid获取用户取消订单
     *
     * @param userid
     * @return
     */

    List<TlkOrderproductEntity> getCanceledOrder(String userid);

    Serializable saveHdSys(TlkPhotographerEntity tlkPhotographerEntity);

    TlkPhotographerEntity findById(Serializable id);

    /**
     * 得到某种状态的摄影师订单数量
     *
     * @param state
     * @param sysid
     * @return
     */
    int getOrderCountByStateSysId(OrderState state, String sysid);

    /**
     * 得到某种状态的摄影师订单列表
     *
     * @param state
     * @param sysid
     * @return
     */
    List<TlkOrderproductEntity> getOrderByStateSysId(OrderState state, String sysid);

    /**
     * 查询摄影师订单列表，只查orderproduct表
     *
     * @param sysid
     * @return
     */
    List<TlkOrderproductEntity> getOrderListOnlyOne(String sysid);

    List<TlkOrderproductEntity> getOrderBySysId(String sysid);

    /**
     * 查询摄影师评价数量
     */
   int getOrderNumBySysId(String sysid);

    /**
     * 查询摄影师所有订单数量
     *
     * @param sysid
     * @return
     */
    int getCountAllOrder(String sysid);

    void UpdateSysInfo(TlkPhotographerEntity tlkPhotographerEntity);

    /**
     * 通过摄影师编号得到摄影师历史转账总金额,现阶段转账总金额等于收入
     *
     * @param sysid
     * @return
     */
    double getHisZzSum(String sysid);

    /**
     * 得到摄影师账户余额
     *
     * @param sysid
     * @return
     */
    double getZhyeBySysid(String sysid);

    /**
     *得到订单收入
     */
    double getIncome(String sysid);

    List<TlkPhotographerEntity> GetAllSys();

    /**
     * 分页得到所有摄影师
     *
     * @param page
     * @param pagesize
     * @return
     */
    List<TlkPhotographerEntity> GetSysFY(Integer page, Integer pagesize);

    /**
     * 给摄影师转账
     * @param tlkOrderproductEntity
     */
    public String SysTransform(TlkOrderproductEntity tlkOrderproductEntity);

    /**
     * 创建作品
     * @param tlkProductshowEntity
     * @return
     */
    /**
     * 创建一个作品
     * @param tlkProductshowEntity
     * @return
     */
    Serializable createZuopin(TlkProductshowEntity tlkProductshowEntity);

    /**
     * 保存一张图片
     * @param tlkProductshowpicEntity
     * @return
     */
    Serializable createProductshowpicEntity(TlkProductshowpicEntity tlkProductshowpicEntity);

    TlkProductshowpicEntity getProductshowpicByPicid(String picid);

    /**
     * 通过作品id得到作品封面
     * @param id
     * @return
     */
    TlkProductshowEntity getProductshowByZuopingid(String id);

    /**
     * 修改作品封面
     * @param tlkProductshowEntity
     */
    void updateZuopingCover(TlkProductshowEntity tlkProductshowEntity);

    /**
     * 修改作品图片
     * @param tlkProductshowpicEntity
     */
    void updateZuopingpic(TlkProductshowpicEntity tlkProductshowpicEntity);

    public List<SelectXJEntity> FindAllSysXJ();

    /**
     * 通过作品id删除作品
     * @param id
     */
    void deleteZuopingById(Serializable id);

    public List<SelectXJEntity> FindTwoAllSysXJ();
}
