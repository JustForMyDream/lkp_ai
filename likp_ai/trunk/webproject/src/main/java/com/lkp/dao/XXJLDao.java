package com.lkp.dao;

import com.lkp.entity.TlkXxjlEntity;

import java.util.List;

/**
 *
 */
public interface XXJLDao extends BaseDao<TlkXxjlEntity> {
    List getUnreadMsg(String yhbh);
    int getWeiDuMsg(String yhbh);
    void DeleteAllMsg(String yhbh);
    void DeleteMsg(String Msgid);
}
