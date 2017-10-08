package com.lkp.controller;

import com.cxt.wechat.message.Text;
import com.google.gson.reflect.TypeToken;
import com.lkp.entity.UserScanRecord;
import com.lkp.controller.websocket.SystemWebSocketHandler;
import com.lkp.service.UserScanRecordService;
import com.google.gson.Gson;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("inner")
public class LoginReciverController {

    long time = 5 * 60 * 1000;

    @Bean
    public SystemWebSocketHandler systemWebSocketHandler() {
        return new SystemWebSocketHandler();
    }

    Gson gson = new Gson();

    @Autowired
    UserScanRecordService userScanRecordService;

    /**
     * 接收微信的扫描信息
     *
     */
    @RequestMapping("qrcode")
    @ResponseBody
    public void getEvent(HttpServletRequest request, HttpServletResponse response) {
        try {
            /*HashMap<String, String> message = wechatXmlUtil.parseXml(request);*/


            HashMap<String, String> message =  new Gson().fromJson(request.getReader(),new TypeToken<HashMap<String, String>>(){}.getType());
            System.out.println("关注ticket===="+message);


            /**
             * 发送文字信息
             */
            if (message.get("MsgType").equals("text")) {
                System.out.println("text");
            }
            /**
             * 接收事件
             */
            if (message.get("MsgType").equals("event")) {

                System.out.println("EventType===="+message.get("Event"));

                /**
                 * 用户关注
                 */
                if (message.get("Event").equals("subscribe")) {

                    /**
                     * 用户通过带参数的二维码关注
                     */

                    if (message.get("Ticket") != null) {
                                String ticket = message.get("Ticket");
                                String fromUser = message.get("FromUserName");

                                System.out.println("关注ticket===="+ticket);

                                Map<String, Object> map = new HashMap<String, Object>();
                                map.put("action", "scan");
                                map.put("ticket", ticket);
                                UserScanRecord userScanRecord = new UserScanRecord();
                                userScanRecord.setUsed(false);
                                userScanRecord.setItemOpenid(fromUser);
                                userScanRecord.setItemTicket(ticket);
                                Date create = new Date();
                                userScanRecord.setCreated(create);
                                Date last = new Date(create.getTime() + time);
                                userScanRecord.setLastdate(last);
                                String id = (String)userScanRecordService.save(userScanRecord);
                                map.put("id",id);

                                systemWebSocketHandler().sendMessageToUser(ticket, map);

                        }

                    }
                    /**
                     * 用户关注后扫描待参数的二维码
                     */
                    else if (message.get("Event").equals("SCAN")) {
                        String ticket = message.get("Ticket");
                        String fromUser = message.get("FromUserName");


                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("action", "scan");
                        map.put("ticket", ticket);
                        UserScanRecord userScanRecord = new UserScanRecord();
                        userScanRecord.setUsed(false);
                        userScanRecord.setItemOpenid(fromUser);
                        userScanRecord.setItemTicket(ticket);
                        Date create = new Date();
                        userScanRecord.setCreated(create);
                        Date last = new Date(create.getTime() + time);
                        userScanRecord.setLastdate(last);
                        String id = (String)userScanRecordService.save(userScanRecord);
                        map.put("id",id);
                        systemWebSocketHandler().sendMessageToUser(ticket, map);
                    System.out.println("处理扫描事件信息完毕--------------------");

                    }
                    /**
                     * 上报地理位置事件
                     */
                    else if (message.get("Event").equals("LOCATION")) {
                    System.out.println("接收地理位置信息-------");

                    }
                    /**
                     * 自定义菜单事件
                     */
                    else if (message.get("Event").equals("CLICK")) {

                    }
                    /**
                     * 点击菜单跳转链接时的事件推送
                     */
                    else if (message.get("Event").equals("VIEW")) {

                    }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseUtil.response(response, "success");
    }



//    public String qrcode(@RequestParam("ticket") String ticket, @RequestParam("openid") String openid) {
//
//
//        System.out.println("收到ticket扫描信息：ticket = " + ticket);
//        System.out.println("123456789111111111111------------------");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("action", "scan");
//        map.put("ticket", ticket);
//        UserScanRecord userScanRecord = new UserScanRecord();
//        userScanRecord.setUsed(false);
//        userScanRecord.setItemOpenid(openid);
//        userScanRecord.setItemTicket(ticket);
//        Date create = new Date();
//        userScanRecord.setCreated(create);
//        Date last = new Date(create.getTime() + time);
//        userScanRecord.setLastdate(last);
//        String id = (String)userScanRecordService.save(userScanRecord);
//        map.put("id",id);
//        System.out.println("向用户发送扫描信息" + ticket);
//        systemWebSocketHandler().sendMessageToUser(ticket, map);
//        return "ok";
//    }
}
