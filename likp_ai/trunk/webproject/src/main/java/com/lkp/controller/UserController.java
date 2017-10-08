package com.lkp.controller;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.*;
import com.lkp.dao.TlkWechatuserEntityDao;
import com.lkp.entity.*;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("userPort")
public class UserController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    TlkWechatuserEntityDao tlkWechatuserEntityDao;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    YingjiService yingjiService;

    @Autowired
    ProductService productService;

    MediaUtil mediaUtil = new MediaUtil();
    public final String domai = "http://www.91lkp.com";
    public final String port = "8080";
    public final String context = "/Z22629";
    public final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps" + context;
    public final String imgpre = "/uploads/item/2016/";
    public final String temp_img = "/uploads/item/temp_img/";
    public final String filepath = imgpath + imgpre;

    /*--------------------------------------订单相关操作-------------------------------------*/

    /**
     * 用户下单
     *
     * @param productId      产品编号
     * @param orderDate      预约日期
     * @param username       用户姓名
     * @param phone          用户联系电话
     * @param address        用户简要地址
     * @param detailposition 用户详细地址
     * @param request        request
     * @param response       response
     */
    @RequestMapping("palceAnOrder")
    public void createOrder(@RequestParam(name = "productId") String productId,
                            @RequestParam(name = "orderDate") String orderDate,
                            @RequestParam(name = "username") String username,
                            @RequestParam(name = "phone") String phone,
                            @RequestParam(name = "sex") String sex,
                            @RequestParam(name = "address") String address,
                            @RequestParam(name = "detailposition") String detailposition,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo 111");
        } else {
            if (getUserBySession(session) == null) {
                //session中没有用户信息也没有微信信息
                if (getWechatUserBySession(session) == null) {
                    map.put("errorCode", "400");
                    map.put("errorMsg", "without userinfo 222");
                }
                //session中有用户微信信息
                else {
                    //添加用户
                    String userid = (String) userService.addUserByWeChatInfo(getWechatUserBySession(session));
                    TlkUserEntity userEntity = userService.getUserById(userid);
                    userEntity.setItemPhone(phone);
                    userEntity.setItemName(username);
                    createOrderUtil(map, productId, orderDate, username, phone, sex, address, detailposition, userid);
                }
            }
            //session中有用户信息
            else {
                String userid = getUserBySession(session).getId();
                createOrderUtil(map, productId, orderDate, username, phone, sex, address, detailposition, userid);

            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 新手指导
     *
     * @param request  request
     * @param response response
     */
    @RequestMapping("NewGuide")
    public void NewGuide(HttpServletRequest request,
                         HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            //session中没有用户信息也没有微信信息
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                String itemIsguide1 = getUserBySession(session).getItemIsguide();
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("isguide", itemIsguide1);
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 更新为已经完成新手指导
     *
     * @param request  request
     * @param response response
     */
    @RequestMapping("UpdateGuide")
    public void UpdateGuide(HttpServletRequest request,
                            HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkUserEntity userEntity = getUserBySession(session);
                String Isguide = userEntity.getItemIsguide();
                if (Isguide == null || Isguide.equals("0")) {
                    userEntity.setItemIsguide("1");
                    userService.Update(userEntity);
                    map.put("errorCode", "200");
                    map.put("errorMsg", "修改成功");
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    /**
     * 支付订单
     *
     * @param id       订单主键
     * @param response
     * @param request
     */
    @RequestMapping("payOrder")
    public void payOrder(@RequestParam("id") String id, HttpServletResponse response, HttpServletRequest request) {
        String prepay_id = orderService.create_prepay_id_by_id(id, request.getRemoteHost());
        Map<String, Object> map = new HashMap<String, Object>();
        if (prepay_id == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "create pay fail");
        } else {
            map.put("errorCode", "200");
            map.put("errorMsg", "create pay Success");
            String appid = weChatCfg.getAppId();
            String timestamp = String.valueOf((int) (new Date().getTime() / 1000));
            String nonceStr = StringUtil.getRandomString(16);
            String signType = "MD5";
            String packages = "prepay_id=" + prepay_id;
            map.put("appId", appid);
            map.put("timeStamp", timestamp);
            map.put("nonceStr", nonceStr);
            map.put("prepay_id", packages);
            map.put("signType", signType);
            String A = "appId=" + appid + "&nonceStr=" + nonceStr + "&package=" + packages + "&signType=" + signType + "&timeStamp=" + timestamp + "&key=" + weChatCfg.getKey();
            String sign = new WeChatSingUtil().getMD5(A, "utf-8").toUpperCase();
            map.put("paySign", sign);
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //订单跳转
    @RequestMapping("payOrderDirect")
    public String payOrderDirect(@RequestParam("id") String id, HttpServletResponse response, HttpServletRequest request, Model model) {
        TlkOrderproductEntity tlkOrderproductEntity = orderService.findOrderProductById(id);
        if (!tlkOrderproductEntity.getItemState().getState().equals(OrderState.WAITE_TO_PAY.getState())) {
            return "redirect:/wechatuser/orderStateShow.html?id=" + id;
        }
        String prepay_id = orderService.create_prepay_id_by_id(id, request.getRemoteHost());
        if (prepay_id == null) {
            return "redirect:/wechatuser/orderStateShow.html?id=" + id;
        } else {
            String directUrl = "/wechatuser/PayTest";
            String appid = weChatCfg.getAppId();
            String timestamp = String.valueOf((int) (new Date().getTime() / 1000));
            String nonceStr = StringUtil.getRandomString(16);
            String signType = "MD5";
            String packages = "prepay_id=" + prepay_id;
            String A = "appId=" + appid + "&nonceStr=" + nonceStr + "&package=" + packages + "&signType=" + signType + "&timeStamp=" + timestamp + "&key=" + weChatCfg.getKey();
            String sign = new WeChatSingUtil().getMD5(A, "utf-8").toUpperCase();
            model.addAttribute("appId", appid);
            model.addAttribute("timeStamp", timestamp);
            model.addAttribute("nonceStr", nonceStr);
            model.addAttribute("prepay_id", packages);
            model.addAttribute("signType", signType);
            model.addAttribute("paySign", sign);
            if (id != null && !id.equals("")) {
                model.addAttribute("id", id);
            }
            return directUrl;
        }
    }

    /**
     * 订单列表信息查询
     *
     * @param response
     * @param request
     */
    @RequestMapping("orderlist")
    public void getOderList(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
            //session中有用户信息
            else {
                String userid = getUserBySession(session).getItemBh();
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("orderlist", orderService.getOrdersByUserBH(userid));
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategyWithoutProductshow())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 获取按状态分类的订单
     *
     * @param response
     * @param request  return{
     *                 unfinished:正在进行
     *                 finished：已完成
     *                 canceled：已取消
     *                 }
     */
    @RequestMapping("orderGroupByState")
    public void getOrderListGroupByState(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                String userid = getUserBySession(session).getItemBh();
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("unfinished", orderService.getUnfinishOrder(userid));
                map.put("finished", orderService.getfinishOrder(userid));
                map.put("canceled", orderService.getCanceledOrder(userid));
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * @param productId 订单ID
     * @param orderDate 订单更新时间
     * @param request
     * @param response
     */
    @RequestMapping("Orderdate")
    public void setOrderdate(@RequestParam(name = "productId") String productId,
                             @RequestParam(name = "orderDate") String orderDate,
                             HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                /*System.out.println("...1111."+productId);*/
                OrderState state = orderService.findOrderProductById(productId).getItemState();
               /* System.out.println("........"+state);*/
                if (state.equals(OrderState.WAITE_TO_PAY)) {
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(orderDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (orderService.updateOrderDate(productId, date)) {
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                    } else {
                        map.put("errorCode", "400");
                        map.put("errorMsg", "fail");
                    }


                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * @param productId 订单ID
     * @param position  订单更新大概地点
     * @param request
     * @param response
     */
    @RequestMapping("Position")
    public void setPosition(@RequestParam(name = "productId") String productId,
                            @RequestParam(name = "position") String position,
                            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkOrderproductEntity orderProduct = orderService.findOrderProductById(productId);
                if (orderProduct != null) {
                    if (orderService.updateOrderPosition(productId, position)) {
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                    } else {
                        map.put("errorCode", "400");
                        map.put("errorMsg", "fail");
                    }
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * @param productId      订单ID
     * @param detailposition 订单更新详细地点
     * @param request
     * @param response
     */
    @RequestMapping("Detailposition")
    public void setDetailposition(@RequestParam(name = "productId") String productId,
                                  @RequestParam(name = "detailposition") String detailposition,
                                  HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        //没有用户会话
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkOrderproductEntity orderProduct = orderService.findOrderProductById(productId);
                if (orderProduct != null) {
                    if (orderService.updateOrderDetailPosition(productId, detailposition)) {
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                    } else {
                        map.put("errorCode", "400");
                        map.put("errorMsg", "fail");
                    }
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 获取订单id详细信息
     *
     * @param id
     */
    @RequestMapping("getOrderInfoById")
    public void getOrderdetail(@RequestParam("id") String id, HttpServletResponse response) {
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategyWithoutProductshow())
                .create();
        System.out.println(gson.toJson("--------------------------------" + orderService.findOrderProductById(id)));
        ResponseUtil.response(response, gson.toJson(orderService.findOrderProductById(id)));
    }

    /**
     * 取消订单
     *
     * @param id       订单编号
     * @param response
     * @param request
     */
    @RequestMapping("cancelOrder")
    public void cancelOrder(@RequestParam("id") String id, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                if (userEntity.getItemBh().equals(orderService.findOrderProductById(id).getItemUserid().getItemBh())) {
                    try {
                        orderService.updateOrderSate(id, OrderState.CANCELED);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                    } catch (Exception e) {
                        map.put("errorCode", "500");
                        map.put("errorMsg", "fail");
                    }
                } else {
                    map.put("errorCode", "405");
                    map.put("errorMsg", "user not match to order");
                }
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 确认收片
     *
     * @param id       订单编号
     * @param response
     * @param request
     */
    @RequestMapping("orderQueRen")
    public void orderQueRen(@RequestParam("id") String id, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                if (userEntity.getItemBh().equals(orderService.findOrderProductById(id).getItemUserid().getItemBh())) {
                    try {
                        orderService.updateOrderSate(id, OrderState.FINISHED);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                    } catch (Exception e) {
                        map.put("errorCode", "500");
                        map.put("errorMsg", "fail");
                    }
                } else {
                    map.put("errorCode", "405");
                    map.put("errorMsg", "user not match to order");
                }
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    /*------------------------------------------------影集相关接口-------------------------------------*/

    /**
     * 通过影集号获取影集信息
     *
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping("yingji/getYingji")
    public void getYingjiById(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id) {

    }

    /**
     * 创建影集
     *
     * @param request
     * @param response
     */
    @RequestMapping("yingji/createYingji")
    public void createYingji(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                TlkYingjiEntity yingjiEntity = new TlkYingjiEntity();
                yingjiEntity.setItemUserid(userEntity.getItemBh());
                yingjiEntity.setItemState("false");
                String id = (String) yingjiService.cerateYingji(yingjiEntity);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("id", id);
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 一次性创建影集
     *
     * @param request
     * @param response
     */
    @RequestMapping("yingji/create")
    public void create(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                try {
                    YingjiJson yjson = new Gson().fromJson(request.getReader(), YingjiJson.class);
                    TlkYingjiEntity tlkYingjiEntity = new TlkYingjiEntity();
                    tlkYingjiEntity.setItemUserid(userEntity.getItemBh());
                    tlkYingjiEntity.setItemTitle(yjson.getTitle());
                    tlkYingjiEntity.setItemDes(yjson.getDes());
                    tlkYingjiEntity.setItemMusic(yjson.getMusic());
                    Set<TlkYingjipicEntity> yingjipicEntitySet = new HashSet<TlkYingjipicEntity>();
                    List<Yingjipic> yingjipicList = yjson.getYingjipics();
                    //若影集id为空则视为新建影集
                    if (yjson.getId() == null) {
                        for (int i = 0; i < yingjipicList.size(); i++) {
                            TlkYingjipicEntity tlkYingjipicEntity = new TlkYingjipicEntity();
                            tlkYingjipicEntity.setItemOrder(i);
                            Yingjipic y = yingjipicList.get(i);
                            YingjiMediaOperate yingjiMediaOperate = new YingjiMediaOperate();
                            if ("user".equals(y.getType())) {
                                yingjiMediaOperate.setYingjipicEntity(tlkYingjipicEntity);
                                mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), yingjiMediaOperate);
                                System.out.println(tlkYingjipicEntity == yingjiMediaOperate.getYingjipicEntity());
                                tlkYingjipicEntity = yingjiMediaOperate.getYingjipicEntity();
                                tlkYingjipicEntity.setTlkYingjiEntity(tlkYingjiEntity);
                                yingjipicEntitySet.add(tlkYingjipicEntity);
                            } else if ("order".equals(y.getType())) {
                                TlkOrderproductimgEntity tlkOrderproductimgEntity = orderService.getOrderimgByImgid(y.getTargetId());
                                if (tlkOrderproductimgEntity != null) {
                                    tlkYingjipicEntity.setItemImgurl(tlkOrderproductimgEntity.getItemImgurl());
                                    tlkYingjipicEntity.setTlkYingjiEntity(tlkYingjiEntity);
                                    yingjipicEntitySet.add(tlkYingjipicEntity);
                                }
                            }
                        }
                        tlkYingjiEntity.setTlkYingjipicEntities(yingjipicEntitySet);
                        String id = (String) yingjiService.cerateYingji(tlkYingjiEntity);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                        map.put("id", id);
                    }
                    //若id不等于空则是修改
                    else {
                        TlkYingjiEntity yingjiEntity = yingjiService.getYingjiById(yjson.getId());
                        if(yingjiEntity.getItemUserid().equals(userEntity.getItemBh())){
                            yingjiService.updataYingji(yjson);
                            map.put("errorCode", "200");
                            map.put("errorMsg", "success");
                            map.put("id", yjson.getId());
                        }else{
                            map.put("errorCode", "500");
                            map.put("errorMsg", "wrong user");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    map.put("errorCode", "500");
                    map.put("errorMsg", "access request fail");
                }
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 一次性创建影集(新接口)
     *
     * @param request
     * @param response
     */
    @RequestMapping("yingji/newCreate")
    public void newCreate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                try {
                    YingjiJson yjson = new Gson().fromJson(request.getReader(), YingjiJson.class);
                    /*System.out.println("影集json"+yjson);
                    Log log = LogFactory.getLog("-----接收微信服务器传送数据开始------");
                    log.info("影集json"+yjson);*/
                    //若影集id为空则视为新建影集
                    if (yjson.getId() == null) {
                        TlkYingjiEntity tlkYingjiEntity = new TlkYingjiEntity();
                        tlkYingjiEntity.setItemUserid(userEntity.getItemBh());
                        tlkYingjiEntity.setItemTitle(yjson.getTitle());
                        tlkYingjiEntity.setItemDes(yjson.getDes());
                        tlkYingjiEntity.setItemMusic(yjson.getMusic());
                        Set<TlkYingjipicEntity> yingjipicEntitySet = new HashSet<TlkYingjipicEntity>();
                        List<Yingjipic> yingjipicList = yjson.getYingjipics();
                        /**
                         * 设置影集封面
                         */
                        if (yjson.getCover() != null) {
                            if (yjson.getCover().getType().equals("user")) {
                                YingjiCoverMediaOperate yingjiCoverMediaOperate = new YingjiCoverMediaOperate();
                                mediaUtil.getMedia(accessTokenService.getAccessToken(), yjson.getCover().getTargetId(), yingjiCoverMediaOperate);
                                tlkYingjiEntity.setItemCover("[{\"name\":\"作品图片\",\"path\":\"" + yingjiCoverMediaOperate.getCoverPath() + "\"}]");
                            } else if (yjson.getCover().getType().equals("service") || yjson.getCover().getType().equals("order")) {
                                tlkYingjiEntity.setItemCover(yjson.getCover().getTargetId());
                            }
                        }
                        for (int i = 0; i < yingjipicList.size(); i++) {
                            TlkYingjipicEntity tlkYingjipicEntity = new TlkYingjipicEntity();
                            tlkYingjipicEntity.setItemOrder(i);
                            tlkYingjipicEntity.setItemDescription(yingjipicList.get(i).getDes());
                            Yingjipic y = yingjipicList.get(i);
                            YingjiMediaOperate yingjiMediaOperate = new YingjiMediaOperate();
                            if ("user".equals(y.getType())) {
                                yingjiMediaOperate.setYingjipicEntity(tlkYingjipicEntity);
                                mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), yingjiMediaOperate);
                                tlkYingjipicEntity = yingjiMediaOperate.getYingjipicEntity();
                                tlkYingjipicEntity.setTlkYingjiEntity(tlkYingjiEntity);
                                yingjipicEntitySet.add(tlkYingjipicEntity);
                            } else if ("order".equals(y.getType())) {
                                TlkOrderproductimgEntity tlkOrderproductimgEntity = orderService.getOrderimgByImgid(y.getTargetId());
                                if (tlkOrderproductimgEntity != null) {
                                    tlkYingjipicEntity.setItemImgurl(tlkOrderproductimgEntity.getItemImgurl());
                                    tlkYingjipicEntity.setTlkYingjiEntity(tlkYingjiEntity);
                                    yingjipicEntitySet.add(tlkYingjipicEntity);
                                }
                            }
                        }
                        tlkYingjiEntity.setTlkYingjipicEntities(yingjipicEntitySet);
                        String id = (String) yingjiService.cerateYingji(tlkYingjiEntity);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                        map.put("id", id);
                    }
                    //若id不等于空则是修改
                    else {
                        TlkYingjiEntity yingjiEntity = yingjiService.getYingjiById(yjson.getId());
                        if(yingjiEntity.getItemUserid().equals(userEntity.getItemBh())){
                            yingjiService.updataYingji(yjson);
                            map.put("errorCode", "200");
                            map.put("errorMsg", "success");
                            map.put("id", yjson.getId());
                        }else{
                            map.put("errorCode", "500");
                            map.put("errorMsg", "wrong user");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    map.put("errorCode", "500");
                    map.put("errorMsg", "access request fail");
                }
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 上传影集图片(实现困难 待完善)
     *
     * @param yingjiid 影集编号
     * @param type     图片类型(user（用户手机选择） order(订单图片))
     * @param targetid type为user时为上传至微信的图片servid ,type为order时为图片id
     */
    @RequestMapping("yingji/updatePic")
    public void updatePic(String yingjiid, String type, String targetid, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                TlkYingjiEntity yingjiEntity = yingjiService.getYingjiById(yingjiid);
                if (yingjiEntity != null) {
                    if (yingjiEntity.getItemUserid().equals(userEntity.getItemBh())) {
                        if ("user".equals(type)) {

                        } else if ("order".equals(type)) {

                        } else {
                            map.put("errorCode", "402");
                            map.put("errorMsg", "error img type");
                        }
                    } else {
                        map.put("errorCode", "401");
                        map.put("errorMsg", "user not match");
                    }
                } else {
                    map.put("errorCode", "404");
                    map.put("errorMsg", "target not exist");
                }
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    /**
     * 获取用户的影集列表
     */
    @RequestMapping("yingji/list")
    public void getYingjiList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkUserEntity userEntity = getUserBySession(session);
            if (userEntity != null) {
                map.put("errorCode", "200");
                map.put("yingji", yingjiService.getYingjiListByUserbh(userEntity.getItemBh()));
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        }
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new YingjiExclusionStrategy()).create().toJson(map));
    }

    /**
     * 获取用户微信信息和影集信息
     *
     * @param request
     * @param response
     * @param id       影集编号
     */
    @RequestMapping("yingji/detail")
    public void getYingjiAndUserInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        TlkYingjiEntity yj = yingjiService.getYingjiById(id);
        if (yj != null) {
            map.put("errorCode", "200");
            map.put("errorMsg", "success");
            map.put("yingji", yj);
            map.put("user", userService.getWechatInfoByUserBH(yj.getItemUserid()));
            map.put("sys", yingjiService.getYingjiSysByYingjiId(id));
        } else {
            map.put("errorCode", "403");
            map.put("errorMsg", "target not exist");
        }
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new YingjiExclusionStrategy()).addSerializationExclusionStrategy(new SYSExclusionStrategy()).create().toJson(map));
    }

    /**
     * 通过orderid获得影集
     *
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping("yingji/getYinjiByOrderid")
    public void getYinjiByOrderid(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id) {
        System.out.println(id);
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            //按照字段名排除
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return "tlkProductEntity".equals(fieldAttributes.getName()) ||
                        "tlkProductshowEntity".equals(fieldAttributes.getName()) ||
                        "tlkUserEntity".equals(fieldAttributes.getName()) ||
                        "tlkYingjipicEntities".equals(fieldAttributes.getName()) ||
                        "tlkOrderEntity".equals(fieldAttributes.getName()) ||
                        "itemUserid".equals(fieldAttributes.getName());
            }

            //按照类排除
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).create();

        ResponseUtil.response(response, gson.toJson(yingjiService.getYingjiByItemOrderId(id)));
    }

    /*----------------------------------------------相册相关接口-----------------------------------------*/

    /**
     * 通过订单号获取相关相册信息
     *
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping("album/albumorder")
    public void getAlbumOrder(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") String id) {
        ResponseUtil.response(response, new Gson().toJson(orderService.getImgById(id)));
    }

    @RequestMapping("album/albumList")
    public void getAlbumOrderList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                System.out.println(session.getAttribute(Constant.USERID));
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                String userid = getUserBySession(session).getItemBh();
                System.out.println();
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                map.put("orderlist", orderService.getOrderImgList(userid));
            }
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderAlbumExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }
    /*-------------------------------------------------获取用户信息----------------------------------------*/

    /**
     * 获取当前用户的信息
     *
     * @param request
     * @param response
     */
    @RequestMapping("getUserInfo")
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = userService.getUserById(getUserBySession(session).getId());
                map.put("userinfo", tlkUserEntity);
            }
        }
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            //按照字段名排除
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return "tlkProductEntity".equals(fieldAttributes.getName()) ||
                        "tlkProductshowEntity".equals(fieldAttributes.getName()) ||
                        "tlkUserEntity".equals(fieldAttributes.getName()) ||
                        "tlkOrderEntity".equals(fieldAttributes.getName()) ||
                        "itemUserid".equals(fieldAttributes.getName())||
                        "uwitemUserid".equals(fieldAttributes.getName());
            }

            //按照类排除
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).create();
//        Gson gson = new GsonBuilder()
//                .addSerializationExclusionStrategy(new OrderExclusionStrategy())
//                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 修改用户信息
     * @param username
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping("UpdateUserInfo")
    public void UpdateUserInfo(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "phone", required = false) String phone,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到用户相应信息");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到用户相应信息");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                userService.updateUserInfo(tlkUserEntity.getId(), username, phone);
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    //-----------------------------------------------收藏相关Controler---------------------------
    //通过zpmc和userbh判断是否收藏
    @RequestMapping("Collection/getCollectionByZpUs")
    public void getCollectionByZpUs(@RequestParam("zpmc") String zpmc, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                if (userService.getCollectionByUserbhZpmc(tlkUserEntity.getItemBh(), zpmc) != null) {
                    map.put("shoucang", true);
                    System.out.println("已经收藏");
                } else {
                    System.out.println("没有收藏");
                    map.put("shoucang", false);
                }

            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //得到用户的所有list
    @RequestMapping("Collection/getCollectionList")
    public void getCollectionList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                List<TlkUserCollectionEntity> sclist = userService.getAllCollectionByUserbh(tlkUserEntity.getItemBh());
                List<TlkProductEntity> allCollectList = new ArrayList<TlkProductEntity>();
                for (TlkUserCollectionEntity tlkUserCollectionEntity : sclist) {
                    String prodectId = tlkUserCollectionEntity.getItemZpmc();
                    TlkProductEntity tlkProductEntity = productService.getCollectionProduct(prodectId);
                    allCollectList.add(tlkProductEntity);
                }
                map.put("shoucang", allCollectList);
            }
        }
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new CollectionProductExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    //通过用户编号和zpmc添加收藏
    @RequestMapping("Collection/addCollectionByZpUs")
    public void addCollectionByZpUs(@RequestParam("zpmc") String zpmc, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                String userbh = tlkUserEntity.getItemBh();
                TlkUserCollectionEntity tlkUserCollectionEntity = userService.getCollectionByUserbhZpmc(userbh, zpmc);
                if (tlkUserCollectionEntity == null) {
                    TlkUserCollectionEntity tlkUserCollectionEntity2 = new TlkUserCollectionEntity();
                    tlkUserCollectionEntity.setItemZplx("产品");
                    tlkUserCollectionEntity.setItemName(userbh);
                    tlkUserCollectionEntity.setItemZpmc(zpmc);
                    String cpid = (String) userService.addCollectionByUserbhZpmc(tlkUserCollectionEntity2);
                    System.out.println(cpid);
                    map.put("message", "收藏成功!");
                } else {
                    map.put("message", "收藏失败,已经被收藏!");
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //通过用户编号和zpmc删除收藏
    @RequestMapping("Collection/deleteCollectionByZpUs")
    public void deleteCollectionByZpUs(@RequestParam("zpmc") String zpmc, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                String userbh = tlkUserEntity.getItemBh();
                if (userService.deleteCollectionByUserbhZpmc(userbh, zpmc)) {
                    map.put("message", "取消收藏成功!");
                } else {
                    map.put("message", "取消收藏失败!");
                }
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //通过用户编号和zpmc添加或取消收藏
    @RequestMapping("Collection/addOrDeleteCollectionByZpUs")
    public void addOrDeleteCollectionByZpUs(@RequestParam("zpmc") String zpmc, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                String userbh = tlkUserEntity.getItemBh();
                TlkUserCollectionEntity tlkUserCollectionEntity = userService.getCollectionByUserbhZpmc(userbh, zpmc);
                System.out.println(tlkUserCollectionEntity);
                if (tlkUserCollectionEntity == null) {
                    TlkUserCollectionEntity tlkUserCollectionEntity2 = new TlkUserCollectionEntity();
                    tlkUserCollectionEntity2.setItemZplx("产品");
                    tlkUserCollectionEntity2.setItemName(userbh);
                    tlkUserCollectionEntity2.setItemZpmc(zpmc);
                    String cpid = (String) userService.addCollectionByUserbhZpmc(tlkUserCollectionEntity2);
                    System.out.println(cpid);
                    map.put("message", "收藏成功!");
                    map.put("shoucang", true);
                } else {
                    userService.deleteCollectionByUserbhZpmc(userbh, zpmc);
                    map.put("message", "取消收藏!");
                    map.put("shoucang", false);
                }
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //通过用户编号取消所有收藏
    @RequestMapping("Collection/deleteAllCollectionByUserbh")
    public void deleteAllCollectionByUserbh(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session == null) {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo1");
        } else {
            if (getUserBySession(session) == null) {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
            //session中有用户信息
            else {
                TlkUserEntity tlkUserEntity = getUserBySession(session);
                String userbh = tlkUserEntity.getItemBh();
                userService.deleteAllCollectionByUserbh(userbh);
                map.put("errorCode", "200");
                map.put("errorMsg", "成功清空收藏！");
            }
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    //用户删除所创建的影集
    @RequestMapping("Yingji/delete")
    public void deleteYingjiByUserid(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        TlkUserEntity tlkUserEntity = getUserBySession(session);
        Map<String, Object> map = new HashMap<String, Object>();
        if (tlkUserEntity != null) {
            String userid = tlkUserEntity.getItemBh();
            TlkOrderproductEntity tlkOrderproductEntity = orderService.findOrderProductById(id);
            TlkYingjiEntity tlkYingjiEntity = yingjiService.getYingjiById(id);
            if (tlkYingjiEntity != null) {
                yingjiService.deleteYingjiByUserId(userid, id);
                if (tlkOrderproductEntity != null) {
                    yingjiService.deleteOrderYingjiByUserId(tlkOrderproductEntity.getId());
                }
            }
            map.put("errorCode", "200");
            map.put("errorMsg", "删除影集成功！");
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without userinfo2");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /*-------------------------------------------------工具方法----------------------------------------*/

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
        } else if (session.getAttribute(Constant.SYSENTITY) != null) {
            tlkUserEntity = userService.getUserByOpenid(((TlkPhotographerEntity) session.getAttribute(Constant.SYSENTITY)).getItemOpenid().getOpenid());
        }
        return tlkUserEntity;
    }

    /**
     * 通过session获取用户微信信息
     *
     * @param session
     * @return
     */
    TlkWechatuserEntity getWechatUserBySession(HttpSession session) {
        TlkWechatuserEntity tlkWechatuserEntity = null;
        if (session.getAttribute(Constant.OPENID) != null) {
            tlkWechatuserEntity = userService.getWechatInfoByOpenid((String) session.getAttribute(Constant.OPENID));
        } else if (session.getAttribute(Constant.WECHAT) != null) {
            tlkWechatuserEntity = (TlkWechatuserEntity) session.getAttribute(Constant.WECHAT);
        } else if (getUserBySession(session) != null) {
            tlkWechatuserEntity = userService.getWechatInfoByUserBH(getUserBySession(session).getItemBh());
        }
        return tlkWechatuserEntity;
    }

    /**
     * 创建订单
     *
     * @param map
     * @param productId
     * @param orderDate
     * @param username
     * @param phone
     * @param sex
     * @param address
     * @param detailposition
     * @param userid
     */
    void createOrderUtil(Map<String, Object> map,
                         String productId,
                         String orderDate,
                         String username,
                         String phone,
                         String sex,
                         String address,
                         String detailposition,
                         String userid) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(orderDate);
            String orderid = (String) orderService.creatOrder(userid, productId, date, username, phone, sex, address, detailposition);
            map.put("errorCode", "200");
            map.put("errorMsg", "create order success");
            map.put("id", orderid);
        } catch (ParseException e) {
            e.printStackTrace();
            map.put("errorCode", "500");
            map.put("errorMsg", "illegal date format");
        }
    }

    class YingjiMediaOperate implements MediaOperate {
        TlkYingjipicEntity yingjipicEntity;

        public YingjiMediaOperate() {
        }

        @Override
        public void InputstreamOperate(InputStream inputStream) {
            File file = new File(filepath + UUID.randomUUID() + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
                yingjipicEntity.setItemImgurl("[{\"name\":\"作品图片\",\"path\":\"" + imgpre + file.getName() + "\"}]");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public TlkYingjipicEntity getYingjipicEntity() {
            return yingjipicEntity;
        }

        public void setYingjipicEntity(TlkYingjipicEntity yingjipicEntity) {
            this.yingjipicEntity = yingjipicEntity;
        }
    }

    class YingjiCoverMediaOperate implements MediaOperate {
        String coverPath;

        public YingjiCoverMediaOperate() {
        }

        @Override
        public void InputstreamOperate(InputStream inputStream) {
            File file = new File(filepath + UUID.randomUUID() + ".jpg");
            try {
                OutputStream outputStream = new FileOutputStream(file);
                byte[] data = new byte[1048576];
                boolean index = false;

                int index1;
                while ((index1 = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, index1);
                }
                inputStream.close();
                outputStream.close();
                coverPath = imgpre + file.getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getCoverPath() {
            return coverPath;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }
    }
}
