package com.lkp.controller;

import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.CommonExclusionStrategy;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.controller.exclusionStrategys.ProductWithoutShowPicExclusionStrategy;
import com.lkp.entity.TlkProductEntity;
import com.lkp.service.ProductService;
import com.lkp.util.ResponseUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("common")
public class CommonController {
    @Autowired
    ProductService productService;

    @Autowired
    WeChatCfg weChatCfg;

    WeChatSingUtil weChatSingUtil = new WeChatSingUtil();

    /**
     * 首页产品列表接口（不包含展示的详细图片）
     * 获取首页显示的产品列表
     * @param response
     */
    @RequestMapping("index/productList")
    public void indexShowProductList(HttpServletResponse response) {
        List<TlkProductEntity> productEntities = productService.getProduct(1, 4);
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(productEntities));
    }

    /**
     * 获取主题列表
     * @param response
     */
    @RequestMapping("index/productMain")
    public void productMainList(HttpServletResponse response){
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(productService.getProductMains()));
    }

    /**
     *获取主题详情
     * @param response
     * @param id
     */
    @RequestMapping("index/productMainDetail")
    public void productMainProduct(HttpServletResponse response,@RequestParam(name = "id") String id){
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(productService.findByid(id)));
    }

    /**
     * 根据订单编号查询展示详情（包含展示的详细图片）
     * @param response
     * @param prodectId 产品编号
     */
    @RequestMapping("index/productDetail")
    public void indexShowProductDetail(HttpServletResponse response, @RequestParam(name = "id")String prodectId){
        System.out.println("request-accepted"+new Date().getTime());
        TlkProductEntity tlkProductEntity =  productService.find(prodectId);
        System.out.println("data-load finish"+new Date().getTime());
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
     //   System.out.println(gson.toJson(tlkProductEntity));
        ResponseUtil.response(response, gson.toJson(tlkProductEntity));
        System.out.println("response----"+new Date().getTime());
    }

    /**
     * 获取微信js——ticket所需的数据
     * @param url 网址
     * @param response
     */
    @RequestMapping("wxjs/getJS_ticket")
    public void getJS_ticket(HttpServletResponse response,@RequestParam("url") String url){
        Map<String,Object> map = new HashMap<String,Object>();
        String appid = weChatCfg.getAppId();
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
    /*    String signature = SignUtil.jssdkSign();
        map.put("appId",appid);
        map.put("timestamp",timestamp);
        map.put("nonceStr", nonceStr);
        map.put("signature", signature);*/
    }
    @RequestMapping("index/getOrderByProductCount")
    public void indexGetOrderByProductCount(HttpServletResponse response){
        Gson gson = new GsonBuilder()
                .addDeserializationExclusionStrategy(new ProductWithoutShowPicExclusionStrategy()).addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                        return "itemZsyj".equals(fieldAttributes.getName())||"tlkProductshowEntity".equals(fieldAttributes.getName())||"tlkProductEntity".equals(fieldAttributes.getName())||"tlkProductshowEntities".equals(fieldAttributes.getName())||"tlkCpfwxqEntitys".equals(fieldAttributes.getName());
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                }).create();
        ResponseUtil.response(response,gson.toJson(productService.getOderbyProductCount()));
    }
}
