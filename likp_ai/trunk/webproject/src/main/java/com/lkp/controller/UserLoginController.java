package com.lkp.controller;

import com.cxt.wechat.oauth2.Oauth2;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lkp.bean.WeChatCfg;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.service.AccessTokenService;
import com.lkp.service.TLkPhotograoherService;
import com.lkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
public class UserLoginController {
    Oauth2 oauth2 = new Oauth2();
    Gson gson = new Gson();
    final String domai = "http://www.91lkp.com";
    @Autowired
    UserService userService;
    @Autowired
    TLkPhotograoherService tLkPhotograoherService;
    @Autowired
    WeChatCfg weChatCfg;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    UserController userController;

    @RequestMapping("userlogin/{loginType}/{target}")
    public String userlogin(@PathVariable("loginType") String loginType, @PathVariable("target") String target, @RequestParam(value = "code") String code, @RequestParam(value = "state") String state, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String accessStr = oauth2.access_token("wx41ae02856c6d39a6", "168e0a0d5441c0665efec93c951fdc7b", code);

        System.out.println("用户微信accesstoken---------------\n" + accessStr);

        Map<String, String> accessmap = gson.fromJson(accessStr, new TypeToken<HashMap<String, String>>() {
        }.getType());
        if (accessmap != null && accessmap.get("access_token") != null && accessmap.get("openid") != null) {
            String userInfoStr = oauth2.userinfo(accessmap.get("access_token"), accessmap.get("openid"));

            System.out.println("用户微信信息--------\n" + userInfoStr);

            TlkWechatuserEntity wechatUser = gson.fromJson(userInfoStr, TlkWechatuserEntity.class);
            if (wechatUser != null) {
                //保存到微信表
                String userid = (String) userService.addUserByWeChatInfo(wechatUser);
                request.getSession().setAttribute(Constant.USERID, userid);
                //跳转到用户首页
                if(loginType.equals("activity")){
                    return "redirect:/activity/"+target+".jsp";
                }
                if(loginType.equals("activityTemple")){
                    return "redirect:/ActivityTemplate/info?id="+target;
                }if(loginType.equals("yingji")){
                    return "redirect:/YINGJI/Newset";
                }
                if(loginType.equals("order")){
                    return "redirect:/wechatuser/orderStateShow.html?id="+target;
                }
                return "redirect:/wechatuser/MainInterface.html";
            }
        }
        return "redirect:/wechatuser/MainInterface.html";
    }

    //摄影师登录
    @RequestMapping("cameramanlogin/{loginType}/{target}")
    public String cameramanlogin(@PathVariable("loginType") String loginType, @PathVariable("target") String target, @RequestParam(value = "code") String code, @RequestParam(value = "state") String state, HttpServletRequest request,Model model) {
        ModelAndView mv = new ModelAndView();
        String accessStr = oauth2.access_token("wx41ae02856c6d39a6", "168e0a0d5441c0665efec93c951fdc7b", code);

        System.out.println("用户微信accesstoken---------------\n" + accessStr);

        Map<String, String> accessmap = gson.fromJson(accessStr, new TypeToken<HashMap<String, String>>() {
        }.getType());
        if (accessmap != null && accessmap.get("access_token") != null && accessmap.get("openid") != null) {
            String userInfoStr = oauth2.userinfo(accessmap.get("access_token"), accessmap.get("openid"));

            System.out.println("用户微信信息--------\n" + userInfoStr);

            TlkWechatuserEntity wechatUser = gson.fromJson(userInfoStr, TlkWechatuserEntity.class);
//            if (wechatUser != null) {
//                //保存到微信表
//                String sysid = (String) userService.addUserByWeChatInfo(wechatUser);
//                request.getSession().setAttribute(Constant.SYSID,sysid);
//                //跳转到摄影师首页
//                return "redirect:/photographer/ordercenter.html";
//            }
            String sysopenid = wechatUser.getOpenid();
//            sysopenid = "olp-hvxdut0amfHZpWOGioqKQjxw";
            //判断是否是摄影师
            TlkPhotographerEntity tlkPhotographerEntity = tLkPhotograoherService.getPhotographerByOpenid(sysopenid);
            if(tlkPhotographerEntity != null){
                //跳到摄影师页面
                request.getSession().setAttribute(Constant.SYSENTITY,tlkPhotographerEntity);
                if(loginType.equals("order")){
                    return "redirect:/photographer/orderdetail.html?id="+target;
                }
                return "redirect:/photographer/sheyingshi-zhuye.html";
            }else{
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
                String userid = (String) userService.addUserByWeChatInfo(wechatUser);
                request.getSession().setAttribute(Constant.USERID,userid);
                //跳转到用户首页
                return "/photographer/notphotographer";
            }

        }
        return "redirect:/photographer/sheyingshi-zhuye.html";
    }
    //活动短连接登录
    @RequestMapping("activityShortUrl/{target}")
    public String activityShortUrl(HttpServletRequest request,@PathVariable("target")String target){
        HttpSession session = request.getSession();
        if(session!=null){
            if(userController.getUserBySession(session)!=null){
                return "redirect:/ActivityTemplate/info?id="+target;
            }
        }
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+target+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
    }
}
