package com.lkp.controller;

import com.cxt.wechat.Template.TemplateMessageBussiness;
import com.cxt.wechat.Template.TemplateMessageBussinessImpl;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateItem;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateMessage;
import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.cxt.wechat.oauth2.Oauth2;
import com.cxt.wechat.usermanage.user.UserImpl;
import com.cxt.wechat.usermanage.user.UserInterface;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.entity.*;
import com.lkp.service.*;
import com.lkp.service.impl.EventTemplateServiceImpl;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("ActivityTemplate")
public class EventTemplateController {
    final String domai = "http://www.91lkp.com";
    public final String port = "8080";
    public final String context = "/Z22629";
    public final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps"+context;
    public final String imgpre = "/uploads/item/2016/";
    public final String temp_img="/uploads/item/temp_img/";
    public final String filepath = imgpath + imgpre;
    @Autowired
    EventTemplateService eventTemplateService;

    TemplateMessageBussiness templateMessageBussiness = new TemplateMessageBussinessImpl();

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    TlkWechatuserEntityService tlkWechatuserEntityService;

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    YingjiService yingjiService;

    @Autowired
    OrderService orderService;

    UserInterface userInterface = new UserImpl();

    Oauth2 oauth2 = new Oauth2();

    Gson gson = new Gson();

    MediaUtil mediaUtil = new MediaUtil();

    @RequestMapping("hdmainpage")
    public void hdmainpage(@RequestParam("id")String id, HttpServletResponse response, HttpSession session){
        TlkWechatuserEntity tlkWechatuserEntity = userController.getWechatUserBySession(session);
        TlkMhdxxEntity tlkMhdxxEntity = eventTemplateService.findHdxxPageById(id,new Date());
        List <TlkMhdzdEntity> tlkMhdzdEntities = eventTemplateService.findHdzdByHdbh(id);
        List<TlkMhdzdEntity> list = new ArrayList<>();
        Map<String,Object> message = new HashMap<String,Object>();
        if(tlkMhdxxEntity == null){
            message.put("result","fail");
            message.put("msg","报名失败,报名时间结束或者活动不存在");
            ResponseUtil.response(response,new Gson().toJson(message));
            return;
        }
        else {
            message.put("result","success");
            message.put("msg","访问成功");
            message.put("data1",tlkMhdxxEntity);
            if(tlkMhdzdEntities.size() == 0) {
                ResponseUtil.response(response, new Gson().toJson(message));
            }
            else {
                for(int i = 0;i< tlkMhdzdEntities.size();i++) {
                    TlkMhdzdEntity tlkMhdzdEntity = tlkMhdzdEntities.get(i);
                    list.add(tlkMhdzdEntity);
                }
                String s = userInterface.USER_info(accessTokenService.getAccessToken(),tlkWechatuserEntity.getOpenid());
                Map<String,Object> map = new HashMap<>();
                map = gson.fromJson(s , new TypeToken<HashMap<String,Object>>(){}.getType());
                if(tlkWechatuserEntity == null||0==(Double )map.get("subscribe")){
                    System.out.println(map.get("subscribe").equals("0"));
                    message.put("subscribe",false);
                }else{
                    message.put("subscribe",true);
                }
                message.put("data2",list);
                ResponseUtil.response(response,new Gson().toJson(message));
            }
        }
    }

    @RequestMapping("firstpage")
    public void firstpage(@RequestParam("id")String id,HttpServletResponse response,HttpSession session){
        List<TlkMhdbmzdEntity> tlkMhdbmzdEntities = eventTemplateService.findHdbmzdByHdbh(id);
        Map<String,Object> message = new HashMap<String,Object>();
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        if(tlkMhdbmzdEntities.size()==0){
            message.put("result","null");
            message.put("msg","没有多余的字段");
            ResponseUtil.response(response,new Gson().toJson(message));
        }
        else {
            ResponseUtil.response(response,new Gson().toJson(eventTemplateService.findHdbmzdByHdbh(id)));
        }
    }


