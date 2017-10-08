package com.lkp.service;

import com.lkp.entity.TlkProductEntity;
import com.lkp.entity.TlkSctjEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface TlkSctjService {
    /*
    输出推荐中，根据id找到推荐的内
    * */
    TlkSctjEntity find(Serializable id);

    List<TlkSctjEntity> findAll();

}
