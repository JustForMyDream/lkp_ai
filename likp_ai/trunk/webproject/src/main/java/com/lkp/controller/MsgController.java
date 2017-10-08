package com.lkp.controller;

import com.google.gson.Gson;
import com.lkp.entity.TlkPhotographerEntity;
import com.lkp.entity.TlkUserEntity;
import com.lkp.entity.TlkWechatuserEntity;
import com.lkp.entity.TlkXxjlEntity;
import com.lkp.service.UserService;
import com.lkp.service.XXJLService;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 消息controller
 */
@Controller
@RequestMapping("msgPort")
public class MsgController {
    @Autowired
    XXJLService xxjlService;

    @Autowired
    UserService userService;

    Gson gson = new Gson();

    //获取用户所有的信息,其中未读的在前面
    @RequestMapping("getAllMsg")
    public void getAllMsg(HttpServletResponse response, HttpSession session){
        TlkUserEntity userEntity = getUserBySession(session);
        Map<String,Object> map = new HashMap<>();
        List list = xxjlService.getUnreadMsg(userEntity.getItemBh());
//        List list = xxjlService.getUnreadMsg(yhbh);
        map.put("msg",list);
        ResponseUtil.response(response,gson.toJson(map));
    }

    //获取未读消息的数量
    @RequestMapping("getWeiDuMsg")
    public void getWeiDuMsg(HttpServletResponse response, HttpSession session){
        TlkUserEntity userEntity = getUserBySession(session);
         ResponseUtil.response(response,gson.toJson(xxjlService.getWeiDuMsg(userEntity.getItemBh())));
    }



    //查询单条信息详情
    @RequestMapping("getMsgInfo")
    public void getMsgInfo(@RequestParam("id") String id,HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
       TlkXxjlEntity xxjj = xxjlService.getById(id);
        map.put("msginfo",xxjj);
        ResponseUtil.response(response,gson.toJson(map));
    }

    //更新消息状态
    @RequestMapping("updateState")
    public void updateState(@RequestParam("id") String id,HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        TlkXxjlEntity xxjj = xxjlService.getById(id);
        if(xxjj.getItemXxzt().equals("0")){
            xxjj.setItemXxzt("1");
            xxjlService.updateMsgState(xxjj);
        }
        map.put("code",200);
        ResponseUtil.response(response,gson.toJson(map));
    }

    //保存消息
    @RequestMapping("saveMsg")
    public void saveMsg(HttpServletResponse response, HttpSession session,
                        @RequestParam("xxlx") String xxlx,
                        @RequestParam("xxnr") String xxnr,
                        @RequestParam("xxlj") String xxlj
                        ){
        TlkUserEntity userEntity = getUserBySession(session);
        TlkXxjlEntity xxjl = new TlkXxjlEntity();
        xxjl.setItemYhzh(userEntity.getItemBh());
        xxjl.setItemXxlx(xxlx);
        xxjl.setItemXxnr(xxnr);
        xxjl.setItemXxlj(xxlj);
        xxjl.setItemFssj(new Date());
        xxjl.setItemXxzt("未读");

        Map<String,Object> map = new HashMap<>();
        Serializable id = xxjlService.save(xxjl);
        if(id!=null){
            map.put("code",200);
            map.put("msg","保存消息成功");
        }
        else{
            map.put("code",400);
            map.put("msg","保存消息失败");
        }
        ResponseUtil.response(response,gson.toJson(map));
    }



    //删除所有消息
    @RequestMapping("delAllMsg")
    public void delAllMsg(HttpServletResponse response, HttpSession session){
        TlkUserEntity userEntity = getUserBySession(session);
        Map<String,Object> map = new HashMap<>();
        if(userEntity!=null){
            xxjlService.DeleteAllMsg(userEntity.getItemBh());
            map.put("code",200);
            map.put("msg","删除成功");
        }
        else {
            map.put("msg","未取得摄影师编号");
        }
        ResponseUtil.response(response,gson.toJson(map));
    }

    //通过ID删除某一条消息
    @RequestMapping("delMsg")
    public void delMsg(@RequestParam(name = "id",required = false)String id,HttpServletResponse response, HttpSession session){
        TlkUserEntity userEntity = getUserBySession(session);
        Map<String,Object> map = new HashMap<>();
            xxjlService.DeleteMsg(id);
            map.put("code",200);
            map.put("msg","删除成功");
           ResponseUtil.response(response,gson.toJson(map));
    }


    /**
     * 通过session获取用户信息
     *
     * @param session
     * @return
     */
    TlkUserEntity getUserBySession(HttpSession session) {
        TlkUserEntity tlkUserEntity = null;
        if (session.getAttribute(Constant.USER) != null) {
            tlkUserEntity = (TlkUserEntity) session.getAttribute(Constant.USER);
        } else if (session.getAttribute(Constant.USERID) != null) {
            tlkUserEntity = userService.getUserById((String) session.getAttribute(Constant.USERID));
        } else if (session.getAttribute(Constant.OPENID) != null) {
            tlkUserEntity = userService.getUserByOpenid((String) session.getAttribute(Constant.OPENID));
        } else if (session.getAttribute(Constant.WECHAT) != null) {
            tlkUserEntity = userService.getUserByOpenid(((TlkWechatuserEntity) session.getAttribute(Constant.WECHAT)).getOpenid());
        }else if(session.getAttribute(Constant.SYSENTITY)!=null){
            tlkUserEntity=userService.getUserByOpenid(((TlkPhotographerEntity)session.getAttribute(Constant.SYSENTITY)).getItemOpenid().getOpenid());
        }
        return tlkUserEntity;
    }
}