    @RequestMapping("savebmxx")
    public void savebmxx(@RequestParam("id")String id,@RequestParam("itemName")String itemName,@RequestParam("itemSex")String itemSex,@RequestParam("itemLxfs")String itemLxfs,@RequestParam("itemBmxq")String itemBmxq , HttpServletResponse response,HttpSession session){
        TlkWechatuserEntity tlkWechatuserEntity = userController.getWechatUserBySession(session);
        Map<String,Object> message = new HashMap<>();
        if(tlkWechatuserEntity == null){
            message.put("result","fail");
            message.put("resultcode","404");
            message.put("msg","未取得用户信息");
            ResponseUtil.response(response,new Gson().toJson(message));
            return;
        }
        else {
            String s = userInterface.USER_info(accessTokenService.getAccessToken(),tlkWechatuserEntity.getOpenid());
            Map<String,Object> map = new HashMap<>();
            map = gson.fromJson(s , new TypeToken<HashMap<String,Object>>(){}.getType());
                message.put("subscribe", true);
                TlkMhdxxEntity tlkMhdxxEntity = eventTemplateService.findHdxxPageById(id, new Date());
                if (eventTemplateService.findByhdIdAndUserId(id, userController.getUserBySession(session).getId()) != null) {
                    message.put("result", "fail");
                    message.put("resultcode", "302");
                    message.put("msg", "重复报名");
                    ResponseUtil.response(response, new Gson().toJson(message));
                    return;
                } else {
                    if (tlkMhdxxEntity != null) {
                        TlkUserEntity tlkUserEntity = userService.getUserByOpenid(tlkWechatuserEntity.getOpenid());
                        TlkMhdxxbmEntity tlkMhdxxbmEntity = new TlkMhdxxbmEntity();
                        tlkMhdxxbmEntity.setItemYhbh(tlkUserEntity.getId());
                        tlkMhdxxbmEntity.setItemName(itemName);
                        tlkMhdxxbmEntity.setItemSex(itemSex);
                        tlkMhdxxbmEntity.setItemLxfs(itemLxfs);
                        tlkMhdxxbmEntity.setItemBmxq(itemBmxq);
                        tlkMhdxxbmEntity.setItemHdbh(id);
                        List<XQ> xqs  = gson.fromJson(itemBmxq,new TypeToken<ArrayList<XQ>>(){}.getType());
                        StringBuilder stringBuilder = new StringBuilder("");
                        int j = 0;
                        for(int i = 0;i < xqs.size();i++){
                            if(xqs.get(i).getType().equals("img")){
                            PicUploadMediaOperate picUploadMediaOperate = new PicUploadMediaOperate();
                                mediaUtil.getMedia(accessTokenService.getAccessToken(),xqs.get(i).getVal(),picUploadMediaOperate);
                                stringBuilder.append("{\"name\":\"上传图片\",\"path\":\"" + picUploadMediaOperate.getPicPath() + "\"}").append(",");
                                j++;
                            }
                        }
                        if(j!=0){
                            tlkMhdxxbmEntity.setItemFjtp("["+stringBuilder.substring(0,stringBuilder.length()-1)+"]");
                        }
                        if(tlkWechatuserEntity == null||0==(Double )map.get("subscribe")){
                            tlkMhdxxbmEntity.setItemSfgz("1");
                            System.out.println(map.get("subscribe").equals("0"));
                            message.put("subscribe",false);
                        }else{
                            tlkMhdxxbmEntity.setItemSfgz("0");
                            activitySuccessToUser(tlkWechatuserEntity.getOpenid(), tlkMhdxxEntity);
                            activitySuccessToCustmer(tlkMhdxxEntity, itemName, itemLxfs);
                            message.put("result", "success");
                            message.put("msg", "报名成功");
                        }
                        eventTemplateService.saveBmxx(tlkMhdxxbmEntity);
                    } else {
                        message.put("result", "fail");
                        message.put("resultcode", "500");
                        message.put("msg", "报名失败,报名时间结束或者活动不存在");
                    }
                    ResponseUtil.response(response, new Gson().toJson(message));
                }
            }

    }

    @RequestMapping("isjoined")
    public void isjoined(@RequestParam("id")String id,HttpServletResponse response,HttpSession session){
        Map<String,Object> message = new HashMap<>();
        if(eventTemplateService.findByhdIdAndUserId(id, userController.getUserBySession(session).getId()) != null){
            message.put("result","success");
            message.put("msg","你已经报过名");
            ResponseUtil.response(response,new Gson().toJson(message));
        }
        else{
            message.put("result","fail");
            ResponseUtil.response(response,new Gson().toJson(message));
        }
    }
    @RequestMapping("info")
    public String info(@RequestParam("id") String id, HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            TlkUserEntity userEntity = userController.getUserBySession(session);
            if(userEntity!=null)
                model.addAttribute("id",id);
                return "/activity/mainPage";
        }
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+id+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
    }
    @RequestMapping("hdbm")
    public String hdbm(@RequestParam("id") String id, HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        String appid = weChatCfg.getAppId();
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        model.addAttribute("id",id);
        if(session!=null){
            TlkUserEntity userEntity = userController.getUserBySession(session);
            if(userEntity!=null)
                model.addAttribute("id",id);
            return "/activity/mhdbm";
        }
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+id+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
    }

    void activitySuccessToUser(String openid,TlkMhdxxEntity tlkMhdxxEntity){
        String Template="AhCfKlh71ubtoXbfKkE9DOVJ8HPCA_Pr881QGvRoIIk";
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        wechatTemplateMessage.setTemplate_id(Template);
        wechatTemplateMessage.setTouser(openid);
        Map<String ,WechatTemplateItem> data = new HashMap<>();
        data.put("keyword1",new WechatTemplateItem("报名成功","#619CC1"));
        data.put("keyword2",new WechatTemplateItem(tlkMhdxxEntity.getItemName()));
        data.put("keyword3",new WechatTemplateItem(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        data.put("remark",new WechatTemplateItem("客服将尽快与你联系,感谢您的支持"));
        wechatTemplateMessage.setData(data);
        System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
    }

    void activitySuccessToCustmer(TlkMhdxxEntity tlkMhdxxEntity,String itemName,String itemLxfs){
        String template="ao0j-rdUnmraGcMrchlZnIwncfNVwlDvZVHsXMUJqzU";
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        wechatTemplateMessage.setTemplate_id(template);
        List<TlkPtUserWxbdEntity> userWxbdEntities = eventTemplateService.findAllCustomer();
        for(int i = 0;i< userWxbdEntities.size();i ++){
            Map<String ,WechatTemplateItem> data = new HashMap<>();
            data.put("first",new WechatTemplateItem("用户报名通知"));
            data.put("keyword1",new WechatTemplateItem(tlkMhdxxEntity.getItemName(),"#0070C0"));
            data.put("keyword2",new WechatTemplateItem(itemName));
            data.put("keyword3",new WechatTemplateItem(itemLxfs));
            data.put("remark",new WechatTemplateItem("请尽快与用户联系"));
            wechatTemplateMessage.setData(data);
            wechatTemplateMessage.setTouser(userWxbdEntities.get(i).getItemOpenid());
            System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
        }
    }

    public class XQ{
        String name;
        String val;
        String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public class PicUploadMediaOperate implements MediaOperate{
        String picPath;

        public PicUploadMediaOperate() {
        }
        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
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
                picPath = imgpre + file.getName() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

