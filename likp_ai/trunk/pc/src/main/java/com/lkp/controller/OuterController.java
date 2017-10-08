package com.lkp.controller;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.lkp.controller.exclusionStrategys.OrderExclusionStrategyWithoutProductshow;
import com.lkp.entity.*;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("ajax")
public class OuterController {

    @Autowired
    UserScanRecordService userScanRecordService;

    @Autowired
    Qrcode_sqlService qrcode_sqlService;


    @Autowired
    AccessTokenService accesstokenService;

    @Autowired
    TLkPhotograoherService photographerService;

    @Autowired
    UserWxInfoService userWxInfoService;

    @Autowired
    OrderproductService orderproductService;

    @Autowired
    YingjiService yingjiservice;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    SYSUPloadService  sysuPloadService;

    private final String filePath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps/Z22629/uploads/item/2016/";
    //private final String filePath = "F:/2016/";
    private final String webPath = "/uploads/item/2016/";
    private final String imgthumurl = "/uploads/item/2016/thum/";
    private final String imgprimaryurl = "/uploads/item/2016/pri/";

    private final String bakestagepath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps/Z22629";
    Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new OrderExclusionStrategyWithoutProductshow()).addSerializationExclusionStrategy(new ExclusionStrategy() {
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return "orderproductEntities".equals(fieldAttributes.getName())||"tlkWechatpayEntitys".equals(fieldAttributes.getName())||"tlkProductshowEntities".equals(fieldAttributes.getName())||"itemZsyj".equals(fieldAttributes.getName())||"itemUserid".equals(fieldAttributes.getName());
        }

        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }).create();

    //用户获取登录二维码
    @RequestMapping("qrcode")
    public void qrcode(HttpSession session, HttpServletResponse response) {
        System.out.println("data come in");
        TlkPhotographerEntity openid = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        Map<String, Object> map = new HashMap<String, Object>();
        //若用户已登录(返回状态码code = 100)
        if (openid != null) {
            map.put("result", "fail");
            map.put("code", "100");
            map.put("msg", "already_logined");
            map.put("des", "用户已登录");
        }
        //用户还未登录
        else {
            Qrcode_sql qrcode_sql = (Qrcode_sql) session.getAttribute(SessionStore.QRCODE);
            if (qrcode_sql == null || !qrcode_sql.getUseful() || qrcode_sql.getOverDate().compareTo(new Date()) < 1) {
                //返回Qrcode_sql对象
                qrcode_sql = qrcode_sqlService.getQrcode(accesstokenService.getAccessToken());
//                qrcode_sql = qrcode_sqlService.getQrcode("SEIHkGdhiy6xpHh_wWBe8o09K9bXBauC3N7gTNWueHyUB8wNmk4qSjdp_Sn9-JQ1LnMVWTerh01T2n7RULup0VXvZjSJbD-wZeLCjBDrCOBtmBMtI7IWwlNnoux-Vwz6XBLdCGAOSC");
                if (qrcode_sql.getTicket()!= null) {
                    session.setAttribute(SessionStore.QRCODE, qrcode_sql);
                    map.put("result", "success");
                    map.put("code", "200");
                    map.put("qrcode", qrcode_sql.getTicket());
                    map.put("msg", "getQRCode_success");
                    map.put("des", "获取登录二维码成功");
                } else {
                    map.put("result", "fail");
                    map.put("code", "500");
                    map.put("msg", "getQRCode_fail");
                    map.put("des", "获取登录二维码失败");
                }
            } else {
                map.put("result", "success");
                map.put("code", "200");
                map.put("qrcode", qrcode_sql.getTicket());
                map.put("msg", "getQRCode_success");
                map.put("des", "获取登录二维码成功");
            }
        }
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 测试用户
     * 用户登录
     *
     * @param response r
     * @param session  s
     */
    @RequestMapping("setlogin")
    public void setlogin(HttpServletResponse response, HttpSession session) {
        TlkPhotographerEntity tlkPhotographerEntity = photographerService.getPhotographerByOpenid("olp-hvxdut0amfHZpWOGioqKQjxw");
        if(tlkPhotographerEntity!=null){
            session.setAttribute(SessionStore.SYS_USER, tlkPhotographerEntity);
        }
    }
    /**
     * 用户登录
     *
     * @param id       登录秘钥
     * @param ticket   登录验证秘钥
     * @param response r
     * @param session  s
     */
    @RequestMapping("login")
    public void login(@RequestParam("id") String id, @RequestParam("ticket") String ticket, HttpServletResponse response, HttpSession session) {
        System.out.println("login 登录验证---------");
        UserScanRecord userScanRecord = userScanRecordService.getById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (userScanRecord.getItemTicket().equals(ticket) && !userScanRecord.getUsed()) {
            if (userScanRecord.getLastdate().compareTo(new Date()) > 0) {
                TlkPhotographerEntity tlkPhotographerEntity = photographerService.getPhotographerByOpenid(userScanRecord.getItemOpenid());
                if(tlkPhotographerEntity!=null){
                    map.put("result", "success");
                    session.setAttribute(SessionStore.SYS_USER, tlkPhotographerEntity);
                    userScanRecordService.release(id);
                }else{
                    map.put("result", "fail");
                    map.put("msg", "not_correct_user_type");
                    map.put("des", "您还不是摄影师");
                }
            } else {
                /**
                 * 登录信息已过期
                 */
                map.put("result", "fail");
                map.put("msg", "login_out_of_time");
                map.put("des", "登录超时，二维码已过期");
            }

        } else {
            /**
             * 登录信息不符
             */
            map.put("result", "fail");
            map.put("msg", "id_not_match_to_ticket");
            map.put("des", "登录信息不符");
        }
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 获取用户可操作的订单
     *
     * @param session  s
     * @param response r
     */
    @RequestMapping("orderList")
    private void orderList(HttpSession session, HttpServletResponse response) {
       TlkPhotographerEntity photographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        Map<String, Object> map = new HashMap<String, Object>();
        if (photographerEntity != null) {
            map.put("result", "success");
            map.put("data", orderproductService.findOrderProductBySySBH(photographerEntity.getItemBh()));
        } else {
            map.put("result", "fail");
            map.put("msg", "not_photographer");
            map.put("des", "您还不是摄影师");
        }
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 获取订单详情
     */
    @RequestMapping("orderDetail")
    private void orderDetail(HttpSession session, HttpServletResponse response, @RequestParam("id") String id) {
        TlkPhotographerEntity photographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        TlkOrderproductEntity ddxx = orderproductService.findOrderProductById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (photographerEntity != null) {
            if (ddxx.getItemSysid().getItemBh().equals(photographerEntity.getItemBh())) {
                map.put("result", "success");
                map.put("data", ddxx);
            } else {
                map.put("result", "fail");
                map.put("msg", "not_your_order");
                map.put("des", "这不是你的订单");
            }
        } else {
            map.put("result", "fail");
            map.put("msg", "not_photographer");
            map.put("des", "您还不是摄影师");
        }
        ResponseUtil.response(response, gson.toJson(map));
    }

    @RequestMapping("updateFile")
    private void updateFile(HttpServletRequest request, HttpServletResponse response,@RequestParam(name = "type",required = false)String type, @RequestParam("id") String id, @RequestParam("file") CommonsMultipartFile[] multipartFiles, HttpSession session) {
        Map<String, Object> message = new HashMap<String, Object>();
        List<String> successfile = new ArrayList<String>();
        TlkOrderproductEntity ddxx = orderproductService.findOrderProductById(id);
        TlkPhotographerEntity tlkPhotographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        OrderState ddzt = ddxx.getItemState();
        if (tlkPhotographerEntity.getItemBh().equals(ddxx.getItemSysid().getItemBh())) {
            if (ddzt.equals(OrderState.WAITE_TO_UPLOADIMG)) {
                for (MultipartFile multipartFile : multipartFiles) {
                    String fileName = String.valueOf(UUID.randomUUID()) + ".jpg";
                    String fullPath = filePath + fileName;
                    File file = new File(fullPath);
                    try {
                        multipartFile.transferTo(file);
                        String sqlpath = webPath + fileName;
                        successfile.add(sqlpath);
                        TlkOrderproductimgEntity orderproductimgEntity = new TlkOrderproductimgEntity();
                        orderproductimgEntity.setParent(ddxx.getId());
                        if(type!=null&&type.equals("jingxiu")){
                            orderproductimgEntity.setItemTplx("精修");
                        }else{
                            orderproductimgEntity.setItemTplx("原片");
                        }
                        orderproductimgEntity.setItemImgurl("[{\"name\":\"原片\",\"path\":\"" + sqlpath + "\"}]");
                        orderproductService.SaveOrderPic(orderproductimgEntity);
                        message.put("result", "success");
                        message.put("files", successfile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        message.put("result", "fail");
                        message.put("msg", "update_file_error");
                        message.put("des", "上传图片错误");
                    }
                }
            } else {
                message.put("result", "fail");
                message.put("msg", "order_state_error");
                message.put("des", "订单状态错误");
            }
        } else {
            message.put("result", "fail");
            message.put("msg", "user_err");
            message.put("des", "用户和订单不匹配");
        }
        ResponseUtil.response(response, gson.toJson(message));
    }

    @RequestMapping("createYingji")
    public void createYingji(@RequestParam("id") String id,@RequestParam("title") String title,@RequestParam("des") String des,@RequestParam("music") String music,@RequestParam("pic") String[] pic,HttpServletResponse response,HttpSession session){
        Map<String, Object> message = new HashMap<String, Object>();
        List<String> successfile = new ArrayList<String>();
        TlkOrderproductEntity ddxx = orderproductService.findOrderProductById(id);
        TlkPhotographerEntity tlkPhotographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        OrderState ddzt = ddxx.getItemState();
        if (tlkPhotographerEntity.getItemBh().equals(ddxx.getItemSysid().getItemBh())) {
            if (ddzt.equals(OrderState.WAITE_TO_UPLOADIMG)) {
                   String yingjiid = (String) sysuPloadService.uploadYingji(id,title,des,music,pic);
                   if(yingjiid==null){
                       message.put("result", "fail");
                       message.put("msg", "yingji_create_error");
                       message.put("des", "影集创建失败");
                   }else{
                       message.put("result", "success");
                       message.put("msg", "ok");
                       message.put("des", "影集创建成功");
                       message.put("id",yingjiid);
                   }
            }else {
                message.put("result", "fail");
                message.put("msg", "order_state_error");
                message.put("des", "订单状态错误");
            }
        } else {
            message.put("result", "fail");
            message.put("msg", "user_err");
            message.put("des", "用户和订单不匹配");
        }
        ResponseUtil.response(response, gson.toJson(message));
    }
    @RequestMapping("DDCP_copys")
    public void getDDCP_copys(@RequestParam("id") String id, HttpServletResponse response, HttpSession session) {
        TlkOrderproductEntity ddxx = orderproductService.findOrderProductById(id);
        Map<String, Object> message = new HashMap<String, Object>();
        TlkPhotographerEntity tlkPhotographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if (tlkPhotographerEntity.getItemBh().equals(ddxx.getItemSysid().getItemBh())) {
            message.put("result", "success");
            message.put("data", ddxx);
        } else {
            message.put("result", "fail");
            message.put("msg", "user_err");
            message.put("des", "用户和订单不匹配");
        }
        ResponseUtil.response(response, gson.toJson(message));
    }

    @RequestMapping("commit")
    public void commit(@RequestParam("id") String id, HttpServletResponse response, HttpSession session) {
        TlkOrderproductEntity orderproductEntity = orderproductService.findOrderProductById(id);
        List list = orderproductService.findOrderJudge(id);
        Set<TlkOrderproductimgEntity> set = orderproductService.findOrderImg(id);
        Map<String, Object> message = new HashMap<String, Object>();
        TlkPhotographerEntity photographerEntity = (TlkPhotographerEntity) session.getAttribute(SessionStore.SYS_USER);
        if(set.size()<=0) {
               message.put("judgeimg","error");
        }
        else {
            if (list.size() <= 0) {
                    message.put("judge", "error");
            }
            else {
                if (orderproductEntity.getItemSysid().getItemBh().equals(photographerEntity.getItemBh())) {
                    if (orderproductEntity.getItemState().equals(OrderState.WAITE_TO_UPLOADIMG)) {
                        orderproductService.updateOrderSate(id, OrderState.WAITE_TO_MAIL);
                        TlkXxjlEntity xxjlEntity = new TlkXxjlEntity();
                        xxjlEntity.setItemFssj(new Date());
                        xxjlEntity.setItemXxlj("2");
                        xxjlEntity.setItemXxzt("0");
                        xxjlEntity.setItemYhzh(orderproductEntity.getItemOrderid());
                        xxjlEntity.setItemXxnr("摄影师已提交 订单" + orderproductEntity.getItemOrderid() + " 的图片，请进入订单查看--立小拍");
                        message.put("result", "success");
                        message.put("msg", "order_state_update");
                        message.put("des", "订单提交成功");
                    } else {
                        message.put("result", "fail");
                        message.put("msg", "order_state_err");
                        message.put("des", "订单状态错误,不能提交订单");
                    }
                } else {
                    message.put("result", "fail");
                    message.put("msg", "user_err");
                    message.put("des", "用户和订单不匹配");
                }
              }
            }
        ResponseUtil.response(response, gson.toJson(message));
    }

    @RequestMapping("userinfor")
    public void userinfor(@RequestParam("id") String id,HttpServletResponse response,HttpSession session){
        Map<String,Object> UserMessage = new HashMap<String, Object>();
        TlkWechatuserEntity User = orderproductService.findWechatuser(id);
        UserMessage.put("user",User);
        ResponseUtil.response(response,gson.toJson(UserMessage));
    }
}
