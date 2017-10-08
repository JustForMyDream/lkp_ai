package com.lkp.service.impl;

import com.lkp.dao.*;
import com.lkp.entity.*;
import com.lkp.service.OrderService;
import com.lkp.service.SYSUPloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Service
@Transactional
public class SYSUPloadServiceImpl implements SYSUPloadService {
    @Autowired
    YingjiDao yingjiDao;

    @Autowired
    OrderproductDao orderproductDao;

    @Autowired
    YingjiPicDao yingjiPicDao;

    @Autowired
    TlkOrderproductimgEntityDao orderproductimgEntityDao;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderYingjiDao orderYingjiDao;

    public Serializable uploadYingji(String orderid, String title, String des, String music, String[] pic) {
        TlkOrderproductEntity tlkOrderproductEntity = orderproductDao.findOrderProductById(orderid);
        TlkYingjiEntity yingjiEntity = yingjiDao.findByItemOrderId(orderid);
        TlkOrderyingjiEntity orderyingjiEntity = orderYingjiDao.findByOrderid(orderid);
        String id = null;
        if (yingjiEntity == null) {
            yingjiEntity = new TlkYingjiEntity();
            id = (String) yingjiDao.save(yingjiEntity);
        }else{
            id = yingjiEntity.getId();
            Set<TlkYingjipicEntity> yingjipicEntities = yingjiEntity.getTlkYingjipicEntities();
            for(TlkYingjipicEntity yingjipicEntity: yingjipicEntities){
                yingjiPicDao.delete(yingjipicEntity);
            }
        }
        if(orderyingjiEntity == null){
            orderyingjiEntity =  new TlkOrderyingjiEntity();
            orderYingjiDao.save(orderyingjiEntity);
        }
        if (pic.length != 0) {
            yingjiEntity.setItemCreate(new Date());
            yingjiEntity.setItemTitle(title);
            yingjiEntity.setItemDes(des);
            yingjiEntity.setItemMusic(music);
            yingjiEntity.setItemUserid(tlkOrderproductEntity.getItemUserid().getItemBh());
            for (int i = 0; i < pic.length; i++) {
                TlkOrderproductimgEntity tlkOrderproductimgEntity = orderService.getOrderproductimgById(pic[i]);
                yingjiEntity.setItemCover(tlkOrderproductimgEntity.getItemImgurl());
                if (tlkOrderproductimgEntity != null) {
                    TlkYingjipicEntity yingjipicEntity = new TlkYingjipicEntity();
                    yingjipicEntity.setItemImgurl(tlkOrderproductimgEntity.getItemImgurl());
                    yingjipicEntity.setItemOrder(i);
                    yingjipicEntity.setTlkYingjiEntity(yingjiEntity);
                    yingjiPicDao.save(yingjipicEntity);
                    }
                }
            orderyingjiEntity.setItemOrderid(orderid);
            orderyingjiEntity.setItemYingjiid(id);
            return id;
            }
        return null;
    }
}
