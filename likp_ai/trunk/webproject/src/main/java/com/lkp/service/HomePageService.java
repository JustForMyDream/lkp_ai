package com.lkp.service;

import com.lkp.entity.TlkCptjEntity;
import com.lkp.entity.TlkHzhbglEntity;
import com.lkp.entity.TlkLbglEntity;
import com.lkp.entity.TlkSystjEntity;

import java.util.List;

/**
 *
 */
public interface HomePageService {
    /**
     * 首页得到所有的轮播图片
     * @return
     */
    List<TlkLbglEntity> findAllLbgl();

    /**
     * 得到摄影师信息
     * @return
     */
    List<TlkSystjEntity> findAllSysInforBySysBh();


    /**
     * 首页得到两个摄影师信息
     * @return
     */
    List<TlkSystjEntity> findTwoSysInforBySysBh();

    /**
     * 首页得到推荐信息
     * @return
     */
    List<TlkCptjEntity> findTjProductInfor();
    /**
     * 首页得到合作伙伴
     * @return
     */
    List<TlkHzhbglEntity> findAllHZHB();



}
