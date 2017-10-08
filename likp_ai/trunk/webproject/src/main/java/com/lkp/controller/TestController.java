package com.lkp.controller;

import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lkp.bean.WeChatCfg;
import com.lkp.dao.ProductDao;
import com.lkp.entity.*;
import com.lkp.service.AccessTokenService;
import com.lkp.service.ProductService;
import com.lkp.service.TLkPhotograoherService;
import com.lkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 用户测试的外部接口
 */
@Controller
@RequestMapping("test")
public class TestController {
//    final String domai = "http://www.91lkp.com";
    final String domai = "http://192.168.1.6:8080";

    @Autowired
    private ProductService productService;
    @Autowired
    WeChatCfg weChatCfg;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    private UserService userService;
    @Autowired
    TLkPhotograoherService tLkPhotograoherService;

    Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
        //按照字段名排除
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return "tlkProductEntity".equals(fieldAttributes.getName()) || "tlkProductshowEntity".equals(fieldAttributes.getName());
        }

        //按照类排除
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }).create();

    @RequestMapping(path = "addandfind")
    @ResponseBody
    public String testadd(@RequestParam("id") String id) {
        TlkProductEntity tlkProductEntity = new TlkProductEntity();
        tlkProductEntity.setId(id);
        String ID = (String) productService.save(tlkProductEntity);
        TlkProductEntity tlkProductEntity1 = productService.find(ID);
        return gson.toJson(tlkProductEntity1);
    }

    @RequestMapping(path = "getProductById")
    @ResponseBody
    public String getProductById(@RequestParam("id") String id) {
        return gson.toJson(productService.find(id));
    }

    @RequestMapping(path = "testAddUser")
    @ResponseBody
    public String addUserByUserService() {
        String id = null;
        TlkWechatuserEntity tlkWechatuserEntity = new TlkWechatuserEntity();
        tlkWechatuserEntity.setOpenid("liuchuandeopenid");
        id = (String) userService.addUserByWeChatInfo(tlkWechatuserEntity);
        return id;
    }


    @RequestMapping("testaddUserSession")
    @ResponseBody
    public String userlogin(@RequestParam(value = "userid") String userid, HttpServletRequest request) {
        //40288187584e773401584e7acac20000
        ModelAndView mv = new ModelAndView();
        //保存到微信表
        System.out.println("访问addUserSession");
        request.getSession().setAttribute(Constant.USERID, userid);
        //跳转到用户首页
        return "successUser";
    }
    @RequestMapping("testaddSysSession")
    @ResponseBody
    public String syslogin(HttpServletRequest request) {
        //40288187584e773401584e7acac20000
//        ModelAndView mv = new ModelAndView();
        //保存到微信表
        System.out.println("访问addSysSession");
        TlkPhotographerEntity tlkPhotographerEntity = tLkPhotograoherService.getPhotographerByOpenid("olp-hv3OH7oOLnlEAdzOH5aCTKr0");
        System.out.println(tlkPhotographerEntity.getItemBh());
        request.getSession().setAttribute(Constant.SYSENTITY, tlkPhotographerEntity);
        //跳转到用户首页
        return "successSys";
    }
    @RequestMapping("addUserSession")
    @ResponseBody
    public String userSession(HttpServletRequest request){
        TlkUserEntity userEntity = userService.getUserById("297e9e7959126f060159160f6bae003f");
        request.getSession().setAttribute(Constant.USER, userEntity);
        return "success";
    }

    @RequestMapping("testwechat")
    public String yingjiSet(HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        String directUrl="/example/testwechat";
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
//        model.addAttribute("title",yj.getItemTitle());
//        model.addAttribute("id",id);
//        model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
//        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }
}
