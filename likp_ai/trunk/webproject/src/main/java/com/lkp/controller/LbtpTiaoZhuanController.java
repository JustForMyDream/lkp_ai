package com.lkp.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class LbtpTiaoZhuanController {
    Gson gson = new Gson();
    final String domai = "http://www.91lkp.com";

    @RequestMapping("ACTIVITY/{id}")
    public String ActivityTiaoZhuan(@PathVariable("id") String id, HttpServletRequest request) {
        if(id != null) {
            System.out.println("id======"+id);
            return "redirect:/ActivityTemplate/info?id=" + id;
        }
        return "redirect:/wechatuser/MainInterface.html";
    }

    @RequestMapping("THEME/{id}")
    public String ThemeTianZhuan(@PathVariable("id") String id, HttpServletRequest request) {
        if(id != null) {
            return "redirect:/wechatuser/mainProductList.html?id=" + id;
        }
        return "redirect:/wechatuser/MainInterface.html";
    }

    @RequestMapping("PRODUCT/{id}")
    public String ProductTiaoZhuan(@PathVariable("id") String id, HttpServletRequest request) {
        if(id != null) {
            return "redirect:/MainPage/ProductInfor?id=" + id;
        }
        return "redirect:/wechatuser/MainInterface.html";
    }

    @RequestMapping("PHOTOGRAPHER/{id}")
    public String PhotographerTiaoZhuan(@PathVariable("id") String id, HttpServletRequest request) {
        if(id != null) {
            return "redirect:/MainPage/SysInfor?id=" + id;
        }
        return "redirect:/wechatuser/MainInterface.html";
    }

}
