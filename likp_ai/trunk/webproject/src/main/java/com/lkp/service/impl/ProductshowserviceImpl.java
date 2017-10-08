package com.lkp.service.impl;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.google.gson.Gson;
import com.lkp.controller.PhotoGrapherController;
import com.lkp.controller.YingjiJson;
import com.lkp.controller.Yingjipic;
import com.lkp.dao.ProductShowEntityDao;
import com.lkp.dao.TlkProductshowEntityDao;
import com.lkp.dao.TlkProductshowpicEntityDao;
import com.lkp.entity.TlkProductshowEntity;
import com.lkp.entity.TlkProductshowpicEntity;
import com.lkp.service.AccessTokenService;
import com.lkp.service.ProductshowService;
import com.lkp.service.TLkPhotograoherService;
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
public class ProductshowserviceImpl implements ProductshowService {
    @Autowired
    ProductShowEntityDao productShowEntityDao;

    @Autowired
    TLkPhotograoherService tLkPhotograoherService;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    TlkProductshowpicEntityDao tlkProductshowpicEntityDao;

    @Autowired
    TlkProductshowEntityDao tlkProductshowEntityDao;


    MediaUtil mediaUtil = new MediaUtil();
    final String domai = "http://www.91lkp.com";
    public final String context = "/Z22629";
    public final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps" + context;
    public final String imgpre = "/uploads/item/2016/";
    public final String filepath = imgpath + imgpre;
    @Transactional
    public TlkProductshowEntity find(Serializable id){
        return productShowEntityDao.findById(id);
    }
    public List<TlkProductshowEntity> findall(){
        return productShowEntityDao.findAll();
    }

    @Override
    public void updatezuoping(YingjiJson yingjiJson) {
            TlkProductshowEntity tlkProductshowEntity = productShowEntityDao.findById(yingjiJson.getId());
            if(tlkProductshowEntity!=null){
                tlkProductshowEntity.setItemTitle(yingjiJson.getTitle());
                tlkProductshowEntity.setItemZpms(yingjiJson.getDes());
                List<Yingjipic> yingjipicList = yingjiJson.getYingjipics();
                Set <TlkProductshowpicEntity> set = tlkProductshowEntity.getTlkProductshowpicEntities();
                Iterator <TlkProductshowpicEntity> iterator = set.iterator();
                if (yingjiJson.getCover() != null) {
                    if (yingjiJson.getCover().getType().equals("user")) {
                        ZuoPinMediaOperate zuoPinMediaOperate = new ZuoPinMediaOperate();
                        mediaUtil.getMedia(accessTokenService.getAccessToken(), yingjiJson.getCover().getTargetId(), zuoPinMediaOperate);
                        tlkProductshowEntity.setItemZpfm("[{\"name\":\"封面图片\",\"path\":\"" + zuoPinMediaOperate.getPicPath() + "\"}]");
                    } else if (yingjiJson.getCover().getType().equals("service") || yingjiJson.getCover().getType().equals("order")) {
                        tlkProductshowEntity.setItemZpfm(yingjiJson.getCover().getTargetId());
                    }
                }
                while (iterator.hasNext()){
                    iterator.next().setTlkProductshowEntity(null);
                }
                //tlkProductshowEntityDao.save(tlkProductshowEntity);
                for (int i = 0; i < yingjipicList.size(); i++) {
                    Yingjipic y = yingjiJson.getYingjipics().get(i);
                    ZuoPinMediaOperate zuoPinMediaOperate = new ZuoPinMediaOperate();
                    if("user".equals(y.getType())){
                        TlkProductshowpicEntity tlkProductshowpicEntity = new TlkProductshowpicEntity();
                        tlkProductshowpicEntity.setItemOrder(i);
                        tlkProductshowpicEntity.setItemDescript(y.getDes());
                        tlkProductshowpicEntity.setTlkProductshowEntity(tlkProductshowEntity);
                        mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), zuoPinMediaOperate);
                        tlkProductshowpicEntity.setItemPicurl("[{\"name\":\"作品图片\",\"path\":\"" + zuoPinMediaOperate.getPicPath() + "\"}]");
                        tlkProductshowpicEntityDao.save(tlkProductshowpicEntity);
                    }
                   if("service".equals(y.getType())){
                       TlkProductshowpicEntity tlkProductshowpicEntity = tlkProductshowpicEntityDao.findById(y.getTargetId());
                       tlkProductshowpicEntity.setItemOrder(i);
                       tlkProductshowpicEntity.setTlkProductshowEntity(tlkProductshowEntity);
                       tlkProductshowpicEntity.setItemDescript(y.getDes());
                       //tlkProductshowpicEntityDao.save(tlkProductshowpicEntity);
                   }
                }
              }
        }

    @Override
    public List<TlkProductshowpicEntity> getAllPicsByZuopingID(String id) {
        return null;
    }

    class ZuoPinMediaOperate implements MediaOperate {

        String picPath;

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPicPath() {
            return picPath;
        }

        public ZuoPinMediaOperate() {
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
                picPath = imgpre + file.getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
