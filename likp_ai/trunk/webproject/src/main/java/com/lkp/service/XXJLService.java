package com.lkp.service;

import com.lkp.entity.TlkXxjlEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface XXJLService {
    //保存消息
    Serializable save(TlkXxjlEntity tlkXxjlEntity);
    //获取所有信息
    List getUnreadMsg(String yhbh);
    //获取所有未读信息
    int getWeiDuMsg(String yhbh);
    //获取单条信息详情
    TlkXxjlEntity getById(Serializable id);
    //更新消息状态
    void updateMsgState(TlkXxjlEntity tlkXxjlEntity);
    //删除所有消息
    void DeleteAllMsg(String yhbh);
    //删除某条信息
    void DeleteMsg(String Msgid);

}
