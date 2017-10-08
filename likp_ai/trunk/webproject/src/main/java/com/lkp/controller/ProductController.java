package com.lkp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.controller.exclusionStrategys.ProductWithoutShowPicExclusionStrategy;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkProductEntity;
import com.lkp.service.ProductService;
import com.lkp.service.UserService;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    PhotoGrapherController photoGrapherController;

    @RequestMapping("create")
    public void create(@RequestParam(name = "id") String id, @RequestParam(name = "price") String price, @RequestParam(name = "state") String state, @RequestParam(name = "fengmian") String fengmian, HttpServletRequest request,
                       HttpServletResponse response) {
        TlkProductEntity productEntity = new TlkProductEntity();
        productEntity.setItemName(id);
        productEntity.setItemPrice(price);
        productEntity.setItemCpzt(state);
        productEntity.setItemCover(fengmian);
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        } else {
            if (photoGrapherController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without sysinfo2");
            }
            //session中有sys信息
            else {
                TlkPhotographerEntity tlkPhotographerEntity = photoGrapherController.getUserBySession(session);
                productEntity.setItemSys(tlkPhotographerEntity.getId());
                productService.save(productEntity);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
//        ResponseUtil.response(response, "success");
    }


    /**
     * 查询是摄影师的产品列表
     *
     * @param request
     * @param response
     */
    @RequestMapping("SelectSysCp")
    public void SelectSysCp(HttpServletRequest request,
                            HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        } else {
            if (photoGrapherController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without sysinfo2");
            } else {
                TlkPhotographerEntity tlkPhotographerEntity = photoGrapherController.getUserBySession(session);
                map.put("allCp", productService.getProductBySys(tlkPhotographerEntity.getId()));
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithoutShowPicExclusionStrategy())
                .create();
        String re = gson.toJson(map);
        ResponseUtil.response(response, re);
        try {
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 通过摄影师编号获得产品信息
     */
    @RequestMapping("ProductsBySysid")
    public void SelectProductsBySysid(@RequestParam(name = "id") String id,HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create().toJson(productService.getZuoyeInforBySysId(id)));
    }

    /*
    * 通过摄影师编号获得已经上线的产品数量
    * */
    @RequestMapping("ProductNum")
    public void ProductNum(HttpServletRequest request,
                            HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        } else {
            if (photoGrapherController.getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without sysinfo2");
            } else {
                TlkPhotographerEntity tlkPhotographerEntity = photoGrapherController.getUserBySession(session);
                map.put("productNum", productService.getProductNum(tlkPhotographerEntity.getId()));
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithoutShowPicExclusionStrategy())
                .create();
        String re = gson.toJson(map);
        ResponseUtil.response(response, re);
        try {
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 通过摄影师id获得产品展示信息
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("ProductShow")
    public void SelectProductShow(@RequestParam(name = "id") String id,HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create().toJson(productService.getShowBySySId(id)));
    }

}

