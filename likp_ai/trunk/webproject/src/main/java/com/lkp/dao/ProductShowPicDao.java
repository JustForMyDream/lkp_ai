package com.lkp.dao;

import com.lkp.entity.TlkProductshowpicEntity;

import java.util.List;

/**
 *
 */
public interface ProductShowPicDao extends BaseDao<TlkProductshowpicEntity>{
    /**
     * 根据作品ID找出所有的内容
     * @param id
     * @return
     */
    List<TlkProductshowpicEntity> getAllPicsByZuopingID(String id);
}
