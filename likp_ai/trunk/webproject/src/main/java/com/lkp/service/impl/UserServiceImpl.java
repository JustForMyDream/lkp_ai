package com.lkp.service.impl;

import com.lkp.dao.TlkUserCollectionEntityDao;
import com.lkp.dao.TlkUserwechatinfoEntityDao;
import com.lkp.dao.TlkWechatuserEntityDao;
import com.lkp.dao.UserDao;
import com.lkp.entity.TlkUserCollectionEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.entity.TlkUserwechatinfoEntity;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    TlkUserCollectionEntityDao tlkUserCollectionEntityDao;
    @Autowired
    TlkWechatuserEntityDao tlkWechatuserEntityDao;

    @Autowired
    TlkUserwechatinfoEntityDao tlkUserwechatinfoEntityDao;

    public TlkUserEntity getUserById(String id) {
        return userDao.findById(id);
    }

    public TlkUserEntity getUserByOpenid(String openid) {
        return userDao.findByOpenid(openid);
    }

    /**
     * 通过微信信息添加或跟新用户
     *
     * @param tlkWechatuserEntity
     * @return 用户注册的id
     */
    public Serializable addUserByWeChatInfo(TlkWechatuserEntity tlkWechatuserEntity) {
        TlkUserEntity tlkUserEntity = userDao.findByOpenid(tlkWechatuserEntity.getOpenid());
        TlkWechatuserEntity tlkWechatuserEntity1 = tlkWechatuserEntityDao.findByOpenId(tlkWechatuserEntity.getOpenid());
        String userid = null;
        /**
         * 若该用户未注册
         */
        if (tlkUserEntity == null) {
            tlkUserEntity = new TlkUserEntity();
            tlkUserEntity.setItemName(tlkWechatuserEntity.getNickname());
            userid = (String) userDao.save(tlkUserEntity);
            /**
             * 数据库中微信信息为空
             */
            if (tlkWechatuserEntity1 == null) {
                tlkWechatuserEntityDao.save(tlkWechatuserEntity);
                TlkUserwechatinfoEntity tlkUserwechatinfoEntity = tlkUserwechatinfoEntityDao.getTlkUserwechatinfoEntityByOpenid(tlkWechatuserEntity.getOpenid());
                if (tlkUserwechatinfoEntity == null) {
                    tlkUserwechatinfoEntity = new TlkUserwechatinfoEntity();
                }
                tlkUserwechatinfoEntity.setUwitemUserid(tlkUserEntity);
                tlkUserwechatinfoEntity.setTlkWechatuserEntity(tlkWechatuserEntity);
                tlkUserwechatinfoEntityDao.save(tlkUserwechatinfoEntity);
            }
            /**
             * 若数据库中微信信息不为空
             */
            else {
                /**
                 * 若微信信息不相等
                 */
                if (!tlkWechatuserEntity.equals(tlkWechatuserEntity1)) {
                    copyWechatInfo(tlkWechatuserEntity1, tlkWechatuserEntity);
                    tlkWechatuserEntityDao.update(tlkWechatuserEntity1);
                }
                /*
                 *建立用户关联
                 */
                TlkUserwechatinfoEntity tlkUserwechatinfoEntity = tlkUserwechatinfoEntityDao.getTlkUserwechatinfoEntityByOpenid(tlkWechatuserEntity.getOpenid());
                if (tlkUserwechatinfoEntity == null) {
                    tlkUserwechatinfoEntity = new TlkUserwechatinfoEntity();
                    tlkUserwechatinfoEntity.setUwitemUserid(tlkUserEntity);
                    tlkUserwechatinfoEntity.setTlkWechatuserEntity(tlkWechatuserEntity1);
                    tlkUserwechatinfoEntityDao.save(tlkUserwechatinfoEntity);
                }
            }
        }
        /**
         * 若用户已注册
         */
        else {
            userid = tlkUserEntity.getId();
            //用户微信信息为空
            if (tlkWechatuserEntity1 == null) {
                tlkWechatuserEntityDao.save(tlkWechatuserEntity);
            } else if (!tlkWechatuserEntity.equals(tlkWechatuserEntity1)) {
                copyWechatInfo(tlkWechatuserEntity1, tlkWechatuserEntity);
                tlkWechatuserEntityDao.update(tlkWechatuserEntity1);
            }
        }
        return userid;
    }

    @Override
    public void updateUserInfo(String id, String username, String phone) {
        TlkUserEntity tlkUserEntity = getUserById(id);
        if (username != null) {
            tlkUserEntity.setItemName(username);
        }
        if (phone != null) {
            tlkUserEntity.setItemPhone(phone);
        }
    }

    @Override
    public TlkWechatuserEntity getWechatInfoByOpenid(String openid) {
        return tlkWechatuserEntityDao.findByOpenId(openid);
    }

    @Override
    public TlkWechatuserEntity getWechatInfoByUserBH(String bh) {
        return tlkWechatuserEntityDao.findByUserBh(bh);
    }

    @Override
    public TlkUserCollectionEntity getCollectionByUserbhZpmc(String userbh, String Zmpc) {
        return tlkUserCollectionEntityDao.getCollectionByUserbhZpmc(userbh, Zmpc);
    }

    @Override
    public List<TlkUserCollectionEntity> getAllCollectionByUserbh(String userbh) {
        return tlkUserCollectionEntityDao.getAllCollectionByUserbh(userbh);
    }

    @Override
    public Serializable addCollectionByUserbhZpmc(TlkUserCollectionEntity tlkUserCollectionEntity) {
        TlkUserCollectionEntity IfTlkUserCollectionEntity = tlkUserCollectionEntityDao.getCollectionByUserbhZpmc(tlkUserCollectionEntity.getItemName(), tlkUserCollectionEntity.getItemZpmc());
        if (IfTlkUserCollectionEntity != null) {
            return null;
        } else {
            return tlkUserCollectionEntityDao.save(tlkUserCollectionEntity);
        }

    }

    @Override
    public boolean deleteCollectionByUserbhZpmc(String userbh, String zpmc) {
        TlkUserCollectionEntity IfTlkUserCollectionEntity = tlkUserCollectionEntityDao.getCollectionByUserbhZpmc(userbh, zpmc);
        if (IfTlkUserCollectionEntity != null) {
            tlkUserCollectionEntityDao.deleteCollectionByUserbhZpmc(IfTlkUserCollectionEntity.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteAllCollectionByUserbh(String userbh) {
        tlkUserCollectionEntityDao.deleteAllCollectionByUserbh(userbh);
    }

    @Override
    public void Update(TlkUserEntity userEntity) {
        userDao.update(userEntity);
    }

    /**
     * 复制用户的微信信息
     * （工具方法）
     *
     * @param o 数据库中的原用户微信信息
     * @param n 获取到的新用户微信信息
     */
    protected void copyWechatInfo(TlkWechatuserEntity o, TlkWechatuserEntity n) {
        o.setOpenid(n.getOpenid());
        o.setCity(n.getCity());
        o.setCountry(n.getCountry());
        o.setNickname(n.getNickname());
        o.setGroupid(n.getGroupid());
        o.setHeadimgurl(n.getHeadimgurl());
        o.setProvince(n.getProvince());
        o.setLanguage(n.getLanguage());
        o.setRemark(n.getRemark());
        o.setSubscribe(n.getSubscribe());
        o.setSubscribe_time(n.getSubscribe_time());
        o.setUnionid(n.getUnionid());
    }

}
