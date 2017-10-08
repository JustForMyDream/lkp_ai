package com.lkp.controller;

import com.cxt.wechat.Template.TemplateMessageBussiness;
import com.cxt.wechat.Template.TemplateMessageBussinessImpl;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateItem;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lkp.dao.impl.BaseDaoImpl;
import com.lkp.entity.TlkHdxxEntity;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("backstage")
public class BackStageController {
    Gson gson = new Gson();
    TemplateMessageBussiness templateMessageBussiness = new TemplateMessageBussinessImpl();
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    TlkWechatuserEntityService wechatuserEntityService;

    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @RequestMapping("sendTempleMessage")
    public void sendTempleMessage(@RequestParam("id") String templateId, @RequestParam("openid")String toUser, @RequestParam("content")String content, @RequestParam(name = "url",required = false)String url, HttpServletResponse response){
        Map<String,String> map =gson.fromJson(content,new TypeToken<HashMap<String,String>>(){}.getType());
         String result = sedTempleMessage(templateId,toUser,map,url);
        ResponseUtil.response(response,result);
    }
    @RequestMapping("sendActiteMessageTouser")
    public void sendActiteMessageTouser(@RequestParam("id")String id,@RequestParam("userid") String userid,HttpServletResponse response){
        String url=null;
        ResponseUtil.response(response,"ok");
        TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(id);
        TlkWechatuserEntity wechatuserEntity=wechatuserEntityService.findByid(userid);
        String hdName = tlkHdxxEntity.getItemName();
        Map<String,WechatTemplateItem> map = new HashMap<String,WechatTemplateItem>();
        map.put("first",new WechatTemplateItem(wechatuserEntity.getNickname()+"，您好！"));
        map.put("keyword1",new WechatTemplateItem(tlkHdxxEntity.getItemName()+" 即将开始","#C00000"));
        if(tlkHdxxEntity.getItemDate()!=null){
            map.put("keyword2",new WechatTemplateItem("活动时间 "+new SimpleDateFormat("yyyy-MM-dd HH:mm").format(tlkHdxxEntity.getItemDate()),"#C00000"));
        }else{
            map.put("keyword2",new WechatTemplateItem(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),"#C00000"));
        }
        map.put("remark",new WechatTemplateItem("点击查看活动详情"));
        if(tlkHdxxEntity.getItemInfoUrl()!=null){
            url=tlkHdxxEntity.getItemInfoUrl();
        }
        String teId= "0KEHfsgb8_mvhEJmaFpUICt_jlnZi3HPYFXnfzQ_59o";
        System.out.println(sedTempleMessage(teId,wechatuserEntity.getOpenid(),map,url));
    }
    @RequestMapping("sendActiteMessage")
    public void sendActiteMessage(@RequestParam("id")String id,HttpServletResponse response){
        System.out.println("-----------------"+id);
        TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(id);
        String hdName = tlkHdxxEntity.getItemName();
        Map<String,String> map = new HashMap<String,String>();
        map.put("first","xxxx通知");
        map.put("keyword1","12341ssahuo活动");
        map.put("keyword2","12341ssahuo活动");
        map.put("remark","remark");
        String teId= "0KEHfsgb8_mvhEJmaFpUICt_jlnZi3HPYFXnfzQ_59o";/*活动模板消息id*/
        List<TlkWechatuserEntity> list = wechatuserEntityService.findAll();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getOpenid().equals("olp-hvxdut0amfHZpWOGioqKQjxw"))
            sedTempleMessage(teId,list.get(i).getOpenid(),map,null);
        }
        ResponseUtil.response(response,"ok");
    }
    @RequestMapping("sendActiveToRegistrationUser")
    public void sendActiveToRegistrationUser(@RequestParam("id")String id,@RequestParam("userid")String toRegistration,@RequestParam("content")String content,@RequestParam(name="url",required = false)String url,HttpServletResponse response){
        System.out.println("--------------------"+id);
        TlkHdxxEntity tlkHdxxEntity = eventService.getHdxxByHdBh(id);
        String ItemName = tlkHdxxEntity.getItemName();
        Map<String,String> map = new HashMap<String, String>();
        map.put("first","你报名的活动");
        map.put("keyword1",tlkHdxxEntity.getItemName());
        map.put("keyword2",new SimpleDateFormat("yy-MM-dd").format(new Date()));
        map.put("remark","厉害了我的锅");
        String teId = "0KEHfsgb8_mvhEJmaFpUICt_jlnZi3HPYFXnfzQ_59o";
        sedTempleMessage(teId,toRegistration,map,null);
    }
    private String sedTempleMessage(String templateId,String toUser,Map content,String url){
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        wechatTemplateMessage.setTemplate_id(templateId);
        wechatTemplateMessage.setTemplate_id(templateId);
        wechatTemplateMessage.setTouser(toUser);
        if(url!=null&&!"".equals(url.trim()))   wechatTemplateMessage.setUrl(url);
        if(content!=null&&!content.isEmpty()){
            Map<String,WechatTemplateItem> map = new HashMap<>();
            Iterator iterator = content.keySet().iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                if(content.get(key) instanceof WechatTemplateItem){
                    map.put(key,(WechatTemplateItem)content.get(key));
                }else {
                    map.put(key, new WechatTemplateItem((String) content.get(key)));
                }
            }
            wechatTemplateMessage.setData(map);
        }
        return templateMessageBussiness.send(wechatTemplateMessage,accessTokenService.getAccessToken());
    }
}
