package com.lkp.dao;

import com.lkp.entity.TlkLbglEntity;

import java.util.List;

/**
 *
 */
public interface TlkLbglEntityDao  extends BaseDao<TlkLbglEntity>{
    /**
     * 通过序列号排序得到轮播图片
     */
    List<TlkLbglEntity> getLbtpOrderByPxxh();
}
