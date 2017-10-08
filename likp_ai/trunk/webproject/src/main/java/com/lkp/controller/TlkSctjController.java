package com.lkp.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkSctjEntity;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lkp.service.TlkSctjService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("tlksctj")
public class TlkSctjController {
    @Autowired
    TlkSctjService tlkSctjService;
    /*查询输出推荐的内容，通过id
    * */
    @RequestMapping("find")
    public void find(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new Gson().toJson(tlkSctjService.find(id)));
    }

    @RequestMapping("findALl")
    public void findALl( HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new Gson().toJson(tlkSctjService.findAll()));
    }
}
