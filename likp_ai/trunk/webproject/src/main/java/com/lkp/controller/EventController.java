package com.lkp.controller;

import com.cxt.wechat.Template.TemplateMessageBussiness;
import com.cxt.wechat.Template.TemplateMessageBussinessImpl;
import com.cxt.wechat.custom.CustomInterface;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateItem;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateMessage;
import com.cxt.wechat.message.Text;
import com.cxt.wechat.pay.unifiedorder.util.StringUtil;
import com.cxt.wechat.util.WechatXmlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lkp.bean.WeChatCfg;
import com.lkp.entity.*;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("HONGDONG")
public class EventController {
    final String domai = "http:/www.91lkp.com";
    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    TlkGzhfEntityService gzhfEntityService;

    WechatXmlUtil wechatXmlUtil = new WechatXmlUtil();
    CustomInterface customInterface = new CustomInterface();
    TemplateMessageBussiness templateMessageBussiness = new TemplateMessageBussinessImpl();
    @Autowired
    TLkPhotograoherService photograoherService ;

    @Autowired
    UserController userController;
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    TlkWechatuserEntityService tlkWechatuserEntityService;
    @Autowired
    EventTemplateController eventTemplateController;

    @Autowired
    EventTemplateService eventTemplateService;
    @RequestMapping("tiaozhuan")
    public void tiaozhuan(@RequestParam(required = false)String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap<String, String> message =  new Gson().fromJson(request.getReader(),new TypeToken<HashMap<String, String>>(){}.getType());
        if (message.get("MsgType").equals("text")) {
            String content = message.get("Content");
            String openid = message.get("FromUserName");
            List<TlkMhdxxEntity> tlkMhdxxEntitys = eventService.findAllCustomerChar(content,new Date());
            for(int i=0;i<tlkMhdxxEntitys.size();i++){
                TlkMhdxxEntity tlkMhdxxEntity = tlkMhdxxEntitys.get(i);
                if(tlkMhdxxEntity != null){
                   // String yhpage = tlkMhdxxEntity.getItemUserpage();
                    StringBuilder messageContent = new StringBuilder();
                    messageContent.append("点击查看<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+tlkMhdxxEntity.getId()+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect\">"+tlkMhdxxEntity.getItemName()+"</a>");
                    customInterface.send(accessTokenService.getAccessToken(),openid,messageContent.toString());
                }
            }
        }
        if (message.get("MsgType").equals("event")) {
            if (message.get("Event").equals("subscribe")){
                List<TlkGzhfEntity> gzhfEntities =  gzhfEntityService.findAll();
                if(gzhfEntities!=null&&gzhfEntities.size()>0){
                    if(gzhfEntities.get(0).getItemHfnr()!=null){
                        String openid = message.get("FromUserName");
                        customInterface.send(accessTokenService.getAccessToken(),openid,gzhfEntities.get(0).getItemHfnr());
                    }
                }
            }
        }
            TlkUserEntity userEntity = userService.getUserByOpenid(message.get("FromUserName"));
            List<TlkMhdxxbmEntity> list = eventTemplateService.findByUserOpenidandDate(userEntity.getId(),new Date());
            for(TlkMhdxxbmEntity tlkMhdxxbmEntity:list){
                if(tlkMhdxxbmEntity.getItemSfgz().equals("1")){
                    tlkMhdxxbmEntity.setItemSfgz("0");
                    TlkMhdxxEntity tlkMhdxxEntity = eventTemplateService.findHdxxPageById(tlkMhdxxbmEntity.getItemHdbh(), new Date());
                    if(tlkMhdxxEntity!=null){
                        eventTemplateService.saveHDBM(tlkMhdxxbmEntity);
                        eventTemplateController.activitySuccessToUser(message.get("FromUserName"),tlkMhdxxEntity);
                        eventTemplateController.activitySuccessToCustmer(tlkMhdxxEntity,tlkMhdxxbmEntity.getItemName(),tlkMhdxxbmEntity.getItemLxfs());
                    }
                }
            }
        ResponseUtil.response(response,"ok");
    }
    @RequestMapping("isJoined")
    public void isJoined(@RequestParam("id")String id,HttpSession session,HttpServletResponse response){
        TlkWechatuserEntity wechatuserEntity = userController.getWechatUserBySession(session);
        Map<String, Object> message = new HashMap<String, Object>();
        if(wechatuserEntity==null){
            message.put("result", "fail");
            message.put("resultcode", "404");
            message.put("msg", "未获取到用户信息");
        }else{
            TlkProductEntity productEntity = productService.getProductByHDBH(id);
            TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(id);
            if (eventService.findByUserIdAndHdId(userController.getUserBySession(session).getId(), id) != null) {
                message.put("result", "success");
                message.put("resultcode", "200");
                message.put("msg", "已报名");
                message.put("data",true);
            }else{
                message.put("result", "success");
                message.put("resultcode", "200");
                message.put("msg", "未报名");
                message.put("data",false);
            }
        }
        ResponseUtil.response(response, new Gson().toJson(message));
    }
    @RequestMapping("saveyhhdbm")
    public void saveyhhdbm(@RequestParam("itemName")String itemName, @RequestParam("itemSex")String itemSex, @RequestParam("itemLxfs")String itemLxfs,@RequestParam("itemHdbh")String itemHdbh,@RequestParam(name="itemAge",required = false)String itemAge,@RequestParam(name = "itemDz",required = false)String itemDz,@RequestParam(name = "itemAihao",required = false)String itemAihao,@RequestParam(name = "itemGs",required = false)String itemGs,@RequestParam(name="itemPsdx",required = false) String itemPsdx, HttpServletResponse response, HttpSession session) {
        TlkWechatuserEntity wechatuserEntity = userController.getWechatUserBySession(session);
        Map<String, Object> message = new HashMap<String, Object>();
        if(wechatuserEntity==null){
            message.put("result", "fail");
            message.put("resultcode", "404");
            message.put("msg", "未获取到用户信息");
            ResponseUtil.response(response,new Gson().toJson(message));
            return;
        }
        else {
            TlkProductEntity productEntity = productService.getProductByHDBH(itemHdbh);
            TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(itemHdbh);
            if (eventService.findByUserIdAndHdId(userController.getUserBySession(session).getId(), itemHdbh) != null) {
                message.put("result", "fail");
                message.put("resultcode", "302");
                message.put("msg", "重复报名");
                ResponseUtil.response(response, new Gson().toJson(message));
                return;
            }
            if (tlkHdxxEntity != null) {
                TlkUserEntity userEntity = userService.getUserByOpenid(wechatuserEntity.getOpenid());
                if (productEntity != null) {
                    orderService.creatOrder(userEntity.getId(), productEntity.getItemCpbh(), new Date(), itemName, itemLxfs, itemSex, itemDz, tlkHdxxEntity.getItemName());
                }
                TlkHdxxbmEntity tlkHdxxbmEntity = new TlkHdxxbmEntity();
                tlkHdxxbmEntity.setItemName(itemName);
                tlkHdxxbmEntity.setItemSex(itemSex);
                tlkHdxxbmEntity.setItemLxfs(itemLxfs);
                tlkHdxxbmEntity.setItemHdbh(itemHdbh);
                tlkHdxxbmEntity.setItemDz(itemDz);
                tlkHdxxbmEntity.setItemAge(itemAge);
                tlkHdxxbmEntity.setItemGs(itemGs);
                tlkHdxxbmEntity.setItemXq(itemAihao);
                tlkHdxxbmEntity.setItemPsdx(itemPsdx);
                tlkHdxxbmEntity.setItemUserbh(userEntity.getId());
                eventService.saveYh(tlkHdxxbmEntity);
                message.put("result", "success");
                message.put("msg", "报名成功");
                ResponseUtil.response(response,new Gson().toJson(message));
                activity_joinsuccessMessage(wechatuserEntity.getOpenid(), tlkHdxxEntity, tlkHdxxbmEntity);
                activity_sendtoCustmer(tlkHdxxbmEntity, tlkHdxxEntity, true, itemName, itemLxfs);
            }else{
                message.put("result", "fail");
                message.put("resultcode", "500");
                message.put("msg", "报名失败，活动已结束或活动不存在");
                ResponseUtil.response(response,new Gson().toJson(message));
            }
        }
    }
    @RequestMapping("savesyshdbbm")
    public void savesyshdbbm(@RequestParam("itemName")String itemName, @RequestParam("itemSex")String itemSex, @RequestParam("itemLxfs")String itemLxfs,@RequestParam("itemHdbh")String itemHdbh, HttpServletResponse response, HttpSession session){
        TlkWechatuserEntity wechatUserBySession= userController.getWechatUserBySession(session);
        Map<String, Object> message = new HashMap<String, Object>();
        if(wechatUserBySession==null){
            message.put("result", "fail");
            message.put("resultcode", "404");
            message.put("msg", "未获取到用户信息");
            ResponseUtil.response(response,new Gson().toJson(message));
            return;
        }
        TlkPhotographerEntity tlkPhotographerEntity = photograoherService.getPhotographerByOpenid(wechatUserBySession.getOpenid());
        TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(itemHdbh);
        if (tlkPhotographerEntity!=null) {
            if(eventService.findBySysIdAndHdId(tlkPhotographerEntity.getId(),itemHdbh)!=null){
                message.put("result", "fail");
                message.put("resultcode", "302");
                message.put("msg", "重复报名");
                ResponseUtil.response(response,new Gson().toJson(message));
                return;
            }
            TlkHdxxbmEntity tlkHdxxbmEntity = new TlkHdxxbmEntity();
            tlkHdxxbmEntity.setItemName(itemName);
            tlkHdxxbmEntity.setItemSex(itemSex);
            tlkHdxxbmEntity.setItemLxfs(itemLxfs);
            tlkHdxxbmEntity.setItemHdbh(itemHdbh);
            tlkHdxxbmEntity.setItemSysbh(tlkPhotographerEntity.getId());
            eventService.saveYh(tlkHdxxbmEntity);
            activity_joinsuccessMessage(wechatUserBySession.getOpenid(),tlkHdxxEntity,tlkHdxxbmEntity);
            activity_sendtoCustmer(tlkHdxxbmEntity,tlkHdxxEntity,false,itemName,itemLxfs);
            message.put("result", "success");
            message.put("msg", "报名成功");
        }
        else {
            tlkPhotographerEntity = new TlkPhotographerEntity();
            tlkPhotographerEntity.setItemName(itemName);
            tlkPhotographerEntity.setItemSex(itemSex);
            tlkPhotographerEntity.setItemPhone(itemLxfs);
            tlkPhotographerEntity.setItemSyshdlx("0");
            tlkPhotographerEntity.setItemOpenid(tlkWechatuserEntityService.findByid(wechatUserBySession.getId()));
            tlkPhotographerEntity.setItemNc(wechatUserBySession.getNickname());
            String id= (String) photograoherService.saveHdSys(tlkPhotographerEntity);
            TlkHdxxbmEntity tlkHdxxbmEntity = new TlkHdxxbmEntity();
            tlkHdxxbmEntity.setItemName(itemName);
            tlkHdxxbmEntity.setItemSex(itemSex);
            tlkHdxxbmEntity.setItemLxfs(itemLxfs);
            tlkHdxxbmEntity.setItemHdbh(itemHdbh);
            tlkHdxxbmEntity.setItemSysbh(id);
            eventService.saveYh(tlkHdxxbmEntity);
            activity_joinsuccessMessage(wechatUserBySession.getOpenid(),tlkHdxxEntity,tlkHdxxbmEntity);
            activity_sendtoCustmer(tlkHdxxbmEntity,tlkHdxxEntity,false,itemName,itemLxfs);
            message.put("result", "success");
            message.put("msg", "报名成功");
        }
        ResponseUtil.response(response,new Gson().toJson(message));
    }
    void activity_joinsuccessMessage(String openid,TlkHdxxEntity activity,TlkHdxxbmEntity tlkHdxxbmEntity){
        String Template="AhCfKlh71ubtoXbfKkE9DOVJ8HPCA_Pr881QGvRoIIk";
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        wechatTemplateMessage.setTemplate_id(Template);
        wechatTemplateMessage.setTouser(openid);
        Map<String,WechatTemplateItem> data = new HashMap<>();
        data.put("keyword1",new WechatTemplateItem("报名成功","#619CC1"));
        data.put("keyword2",new WechatTemplateItem(activity.getItemName()));
        data.put("keyword3",new WechatTemplateItem(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        data.put("remark",new WechatTemplateItem("客服将尽快与您联系，感谢您的支持"));
        wechatTemplateMessage.setData(data);
        //System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
    }
    void activity_sendtoCustmer(TlkHdxxbmEntity tlkHdxxbmEntity,TlkHdxxEntity activity,boolean judgeType,String itemName,String itemLxfs){
        //true 表示用户  false表示摄影师
        String template="ao0j-rdUnmraGcMrchlZnIwncfNVwlDvZVHsXMUJqzU";
//        List<TlkPtUserWxbdEntity> userWxbdEntities = userWxbdDao.findAll();
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        wechatTemplateMessage.setTemplate_id(template);
        List<TlkPtUserWxbdEntity> userWxbdEntities = eventService.findAllCustomer();
        if(judgeType) {
            for(int i = 0;i < userWxbdEntities.size(); i++){
                Map<String,WechatTemplateItem> data = new HashMap<>();
                data.put("first",new WechatTemplateItem("用户报名通知"));
                data.put("keyword1",new WechatTemplateItem(activity.getItemName(),"#0070C0"));
                data.put("keyword2",new WechatTemplateItem(itemName));
                data.put("keyword3",new WechatTemplateItem(itemLxfs));
                data.put("remark",new WechatTemplateItem("请尽快与用户联系，并匹配摄影师。"));
                wechatTemplateMessage.setData(data);
                wechatTemplateMessage.setTouser(userWxbdEntities.get(i).getItemOpenid());
               // System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
            }
        }else{
            for(int i = 0;i< userWxbdEntities.size();i++){
                Map<String,WechatTemplateItem>data = new HashMap<>();
                data.put("first",new WechatTemplateItem("摄影师报名通知"));
                data.put("keyword1",new WechatTemplateItem(activity.getItemName(),"#0070C0"));
                data.put("keyword2",new WechatTemplateItem(itemName));
                data.put("keyword3",new WechatTemplateItem(itemLxfs));
                data.put("remark",new WechatTemplateItem("请尽快与摄影师联系，并匹配家庭。"));
                wechatTemplateMessage.setData(data);
                wechatTemplateMessage.setTouser(userWxbdEntities.get(i).getItemOpenid());
                //System.out.println(templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken()));
            }
        }
    }

}
