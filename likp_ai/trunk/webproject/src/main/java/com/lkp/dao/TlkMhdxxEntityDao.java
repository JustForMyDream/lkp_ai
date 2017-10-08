package com.lkp.dao;

import com.lkp.dao.BaseDao;
import com.lkp.entity.TlkMhdxxEntity;
import com.lkp.entity.TlkMhdxxbmEntity;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface TlkMhdxxEntityDao extends BaseDao<TlkMhdxxEntity> {
    /**
     *通过ID查询活动界面
     * @param id
     * @return
     */
    TlkMhdxxEntity findMHdxxPageById(String id, Date date);

    TlkMhdxxEntity findByHdid(String Id);

    List<TlkMhdxxbmEntity> findByUserOpenidandDate(String openid, Date date);
}
