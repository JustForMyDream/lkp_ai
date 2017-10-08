package com.lkp.controller;

import com.lkp.entity.TlkPhotographerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 *
 *
 */
@Controller
public class WebController {

    @RequestMapping("list")
    public String list(HttpSession session, HttpServletResponse response){
        TlkPhotographerEntity openid = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if(openid!=null){
            return "/WEB-INF/orderList";
        }else{
            return "redirect:/index.jsp";
        }
    }
    @RequestMapping("order")
    public String order(HttpSession session, HttpServletResponse response, @RequestParam("id")String id, ModelMap modelMap){
        TlkPhotographerEntity openid = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if(openid!=null){
            modelMap.addAttribute("id",id);
            return "/WEB-INF/orderDetail";
        }else{
            return "redirect:/index.jsp";
        }
    }
    @RequestMapping("yingji")
    public String yingji(HttpSession session, HttpServletResponse response, @RequestParam("id")String id, ModelMap modelMap){
        TlkPhotographerEntity openid = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if(openid!=null){
            modelMap.addAttribute("id",id);
            return "/WEB-INF/orderyingji";
        }else{
            return "redirect:/index.jsp";
        }
    }
    @RequestMapping("quite")
    public String quite(HttpSession session, HttpServletResponse response){
        Enumeration en = session.getAttributeNames();
        while (en.hasMoreElements()){
            String key = (String) en.nextElement();
            session.removeAttribute(key);
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("/*")
    public String index(HttpSession session, HttpServletResponse response){
        TlkPhotographerEntity openid = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if(openid!=null){
            return "/WEB-INF/orderList";
        }else{
            return "redirect:/index.jsp";
        }
    }
}
