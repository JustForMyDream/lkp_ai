package com.lkp.service;

import com.lkp.entity.*;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface EventTemplateService {
    /**
     * 通过ID获得活动界面
     * @param id
     * @return
     */
    TlkMhdxxEntity findHdxxPageById(String id,Date date);

    /**
     * 通过活动编号获得字段
     * @param Hdbh
     * @return
     */
    List<TlkMhdzdEntity> findHdzdByHdbh(String Hdbh);

    /**
     * 通过活动编号获得报名详情
     * @param Hdbh
     * @return
     */
    List<TlkMhdbmzdEntity> findHdbmzdByHdbh(String Hdbh);

    /**
     * 保存报名信息
     */
    public void saveBmxx(TlkMhdxxbmEntity tlkMhdxxbmEntity);

    /**
     * 通过活动ID和活动编号查询报名用户
     * @param Id
     * @param UserId
     * @return
     */
    TlkMhdxxbmEntity findByhdIdAndUserId(String Id,String UserId);

    /**
     * 查找所有的客服
     * @return
     */
     List<TlkPtUserWxbdEntity> findAllCustomer();

    List<TlkMhdxxbmEntity> findByUserOpenidandDate(String openid,Date date);

    void saveHDBM(TlkMhdxxbmEntity tlkMhdxxbmEntity);
}
