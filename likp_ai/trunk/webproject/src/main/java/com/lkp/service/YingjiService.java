package com.lkp.service;

import com.lkp.controller.YingjiJson;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkYingjiEntity;
import com.lkp.entity.TlkYingjipicEntity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface YingjiService {
    TlkYingjiEntity getYingjiById(Serializable id);
    Serializable cerateYingji(TlkYingjiEntity tlkYingjiEntity);
    void addYingjiPic(Serializable id,TlkYingjipicEntity[] tlkYingjipicEntities);
    void deleteYingjipic(Serializable id);
    List<TlkYingjiEntity> getYingjiListByUserbh(String userbh);
    void updataYingji(YingjiJson yingjiJson);
    TlkYingjiEntity getYingjiByItemOrderId(String itemOrderId);
    TlkOrderproductEntity getOrderByYingjiId(String id);
    void deleteYingjing(String id);
    void deleteYingjiByUserId(String userid,String id);
    void deleteOrderYingjiByUserId(String id);
    TlkPhotographerEntity getYingjiSysByYingjiId(String id);
/*    void deleteOrderYingji(String itemOrderid);*/
}
