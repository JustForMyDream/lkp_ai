package com.lkp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.controller.exclusionStrategys.SysInforExclusionStrategy;
import com.lkp.entity.TlkFwzEntity;
import com.lkp.entity.TlkZbjqEntity;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("homePage")
public class HomePageController {
    @Autowired
    HomePageService homePageService;

    @Autowired
    FwzMessService fwzMessService ;

    @Autowired
    TlkSctjService tlkSctjService;

    @Autowired
    TLkPhotograoherService tLkPhotograoherService;

    @Autowired
    TlkZbjqEntityService tlkZbjqEntityService;


    /*
    * 查找主界面信息
    * */
    @RequestMapping("MainInterface")
    public void MainInterface(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Lbtp", homePageService.findAllLbgl());
        map.put("SysInfor",tLkPhotograoherService.FindTwoAllSysXJ());
        map.put("ProductTJ",homePageService.findTjProductInfor());
        map.put("DZPrint",tlkSctjService.findAll());
        map.put("FWZInfor",fwzMessService.findAll());
        map.put("ZhouBianJingQu",tlkZbjqEntityService.findAll());
        map.put("HeZuoHuoBan",homePageService.findAllHZHB());
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new SysInforExclusionStrategy()).create().toJson(map));
    }

    /**
     * 得到轮播图片
     * @param response
     */
    @RequestMapping("lbtp")
    public void lbtp(HttpServletRequest request, HttpServletResponse response){
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new SysInforExclusionStrategy()).create().toJson(homePageService.findAllLbgl()));
    }


    /**
     * 通过服务站 ID 获取服务站相关信息
     * @param response
     * @param id
     */
    @RequestMapping("fwzMess")
    public void TlkFwzMess (HttpServletResponse response ,@RequestParam(name = "id") String id){

        TlkFwzEntity tlkFwz = fwzMessService.findFwzMessageById(id) ;

        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(tlkFwz));
        System.out.println(gson.toJson(tlkFwz));
    }
    /**
     * 通过周边景区 id 获取景区相关信息
     * @param response
     * @param id
     */
    @RequestMapping("ZbjqInfo")
    public void ZbjqInfo(HttpServletResponse response ,@RequestParam(name = "id") String id){
        TlkZbjqEntity tlkZbjqEntity=tlkZbjqEntityService.getZbjqInfobyid(id);
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(tlkZbjqEntity));
        System.out.println(gson.toJson(tlkZbjqEntity));
    }

    /**
     * 得到所有摄影师的信息
     * @param response
     */
    @RequestMapping("GetAllSys")
    public void GetAllSys(HttpServletResponse response){
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new SysInforExclusionStrategy()).create().toJson(homePageService.findAllSysInforBySysBh()));
    }

}
