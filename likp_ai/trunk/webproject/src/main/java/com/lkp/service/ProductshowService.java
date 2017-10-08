package com.lkp.service;

import com.lkp.controller.YingjiJson;
import com.lkp.dao.ProductShowEntityDao;
import com.lkp.entity.TlkProductshowEntity;
import com.lkp.entity.TlkProductshowpicEntity;

import java.io.Serializable;
import java.util.List;
/**
 *
 */
public interface ProductshowService {
    /*
    根据产品的id找到产品的信息
    * */
    TlkProductshowEntity find(Serializable id);
    List<TlkProductshowEntity> findall();

    /**
     * 更新作品
     * @param yingjiJson
     */
   void updatezuoping(YingjiJson yingjiJson);

    /**
     * 根据作品ID找出所有的内容
     * @param id
     * @return
     */
    List<TlkProductshowpicEntity> getAllPicsByZuopingID(String id);
}
