package com.lkp.controller;

import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.lkp.bean.WeChatCfg;
import com.lkp.dao.TlkWechatJsticketEntityDao;
import com.lkp.entity.TlkOrderproductEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.entity.TlkYingjiEntity;
import com.lkp.service.AccessTokenService;
import com.lkp.service.OrderService;
import com.lkp.service.YingjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 */
@Controller
@RequestMapping("YINGJI")
public class YingjiController {
    final String domai = "http://www.91lkp.com";
    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    YingjiService yingjiService;

    @Autowired
    UserController userController;

    @Autowired
    OrderService orderService;


    @RequestMapping("set")
    public String set(@RequestParam(name = "id",required = false)String id,@RequestParam(name = "orderid",required = false)String orderid , HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        String directUrl="/yingji/yingjiset";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        TlkOrderproductEntity orderproductEntity = yingjiService.getOrderByYingjiId(id);
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        if(id!=null&&!id.equals("")){
            TlkYingjiEntity yj = yingjiService.getYingjiById(id);
            model.addAttribute("title",yj.getItemTitle());
            model.addAttribute("id",id);
            model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
            model.addAttribute("des",yj.getItemDes());
        }
        if(orderproductEntity!=null&&!orderproductEntity.getItemOrderid().equals("")){
            model.addAttribute("orderid",orderproductEntity.getId());
        }
        return directUrl;
    }

    @RequestMapping("Newset")
    public String Newset(@RequestParam(name = "id",required = false)String id, @RequestParam(name = "orderid",required = false)String orderid , HttpServletRequest request, Model model, HttpSession session){
        if(userController.getUserBySession(session)==null){
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2f"+request.getServerName()+request.getContextPath()+"%2fuserlogin%2fyingji%2f1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        }
        String appid = weChatCfg.getAppId();
        String directUrl="/yingji/yingjiNewset";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        TlkOrderproductEntity orderproductEntity = yingjiService.getOrderByYingjiId(id);
        TlkOrderproductEntity orderproductEntity1 = orderService.findOrderProductById(orderid);
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        if(id!=null&&!id.equals("")){
            TlkYingjiEntity yj = yingjiService.getYingjiById(id);
            model.addAttribute("title",yj.getItemTitle());
            model.addAttribute("id",id);
            model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
            model.addAttribute("des",yj.getItemDes());
            if(orderproductEntity!=null&&!orderproductEntity.getItemOrderid().equals("")){
                model.addAttribute("orderid",orderproductEntity.getId());
            }else{
                if(orderid!=null&&!orderid.equals("")){
                    if(orderproductEntity1!=null&&!orderproductEntity1.getItemOrderid().equals("")) {
                        model.addAttribute("orderid", orderproductEntity1.getId());
                    }
                }
            }
        }else{
            if(orderid!=null&&!orderid.equals("")){
                if(orderproductEntity1!=null&&!orderproductEntity1.getItemOrderid().equals("")) {
                    model.addAttribute("orderid", orderproductEntity1.getId());
                }
            }
        }
        return directUrl;
    }
    @RequestMapping("yingji")
    public String yingji(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        String directUrl="/share/yingjishow";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        System.out.println(url);
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        model.addAttribute("title",yj.getItemTitle());
        model.addAttribute("id",id);
        model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }
    @RequestMapping("newYingji")
    public String newYingji(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        String directUrl="/share/yingjiplay";
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
        model.addAttribute("title",yj.getItemTitle());
        model.addAttribute("id",id);
        if(yj.getItemCover()!=null&&!yj.getItemCover().equals("")){
            model.addAttribute("imgurl",yj.getItemCover());
        }else {
            model.addAttribute("imgurl", yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
        }
        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }
    @RequestMapping("newStaticYingji")
    public String newStaticYingji(@RequestParam(name = "id")String id, HttpServletRequest request, Model model,HttpSession session){
        TlkUserEntity tlkuser = userController.getUserBySession(session);
        String appid = weChatCfg.getAppId();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        String directUrl="/share/yingjijingtai";
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
        model.addAttribute("title",yj.getItemTitle());
        model.addAttribute("id",id);
        if(yj.getItemCover()!=null&&!yj.getItemCover().equals("")){
            model.addAttribute("imgurl",yj.getItemCover());
        }else {
            model.addAttribute("imgurl", yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
        }
        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }
    @RequestMapping("yingjishow")
    public String yingjiShow(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        String directUrl="/share/yingji";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        System.out.println(url);
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        model.addAttribute("title",yj.getItemTitle());
        model.addAttribute("id",id);
        model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }

    @RequestMapping("yingjiset")
    public String yingjiSet(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        String directUrl="/share/yingjiset";
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
        model.addAttribute("title",yj.getItemTitle());
        model.addAttribute("id",id);
        model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }
}
