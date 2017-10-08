package com.lkp.service;

import com.lkp.entity.TlkMbEntity;

/**
 *
 */
public interface QuickService {
    /**
     * 快速分享服务
     * @param orderid 订单编号
     * @param ServerId 微信图片编号
     * @param TempleId 使用模板编号
     * @return
     */
    String shareToUser(String orderid,String ServerId,String TempleId,String scale,String transX,String transY);

    /**
     * 通过模板id查找模板
     * @param TempleId
     * @return
     */
    TlkMbEntity findMbById(String TempleId);
}
