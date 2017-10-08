package com.lkp.dao;

import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkYingjiEntity;

import java.util.List;

/**
 *
 */
public interface YingjiDao extends BaseDao<TlkYingjiEntity> {
    List<TlkYingjiEntity> getYingjiListByUserbh(String userbh);
    TlkYingjiEntity findByItemOrderId(String itemOrderId);
    TlkOrderproductEntity getOrderByYingjiId(String id);
    void deleteYingji(String id);
    void deleteOrderYingji(String itemOrderid);
    void deleteYingjiByUserId(String UserId,String id);
    void deleteOrderYingjiByUserId(String id);
}
