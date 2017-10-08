package com.lkp.controller;

import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.lkp.bean.WeChatCfg;
import com.lkp.service.AccessTokenService;
import com.lkp.service.OrderService;
import com.lkp.service.QuickService;
import com.lkp.service.TLkPhotograoherService;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("quickShare")
public class QuickShareController {
    @Autowired
    UserController userController;
    @Autowired
    OrderService orderService;
    @Autowired
    QuickService quickService;

    @Autowired
    TLkPhotograoherService photograoherService;
    @Autowired
    PhotoGrapherController photoGrapherController;
    @Autowired
    WeChatCfg weChatCfg;
    @Autowired
    AccessTokenService accessTokenService;

    @RequestMapping("shareToUserByOrderId")
    public void shareToUserByOrderId(@RequestParam("orderid") String orderid, @RequestParam("serverId") String servId,@RequestParam("templetId")String templetId,@RequestParam("scale") String scale,@RequestParam("transX") String transX,@RequestParam("transY") String transY, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        Map map = new HashMap();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        } else {
            if (photoGrapherController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }else if(quickService.findMbById(templetId)==null){
                map.put("errorCode", "404");
                map.put("errorMsg", "模板不存在");
            }
            //session中有用户信息
            else {
                try {
                    String file = quickService.shareToUser(orderid,servId,templetId,scale,transX,transY);
                    map.put("errorCode", "200");
                    map.put("errorMsg", "图片成功");
                    map.put("data",file);
                }catch (NullPointerException e){
                    e.printStackTrace();
                    map.put("errorCode", "500");
                    map.put("errorMsg", "不合法的图片格式，请上传JPG，png，jpeg等格式的文件");
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }
    @RequestMapping("share")
    public String share(@RequestParam("orderid")String orderid, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
        String directUrl="/photographer/QuickShare";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = userController.domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        model.addAttribute("orderid",orderid);
        return directUrl;
    }
}
