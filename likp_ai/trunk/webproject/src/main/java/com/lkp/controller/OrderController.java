package com.lkp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.OrderExclusionStrategy;
import com.lkp.controller.exclusionStrategys.SysInforExclusionStrategy;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.service.AccessTokenService;
import com.lkp.service.OrderService;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("ORDER")
public class OrderController {
    final String domai = "http://www.91lkp.com";
    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserController userController;
    /**
     * 评价摄影师页面接口
     *
     * @param id       订单编号
     * @param request
     * @param response
     */
    @RequestMapping("pjsys")
    public void getSysByOrderid(@RequestParam(name = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (userController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkPhotographerEntity tlkPhotographerEntity = orderService.findOrderProductById(id).getItemSysid();
                if (tlkPhotographerEntity != null) {
                    map.put("errorCode", "200");
                    map.put("errorMsg", "success");
                    map.put("sys", tlkPhotographerEntity);
                } else {
                    map.put("errorCode", "403");
                    map.put("errorMsg", "target not exist");
                }
            }
        }

        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new OrderExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    @RequestMapping("savepjsys")
    public void savePjsys(@RequestParam("id") String id, @RequestParam("num") String num, @RequestParam("btn") String btn, @RequestParam("words") String words, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (userController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                if (orderService.updateSyspj(id, num, btn, words, new Date())) {
                    map.put("errorCode", "200");
                    map.put("errorMsg", "success");
                } else {
                    map.put("errorCode", "403");
                    map.put("errorMsg", "target not exist");
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }
}
