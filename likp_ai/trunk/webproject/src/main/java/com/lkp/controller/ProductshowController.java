package com.lkp.controller;

import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.controller.exclusionStrategys.ProductWithoutShowPicExclusionStrategy;
import com.lkp.controller.exclusionStrategys.productshowWithShowPicStrategy;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkProductshowEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.entity.TlkYingjiEntity;
import com.lkp.service.AccessTokenService;
import com.lkp.service.ProductshowService;
import com.lkp.util.ResponseUtil;
import com.lkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("productshow")
public class ProductshowController {
    @Autowired
    ProductshowService productshowService;
    @Autowired
    ProductService productService;
      /*查询产品列表，通过id
    * */
    @RequestMapping("find")
    public void find(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(productshowService.find(id)));
    }
    /**
     * 通过摄影师编号获得产品信息
     */
    @RequestMapping("findallBySysid")
    public void findallBySysid(HttpServletRequest request,
                               HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        } else {
            if (getSysBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without sysinfo2");
            }
            //session中有sys信息
            else {
                TlkPhotographerEntity tlkPhotographerEntity = getSysBySession(session);
                System.out.println(tlkPhotographerEntity.getId());
//                map.put("allCp", productService.getZuoyeInforBySysId("11e6-aa56-074328db-ad8b-11472dfbd6fd"));
                map.put("allCp", productService.getZuoyeInforBySysId(tlkPhotographerEntity.getId()));
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    @RequestMapping("findZuopingBySysid")
    public void findzuopingbysysid(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        if(session == null){
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        }else {
            if (getSysBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without sysinfo2");
            }else {
                TlkPhotographerEntity tlkPhotographerEntity = getSysBySession(session);
                List<TlkProductshowEntity> tlkProductshowEntities = productService.getZuopingBySysid(tlkPhotographerEntity.getId());
                map.put("errorCode", "200");
                map.put("result","success");
                map.put("data",tlkProductshowEntities);
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new productshowWithShowPicStrategy())
                .create();
        ResponseUtil.response(response,gson.toJson(map));
    }



    /**
     * 通过session获取用户信息
     *
     * @param session
     * @return
     */
    TlkPhotographerEntity getSysBySession(HttpSession session) {
        TlkPhotographerEntity tlkPhotographerEntity = null;
        if (session.getAttribute(Constant.SYSENTITY) != null) {
            tlkPhotographerEntity = (TlkPhotographerEntity) session.getAttribute(Constant.SYSENTITY);
        }
        return tlkPhotographerEntity;
    }

}
