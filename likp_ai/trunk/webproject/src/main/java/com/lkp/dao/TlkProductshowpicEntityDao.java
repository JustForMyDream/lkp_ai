package com.lkp.dao;

import com.lkp.entity.TlkProductshowpicEntity;

/**
 *
 */
public interface TlkProductshowpicEntityDao extends BaseDao<TlkProductshowpicEntity> {
    /**
     * 通过作品id删除作品
     * @param id
     */
    void deleteZuopingById(String id);
}
