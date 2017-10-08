package com.lkp.service;

import com.lkp.entity.TlkUserCollectionEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.entity.TlkWechatuserEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface UserService {
    /**
     * 通过用户编号获取用户信息
     *
     * @param id
     * @return
     */
    TlkUserEntity getUserById(String id);

    /**
     * 通过微信openid 获取用户信息
     *
     * @param openid
     * @return
     */
    TlkUserEntity getUserByOpenid(String openid);

    /**
     * 通过微信信息添加或跟新用户
     *
     * @param tlkWechatuserEntity
     * @return 用户注册的id
     */
    Serializable addUserByWeChatInfo(TlkWechatuserEntity tlkWechatuserEntity);

    void updateUserInfo(String id, String username, String phone);


    /**
     * 通过openid获取用户信息
     *
     * @param openid
     * @return
     */
    TlkWechatuserEntity getWechatInfoByOpenid(String openid);

    TlkWechatuserEntity getWechatInfoByUserBH(String bh);

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
     * 通过tlkUserCollectionEntity添加收藏
     * @param tlkUserCollectionEntity
     */
    Serializable addCollectionByUserbhZpmc(TlkUserCollectionEntity tlkUserCollectionEntity);

    /**
     * 通过userbh和zmpc删除收藏
     * @param userbh
     * @param zpmc
     */
    boolean deleteCollectionByUserbhZpmc(String userbh, String zpmc);

    /**
     * 通过userbh清空所有收藏
     * @param userbh
     */
    void deleteAllCollectionByUserbh(String userbh);


    /*
    更新用户是否导航信息
     */
    void Update(TlkUserEntity userEntity);

}
