package com.lkp.controller;

import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkProductEntity;
import com.lkp.entity.TlkYingjiEntity;
import com.lkp.entity.webJsonSolution.Product;
import com.lkp.entity.webJsonSolution.ProductShow;
import com.lkp.service.AccessTokenService;
import com.lkp.service.ProductService;
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
@RequestMapping("PhotoProduct")
public class PhotoProduct {
    @Autowired
    UserController userController;
    @Autowired
    WeChatCfg weChatCfg;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    ProductService productService;
    @Autowired
    PhotoGrapherController photoGrapherController;
    Gson gson = new Gson();
    @RequestMapping("set")
    public String toCreate(HttpServletRequest request,Model model,@RequestParam(name = "id",required = false)String id,HttpSession session){
        String appid = weChatCfg.getAppId();
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = userController.domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        if(id!=null){
            TlkPhotographerEntity photographerEntity = photoGrapherController.getUserBySession(session);
            TlkProductEntity productEntity = productService.find(id);
            if(photographerEntity!=null&&productEntity!=null&&productEntity.getItemSys().equals(photographerEntity.getId()))
            model.addAttribute("id",id);
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        return "/photographer/setProduct";
    }
    @RequestMapping("save")
    public void saveProduct(HttpServletRequest request, HttpServletResponse response, @RequestParam("product")String product, @RequestParam(name = "productShow",required = false) String productShow, HttpSession session){
        String id = null;
        Map<String ,Object> map = new HashMap<String,Object>();
        TlkPhotographerEntity photographerEntity = photoGrapherController.getUserBySession(session);
        if(photographerEntity!=null){
            Product product1= gson.fromJson(product,Product.class);
            if(productShow!=null){
                ProductShow productShow1 = gson.fromJson(productShow,ProductShow.class);
                id = (String) productService.saveProduct(product1,productShow1,photographerEntity.getId());
            }else{
                id= (String) productService.saveProduct(product1,null,photographerEntity.getId());
            }
            if(id!=null){
                map.put("msg", id);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }else{
                map.put("errorCode", "500");
                map.put("errorMsg", "fail");
            }
        }else{
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo2");
        }
        ResponseUtil.response(response,gson.toJson(map));
    }

    /**
     * 产品提交审核
     * @param id
     * @param response
     */
    @RequestMapping("commit")
    public void commit(String id,HttpServletResponse response,HttpSession session){
        Map<String ,Object> map = new HashMap<String,Object>();
        TlkPhotographerEntity photographerEntity = photoGrapherController.getUserBySession(session);
        if(photographerEntity==null){
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo2");
            map.put("msg","未获取到用户信息，请重新进入平台");
        }else{
            TlkProductEntity productEntity = productService.find(id);
            if(productEntity==null){
                map.put("errorCode", "500");
                map.put("errorMsg", "product not exist!");
                map.put("msg","该产品不存在");
            }else if(!productEntity.getItemSys().equals(photographerEntity.getId())){
                map.put("errorCode", "500");
                map.put("errorMsg", "product not match to photographer!");
                map.put("msg","产品与摄影师不符");
            }else {
                productService.updateProductState(id,"1");
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("msg","提交成功!");
            }
        }
        ResponseUtil.response(response,gson.toJson(map));
    }
    @RequestMapping("getProduct")
    public void getProduct(@RequestParam("id")String id, HttpSession session,HttpServletResponse response){
        Map<String ,Object> map = new HashMap<String,Object>();
        TlkPhotographerEntity photographerEntity = photoGrapherController.getUserBySession(session);
        if(photographerEntity==null){
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo2");
            map.put("msg","未获取到用户信息，请重新进入平台");
        }else{
            TlkProductEntity productEntity = productService.find(id);
            if(productEntity==null){
                map.put("errorCode", "500");
                map.put("errorMsg", "product not exist!");
                map.put("msg","该产品不存在");
            }else if(!productEntity.getItemSys().equals(photographerEntity.getId())){
                map.put("errorCode", "500");
                map.put("errorMsg", "product not match to photographer!");
                map.put("msg","产品与摄影师不符");
            }else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("msg",productService.find(id));
            }        }
        Gson gson1 = new GsonBuilder().addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response,gson1.toJson(map));
    }
}
