package com.lkp.service.impl;

import com.cxt.wechat.Template.TemplateMessageBussinessImpl;
import com.cxt.wechat.custom.CustomInterface;
import com.cxt.wechat.custom.entity.Image;
import com.cxt.wechat.custom.entity.Imagemessage;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateItem;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateMessage;
import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.cxt.wechat.upload.AddMedia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lkp.controller.UserController;
import com.lkp.dao.*;
import com.lkp.entity.*;
import com.lkp.service.AccessTokenService;
import com.lkp.service.QuickService;
import com.lkp.util.MosaicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 */
@Service
@Transactional
public class QuickServiceImpl implements QuickService{

    @Autowired
    OrderDao orderDao;

    @Autowired
    TlkUserwechatinfoEntityDao userwechatinfoEntityDao;

    @Autowired
    TlkWechatuserEntityDao wechatuserEntityDao;

    @Autowired
    TlkMbEntityDao mbEntityDao;
    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    TlkMbjlDao mbjlDao;

    @Autowired
    UserController userController;

    @Autowired
    TlkMbfxjlEntityDao tlkMbfxjlEntityDao;

    @Autowired
    TlkMbjlDao tlkMbjlDao;

    MediaUtil mediaUtil = new MediaUtil();
    Gson gson = new Gson();

    @Override
    public String shareToUser(String orderid, String ServerId, String TempleId,String scale,String transX,String transY) {
        TlkOrderproductEntity orderproductEntity = orderDao.findOrderProductById(orderid);
        TlkUserEntity userEntity = orderproductEntity.getItemUserid();
        TlkPhotographerEntity photographerEntity = orderproductEntity.getItemSysid();
        Set<TlkUserwechatinfoEntity> userwechatinfoEntities = userEntity.getWechatInfo();
        Iterator<TlkUserwechatinfoEntity> iterator = userwechatinfoEntities.iterator();
        if(iterator.hasNext()){
            TlkUserwechatinfoEntity userwechatinfoEntity = iterator.next();
            TlkWechatuserEntity wechatuserEntity = userwechatinfoEntity.getTlkWechatuserEntity();
            TlkWechatuserEntity photoUser = photographerEntity.getItemOpenid();
            TlkMbEntity mbEntity = mbEntityDao.findById(TempleId);
            String fileName = UUID.randomUUID().toString()+".jpg";
            mediaUtil.getMedia(accessTokenService.getAccessToken(), ServerId, new MediaOperateimpl(userController.filepath + fileName, ServerId, mbEntity,"by:"+photoUser.getNickname()+"     ",Double.valueOf(scale),Double.valueOf(transX),Double.valueOf(transY)));
            File file1 = new File(userController.filepath+fileName);
            AddMedia addMedia = new AddMedia();
            String result = addMedia.uploadPermanentMedia(accessTokenService.getAccessToken(),file1);
            Map<String,String> r = gson.fromJson(result,new TypeToken<HashMap<String,String>>(){}.getType());
            if(r.get("media_id")!=null){
                CustomInterface customInterface = new CustomInterface();
                String string = customInterface.send(accessTokenService.getAccessToken(),new Imagemessage(wechatuserEntity.getOpenid(),"imager",new Image(r.get("media_id"))));
                System.out.println("-------string:"+string);
                Map<String,String> stringmap = gson.fromJson(string,new TypeToken<HashMap<String,String>>(){}.getType());
                if(!"0".equals(stringmap.get("errcode"))){
                    TemplateMessageBussinessImpl templateMessageBussiness = new TemplateMessageBussinessImpl();
                    WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
                    wechatTemplateMessage.setTemplate_id("h0nK11vCMWYgqZb2j6-EEoI3PobD6ue7cTa-uAGWgKM");
                    wechatTemplateMessage.setTouser(wechatuserEntity.getOpenid());
                    Map<String,WechatTemplateItem> map = new HashMap<String,WechatTemplateItem>();
                    map.put("first",new WechatTemplateItem("摄影师分享了一张图片给您"));
                    map.put("keyword1",new WechatTemplateItem(orderproductEntity.getItemOrderid()));
                    map.put("keyword2",new WechatTemplateItem(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())));
                    map.put("keyword3",new WechatTemplateItem("1"));
                    map.put("remark",new WechatTemplateItem("点击查看图片"));
                    wechatTemplateMessage.setUrl(userController.domai+":"+userController.port+userController.context+userController.imgpre+fileName);
                    wechatTemplateMessage.setData(map);
                    System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
                }
                TlkMbfxjlEntity mbfxjlEntity = new TlkMbfxjlEntity();
                mbfxjlEntity.setItemSharetime(new Date());
                mbfxjlEntity.setItemSharenum(new BigDecimal(0));
                tlkMbfxjlEntityDao.save(mbfxjlEntity);
                TlkMbjlEntity mbjlEntity = new TlkMbjlEntity();
                mbjlEntity.setItemMbbh(new String());
                mbjlEntity.setItemCptp(new String());
                mbjlEntity.setItemCreatedate(new Date());
                mbjlEntity.setItemDdbh(new String());
                mbjlEntity.setItemYhbh(new String());
                tlkMbjlDao.save(mbjlEntity);
            }
            return userController.imgpre+fileName;
        }
        return null;
    }
    @Override
    public TlkMbEntity findMbById(String TempleId) {
        return mbEntityDao.findById(TempleId);
    }
    class MediaOperateimpl implements MediaOperate{
        String fileName;
        String tempImgName;
        TlkMbEntity mbEntity;
        String nickname;
        double Scale;
        double TransX;
        double TransY;

        public MediaOperateimpl(String fileName, String tempImgName, TlkMbEntity mbEntity, String nickname,double scale,double transX,double transY) {
            this.fileName = fileName;
            this.tempImgName = tempImgName;
            this.mbEntity = mbEntity;
            this.nickname = nickname;
            this.Scale = scale;
            this.TransX = transX;
            this.TransY = transY;
        }

        @Override
        public void InputstreamOperate(InputStream inputStream){
            List<ImgEntity> imgs = gson.fromJson(mbEntity.getItemMbtp(),new TypeToken<ArrayList<ImgEntity>>(){}.getType());
            if(imgs==null||imgs.size()<=0){
                return;
            }
            File file=new File(userController.imgpath+imgs.get(0).getPath());
            //将文件保存至临时文件夹
            File file_t = new File(userController.imgpath+userController.temp_img + tempImgName + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file_t);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, Integer> map=gson.fromJson(mbEntity.getItemMbzb(),new TypeToken<HashMap<String,Integer>>(){}.getType());
            MosaicUtil.createMosaicPic(file,file_t,fileName,map.get("x1"),map.get("y1"),map.get("x2"),map.get("y2"),nickname,Scale,TransX,TransY);
        }
    }
}
