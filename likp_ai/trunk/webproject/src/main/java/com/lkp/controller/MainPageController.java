package com.lkp.controller;

import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.lkp.bean.WeChatCfg;
import com.lkp.entity.*;
import com.lkp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 */
@Controller
@RequestMapping("MainPage")
public class MainPageController {
    final String domai = "http://www.91lkp.com";

    @Autowired
    WeChatCfg weChatCfg;

   @Autowired
   ProductService productService;

    @Autowired
    TLkPhotograoherService tLkPhotograoherService;
    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    TlkSctjService tlkSctjService;

    @Autowired
    FwzMessService fwzMessService;

    @Autowired
    TlkZbjqEntityService tlkZbjqEntityService;

    @Autowired
    ProductshowService productshowService;

    @RequestMapping("ProductInfor")
    public String ProductInfor(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkProductEntity product = productService.find(id);
        String directUrl = "/wechatuser/detail1";
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
        model.addAttribute("title",product.getItemName());
        model.addAttribute("id",product.getId());
        return directUrl;
    }


    @RequestMapping("SysInfor")
    public String SysInfor(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkPhotographerEntity photographer = tLkPhotograoherService.findById(id);
        String directUrl = "/wechatuser/profile_service";
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
        model.addAttribute("name",photographer.getItemName());
        model.addAttribute("id",photographer.getId());
        model.addAttribute("Bgimg",photographer.getFmbjtp());
        model.addAttribute("img",photographer.getItemHeadimg());
        model.addAttribute("bh",photographer.getItemBh());
        return directUrl;
    }

    @RequestMapping("DZPrint")
    public String DZPrint(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkSctjEntity printTJ = tlkSctjService.find(id);
        String directUrl = "/wechatuser/Output_recommendation";
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
        model.addAttribute("id",printTJ.getId());
        return directUrl;
    }


    @RequestMapping("ZhouBianJingQu")
    public String ZhouBianJingQu(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkZbjqEntity zbjqEntity = tlkZbjqEntityService.getZbjqInfobyid(id);
        String directUrl = "/wechatuser/zhoubianjingqu";
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
        model.addAttribute("id",zbjqEntity.getId());
        return directUrl;
    }


    @RequestMapping("ServiceStation")
    public String ServiceStation(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkFwzEntity ServiceStation = fwzMessService.findFwzMessageById(id);
        String directUrl = "/wechatuser/service_station";
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
        model.addAttribute("id",ServiceStation.getId());
        return directUrl;
    }


    @RequestMapping("Zuoping")
    public String Zuoping(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkProductshowEntity Zuoping = productshowService.find(id);
        String directUrl = "/share/product_Detail";
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
        model.addAttribute("id",Zuoping.getId());
        return directUrl;
    }



}
