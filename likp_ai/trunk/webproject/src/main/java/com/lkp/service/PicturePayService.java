package com.lkp.service;

import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkOrderproductimgEntity;
import com.lkp.entity.TlkOrderyingjiEntity;

import java.util.List;

/**
 *
 */
public interface PicturePayService {

    /**
     *
     */
    void saveOrderproductimgAndOrderId(TlkOrderproductimgEntity tlkOrderproductimgEntity);

    /**
     *
     * @param OrderId
     * @return 通过订单编号得到图片
     */
    List<TlkOrderproductimgEntity> getPicturesByOrderId(String OrderId);

    /**
     * 通过图片ID删除图片
     * @param pictureId
     */
    void deletePicturesById(String pictureId);

    /**
     * 通过id找到orderid
     * @param id
     * @return
     */
    TlkOrderproductEntity findOrderIdById(String id);

    /**
     * 保存影集关联订单编号
     */
    void saveYingByOrderId(TlkOrderyingjiEntity tlkOrderyingjiEntity);

    /**
     * 更新订单表
     * @param tlkOrderyingjiEntity
     */
    void updateOrderYingByOrderID(TlkOrderyingjiEntity tlkOrderyingjiEntity);

    /**
     * 通过订单编号查询是否有该订单
     * @param OrderId
     * @return
     */
   TlkOrderyingjiEntity findOrderByOrderId(String OrderId);
}
