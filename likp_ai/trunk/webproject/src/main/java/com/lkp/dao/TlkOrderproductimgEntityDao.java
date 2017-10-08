package com.lkp.dao;

import com.lkp.entity.TlkOrderproductimgEntity;

import java.util.List;

/**
 *
 */
public interface TlkOrderproductimgEntityDao extends BaseDao<TlkOrderproductimgEntity> {
    /**
     *
     * @param OrderId
     * @return 通过订单编号得到图片
     */
  List<TlkOrderproductimgEntity>  getPicturesByOrderId(String OrderId);

    /**
     * 通过图片ID删除图片
     * @param pictureId
     */
    void deletePicturesById(String pictureId);
}
