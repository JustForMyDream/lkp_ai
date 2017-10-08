package com.lkp.dao;

import com.lkp.entity.TlkProductshowEntity;

import java.util.List;

/**
 *
 */
public interface TlkProductshowEntityDao extends BaseDao<TlkProductshowEntity> {
    /**
     * 通过摄影师编号查询摄影师的所有作品
     * @param id
     * @return
     */
    List<TlkProductshowEntity> getZuopingBySysid(String id);

    /**
     * 通过作品id得到作品封面
     * @param id
     * @return
     */
    TlkProductshowEntity getProductshowByZuopingid(String id);
}
