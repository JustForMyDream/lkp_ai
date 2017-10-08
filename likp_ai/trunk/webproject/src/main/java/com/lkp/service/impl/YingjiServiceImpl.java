package com.lkp.service.impl;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.lkp.controller.UserController;
import com.lkp.controller.YingjiJson;
import com.lkp.controller.Yingjipic;
import com.lkp.dao.TlkOrderproductimgEntityDao;
import com.lkp.dao.YingjiDao;
import com.lkp.dao.YingjiPicDao;
import com.lkp.entity.*;
import com.lkp.service.AccessTokenService;
import com.lkp.service.YingjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;

/**
 *
 */
@Service
@Transactional
public class YingjiServiceImpl implements YingjiService {
    private final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps/Z22629";
    private final String imgpre = "/uploads/item/2016/";
    private final String filepath = imgpath + imgpre;
    @Autowired
    YingjiDao yingjiDao;

    @Autowired
    YingjiPicDao yingjiPicDao;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    TlkOrderproductimgEntityDao orderproductimgEntityDao;

    MediaUtil mediaUtil = new MediaUtil();

    public TlkYingjiEntity getYingjiById(Serializable id) {
        return yingjiDao.findById(id);
    }

    public Serializable cerateYingji(TlkYingjiEntity tlkYingjiEntity) {
        return yingjiDao.save(tlkYingjiEntity);
    }

    public void addYingjiPic(Serializable id, TlkYingjipicEntity[] tlkYingjipicEntities) {

    }

    public void deleteYingjipic(Serializable id) {

    }

    @Override
    public List<TlkYingjiEntity> getYingjiListByUserbh(String userbh) {
        return yingjiDao.getYingjiListByUserbh(userbh);
    }

    @Override
    public TlkYingjiEntity getYingjiByItemOrderId(String itemOrderId) {
        return yingjiDao.findByItemOrderId(itemOrderId);
    }

    @Override
    public TlkOrderproductEntity getOrderByYingjiId(String id) {
        return yingjiDao.getOrderByYingjiId(id);
    }

    @Override
    public void deleteYingjing(String id) {
        yingjiDao.deleteYingji(id);
        yingjiDao.deleteOrderYingji(id);
    }

    @Override
    public void deleteYingjiByUserId(String userid,String id) {
        yingjiDao.deleteYingjiByUserId(userid,id);

    }

    @Override
    public void deleteOrderYingjiByUserId(String id) {
        yingjiDao.deleteOrderYingjiByUserId(id);
    }

    @Override
    public TlkPhotographerEntity getYingjiSysByYingjiId(String id) {
        TlkOrderproductEntity orderproductEntity = getOrderByYingjiId(id);
        if(orderproductEntity!=null){
            TlkPhotographerEntity photographerEntity = orderproductEntity.getItemSysid();
            photographerEntity.getItemOpenid();
            return photographerEntity;
        }
        return null;
    }

/*    @Override
    public void deleteOrderYingji(String itemOrderid) {
        yingjiDao.deleteOrderYingji(itemOrderid);
    }*/

    @Override
    public void updataYingji(YingjiJson yingjiJson) {
        if (yingjiJson.getId() != null) {
            TlkYingjiEntity yingjiEntity = yingjiDao.findById(yingjiJson.getId());
            if (yingjiEntity != null) {
                yingjiEntity.setItemTitle(yingjiJson.getTitle());
                yingjiEntity.setItemDes(yingjiJson.getDes());
                yingjiEntity.setItemMusic(yingjiJson.getMusic());
                Set<TlkYingjipicEntity> set = yingjiEntity.getTlkYingjipicEntities();
                Iterator<TlkYingjipicEntity> iterator = set.iterator();
                if (yingjiJson.getCover() != null) {
                    if (yingjiJson.getCover().getType().equals("user")) {
                        YingjiCoverMediaOperate yingjiCoverMediaOperate = new YingjiCoverMediaOperate();
                        mediaUtil.getMedia(accessTokenService.getAccessToken(), yingjiJson.getCover().getTargetId(), yingjiCoverMediaOperate);
                        yingjiEntity.setItemCover("[{\"name\":\"作品图片\",\"path\":\"" + yingjiCoverMediaOperate.getCoverPath() + "\"}]");
                    } else if (yingjiJson.getCover().getType().equals("service") || yingjiJson.getCover().getType().equals("order")) {
                        yingjiEntity.setItemCover(yingjiJson.getCover().getTargetId());
                    }
                }
                while (iterator.hasNext()){
                    iterator.next().setTlkYingjiEntity(null);
                }
                for(int i=0;i<yingjiJson.getYingjipics().size();i++){
                    Yingjipic y = yingjiJson.getYingjipics().get(i);
                    YingjiMediaOperate yingjiMediaOperate = new YingjiMediaOperate();
                    if("user".equals(y.getType())){
                        TlkYingjipicEntity tlkYingjipicEntity = new TlkYingjipicEntity();
                        tlkYingjipicEntity.setItemDescription(y.getDes());
                        yingjiMediaOperate.setYingjipicEntity(tlkYingjipicEntity);
                        mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), yingjiMediaOperate);
                        System.out.println(tlkYingjipicEntity == yingjiMediaOperate.getYingjipicEntity());
                        tlkYingjipicEntity.setItemOrder(i);
                        tlkYingjipicEntity.setTlkYingjiEntity(yingjiEntity);
                        yingjiPicDao.save(tlkYingjipicEntity);
                    }else if("service".equals(y.getType())){
                        TlkYingjipicEntity tlkYingjipicEntity = yingjiPicDao.findById(y.getTargetId());
                        if(y.getDes()!=null){
                            tlkYingjipicEntity.setItemDescription(y.getDes());
                        }else{
                            tlkYingjipicEntity.setItemDescription(null);
                        }
                        tlkYingjipicEntity.setItemOrder(i);
                        tlkYingjipicEntity.setTlkYingjiEntity(yingjiEntity);
                    }else if("order".equals(y.getType())){
                        TlkYingjipicEntity tlkYingjipicEntity = new TlkYingjipicEntity();
                        tlkYingjipicEntity.setItemDescription(y.getDes());
                        tlkYingjipicEntity.setItemImgurl(orderproductimgEntityDao.findById(y.getTargetId()).getItemImgurl());
                        tlkYingjipicEntity.setItemOrder(i);
                        tlkYingjipicEntity.setTlkYingjiEntity(yingjiEntity);
                        yingjiPicDao.save(tlkYingjipicEntity);
                    }
                }
            }
        }
    }

    class YingjiMediaOperate implements MediaOperate {
        TlkYingjipicEntity yingjipicEntity;

        public YingjiMediaOperate() {
        }

        @Override
        public void InputstreamOperate(InputStream inputStream) {
            File file = new File(filepath + UUID.randomUUID() + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
                yingjipicEntity.setItemImgurl("[{\"name\":\"作品图片\",\"path\":\"" + imgpre + file.getName() + "\"}]");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public TlkYingjipicEntity getYingjipicEntity() {
            return yingjipicEntity;
        }

        public void setYingjipicEntity(TlkYingjipicEntity yingjipicEntity) {
            this.yingjipicEntity = yingjipicEntity;
        }
    }
    class YingjiCoverMediaOperate implements MediaOperate {
        String coverPath;

        public YingjiCoverMediaOperate() {
        }

        @Override
        public void InputstreamOperate(InputStream inputStream) {
            File file = new File(filepath + UUID.randomUUID() + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
                coverPath = imgpre + file.getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getCoverPath() {
            return coverPath;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }
    }
}
