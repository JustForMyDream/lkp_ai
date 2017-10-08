package com.lkp.dao;

import com.lkp.entity.TlkUserCollectionEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface TlkUserCollectionEntityDao extends BaseDao<TlkUserCollectionEntity> {
    /**
     * 通过userbh和zmpc用户是否收藏当前列表
     *
     * @param userbh
     * @param Zmpc
     * @return
     */
    TlkUserCollectionEntity getCollectionByUserbhZpmc(String userbh, String Zmpc);

    /**
     * 通过用户编号获取用户收藏列表
     * @param userbh
     * @return
     */
    List<TlkUserCollectionEntity> getAllCollectionByUserbh(String userbh);

    /**
     * 通过通过id删除
     * @param collectionId
     */
    void deleteCollectionByUserbhZpmc(String collectionId);

    /**
     * 通过用户编号取消所有收藏
     * @param userBh
     */
    void deleteAllCollectionByUserbh(String userBh);
}
