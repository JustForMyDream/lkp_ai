package com.lkp.controller;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.*;
import com.lkp.entity.*;
import com.lkp.service.*;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("sysPort")
public class PhotoGrapherController {
    @Autowired
    TLkPhotograoherService tLkPhotograoherService;

    @Autowired
    UserService userService;

    @Autowired
    XXJLService xxjlService;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    YingjiService yingjiService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductshowService productshowService;

    MediaUtil mediaUtil = new MediaUtil();
    final String domai = "http://www.91lkp.com";
    public final String context = "/Z22629";
    public final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps" + context;
    public final String imgpre = "/uploads/item/2016/";
    public final String filepath = imgpath + imgpre;

    @RequestMapping("zuopin")
    public String uploadpicture(HttpServletRequest request, Model model) {
        // HttpSession session = request.getSession(false);
        String appid = weChatCfg.getAppId();
        int timestamp = (int) (new Date().getTime() / 1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai + request.getRequestURI();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(), nonceStr, String.valueOf(timestamp), url);
        model.addAttribute("appId", appid);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("nonceStr", nonceStr);
        model.addAttribute("signature", sign.toUpperCase());
    //    model.addAttribute("id", id);
//        if(session!=null){
//            TlkUserEntity userEntity = userController.getUserBySession(session);
//            if(userEntity!=null)
//                model.addAttribute("id",id);
//            return "/photographer/OrderPicture.jsp";
//        }
//        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+id+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        return "/photographer/NewWorks";
    }

    @RequestMapping("changezuopinlink")
    public String changpicture(@RequestParam("id")String id, HttpServletRequest request,Model model){
        String appid = weChatCfg.getAppId();
        int timestamp = (int) (new Date().getTime() / 1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai + request.getRequestURI();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(), nonceStr, String.valueOf(timestamp), url);
        model.addAttribute("appId", appid);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("nonceStr", nonceStr);
        model.addAttribute("signature", sign.toUpperCase());
        model.addAttribute("id", id);
        return "/photographer/changeworks";
    }

    @RequestMapping("zuopinPlayLink")
    public String newYingji(@RequestParam(name = "id")String id, HttpServletRequest request, Model model){
        String appid = weChatCfg.getAppId();
       TlkProductshowEntity tlkProductshowEntity =tLkPhotograoherService.getProductshowByZuopingid(id);
        String directUrl="/share/zuopinplay";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        model.addAttribute("title",tlkProductshowEntity.getItemTitle());
        model.addAttribute("id",id);
        if(tlkProductshowEntity.getItemZpfm()!=null&&!tlkProductshowEntity.getItemZpfm().equals("")){
            model.addAttribute("imgurl",tlkProductshowEntity.getItemZpfm());
        }else {
            model.addAttribute("imgurl", tlkProductshowEntity.getTlkProductshowpicEntities().iterator().next().getItemPicurl());
        }
        if(tlkProductshowEntity.getItemZpms()!=null){
            model.addAttribute("des",tlkProductshowEntity.getItemZpms());
        }
       else {
            model.addAttribute("des","");
        }
        return directUrl;
    }

    @RequestMapping("orderlist")
    public void sysOrderList(HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                String itemBh = tlkPhotographerEntity.getItemBh();
                map.put("unfinished", tLkPhotograoherService.getUnfinishOrder(itemBh));
                map.put("finished", tLkPhotograoherService.getfinishOrder(itemBh));
                map.put("canceled", tLkPhotograoherService.getCanceledOrder(itemBh));
//                map.put("orderlist",tLkPhotograoherService.getPhotographerOrderListByBh(itemBh));
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategyWithoutProductshow())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    TlkPhotographerEntity getUserBySession(HttpSession session) {
        TlkPhotographerEntity tlkPhotographerEntity = null;
        if (session.getAttribute(Constant.SYSENTITY) != null) {
            tlkPhotographerEntity = (TlkPhotographerEntity) session.getAttribute(Constant.SYSENTITY);
        }
        return tlkPhotographerEntity;
    }

    @RequestMapping("getAllMsg")
    public void sysMessage(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                String itemBh = userService.getUserByOpenid(tlkPhotographerEntity.getItemOpenid().getOpenid()).getItemBh();
                List list = xxjlService.getUnreadMsg(itemBh);
                map.put("msg", list);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategyWithoutProductshow())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 得到摄影师的总订单数量和未处理订单数量
     *
     * @param request
     * @param response
     */
    @RequestMapping("getOrderCount")
    public void getOrderCount(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                map.put("queren", tLkPhotograoherService.getOrderCountByStateSysId(OrderState.WAITE_TO_CONFIRM, tlkPhotographerEntity.getItemBh()));
                map.put("wancheng", tLkPhotograoherService.getOrderCountByStateSysId(OrderState.FINISHED, tlkPhotographerEntity.getItemBh()));
                map.put("jiaofu", tLkPhotograoherService.getOrderCountByStateSysId(OrderState.WAITE_TO_UPLOADIMG, tlkPhotographerEntity.getItemBh()));
                map.put("youji", tLkPhotograoherService.getOrderCountByStateSysId(OrderState.WAITE_TO_MAIL, tlkPhotographerEntity.getItemBh()));
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "without userinfo2");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "without sysinfo1");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    /**
     * 通过ID得到摄影师的信息，查询tlk_photographer
     *
     * @param request
     * @param response
     */
@RequestMapping("GetSysInfoByid")
public void GetSysInfoByid(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")String id) {
    Map<String, Object> map = new HashMap<>();
//            TlkPhotographerEntity tlkPhotographerEntity1 = tLkPhotograoherService.getPhotographerBySysid(tlkPhotographerEntity.getItemOpenid().getOpenid());
            TlkPhotographerEntity tlkPhotographerEntity1 = tLkPhotograoherService.getPhotoGrapherByID(id);

    if(tlkPhotographerEntity1!=null){
        map.put("sysinfo", tlkPhotographerEntity1);
        map.put("errorCode", "200");
        map.put("errorMsg", "success");
    }else{
        map.put("errorCode", "404");
        map.put("errorMsg", "not exist");
    }
    Gson gson = new GsonBuilder()
            .addSerializationExclusionStrategy(new SYSExclusionStrategy())
            .create();
    ResponseUtil.response(response, gson.toJson(map));
}
    /**
     * 通过OPENID得到摄影师的信息，查询tlk_photographer
     *
     * @param request
     * @param response
     */
    @RequestMapping("GetSysInfoByOpenid")
    public void GetSysInfoByOpenid(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                TlkPhotographerEntity tlkPhotographerEntity1 = tLkPhotograoherService.getPhotographerByOpenid(tlkPhotographerEntity.getItemOpenid().getOpenid());
                map.put("sysinfo", tlkPhotographerEntity1);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SYSExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 更新用户信息
     *
     * @param headimg
     * @param nc
     * @param sex
     * @param name
     * @param phone
     * @param grjj     个人介绍
     * @param fmbjtp   摄影师封面图片
     * @param request
     * @param response
     */
    @RequestMapping("UpdateSysInfo")
    public void UpdateSysInfo(@RequestParam(name = "headimg", required = false) String headimg,
                              @RequestParam(name = "nc", required = false) String nc,
                              @RequestParam(name = "sex", required = false) String sex,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "phone", required = false) String phone,
                              @RequestParam(name = "grjj", required = false) String grjj,
                              @RequestParam(name = "fmbjtp", required = false) String fmbjtp,
                              HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                if (headimg != null) {
                    tlkPhotographerEntity.setItemHeadimg(headimg);
                }
                if (nc != null) {
                    tlkPhotographerEntity.setItemNc(nc);
                }
                if (sex != null) {
                    tlkPhotographerEntity.setItemSex(sex);
                }
                if (name != null) {
                    tlkPhotographerEntity.setItemName(name);
                }
                if (phone != null) {
                    tlkPhotographerEntity.setItemPhone(phone);
                }
                if (grjj != null) {
                    tlkPhotographerEntity.setItemGrjj(grjj);
                }
                if (fmbjtp != null) {
                    tlkPhotographerEntity.setFmbjtp(fmbjtp);
                }
                tLkPhotograoherService.UpdateSysInfo(tlkPhotographerEntity);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        ResponseUtil.response(response, new Gson().toJson(map));
    }

    /**
     * 得到摄影师的入账信息
     *
     * @param request
     * @param response
     */
    @RequestMapping("getZhangdan")
    public void getZhangdan(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                map.put("zongshouru", tLkPhotograoherService.getIncome(tlkPhotographerEntity.getItemBh()));//总收入
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategycopy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }





    /**
     * 查询摄影师的转账信息
     * zhye 账户余额
     * zzje 转账总金额
     *
     * @param request
     * @param response
     */
    @RequestMapping("SelectSysZZXX")
    public void SelectSysZZXX(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                map.put("orders", tLkPhotograoherService.getOrderListOnlyOne(tlkPhotographerEntity.getItemBh()));//订单列表
                map.put("ljsr", tLkPhotograoherService.getZhyeBySysid(tlkPhotographerEntity.getItemBh()));//累计收入
                map.put("lszzje", tLkPhotograoherService.getHisZzSum(tlkPhotographerEntity.getItemBh()));//历史转账金额
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategycopy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }


    @RequestMapping("getSysinforBySysid")
    public void getProductInforBySysID(@RequestParam(name = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new GsonBuilder().addSerializationExclusionStrategy(new SysInforExclusionStrategy()).create().toJson(tLkPhotograoherService.findById(id)));
    }

    @RequestMapping("edit_data")
    public String yingjiSet(HttpServletRequest request, Model model) {
        String appid = weChatCfg.getAppId();
        String directUrl = "/photographer/edit_data";
        int timestamp = (int) (new Date().getTime() / 1000);
        String nonceStr = StringUtil.getRandomString(10);
        final String domai = "http://www.91lkp.com";
        String url = domai + request.getRequestURI();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(), nonceStr, String.valueOf(timestamp), url);
        model.addAttribute("appId", appid);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("nonceStr", nonceStr);
        model.addAttribute("signature", sign.toUpperCase());
//        model.addAttribute("title",yj.getItemTitle());
//        model.addAttribute("id",id);
//        model.addAttribute("imgurl",yj.getTlkYingjipicEntities().iterator().next().getItemImgurl());
//        model.addAttribute("des",yj.getItemDes());
        return directUrl;
    }

    @RequestMapping("updateImg")
    public void updateImg(@RequestParam("serverId") String serverId, @RequestParam("itemBh") String itemBh, HttpServletRequest request, HttpServletResponse response) {
        YingjiMediaOperate yingjiMediaOperate = new YingjiMediaOperate(itemBh);
        mediaUtil.getMedia(accessTokenService.getAccessToken(), serverId, yingjiMediaOperate);
        ResponseUtil.response(response, "头像更新成功");
    }

    class YingjiMediaOperate implements MediaOperate {
        String itemBh;

        public YingjiMediaOperate(String itemBh) {
            this.itemBh = itemBh;
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
                SaveHeadimg("[{\"name\":\"摄影师头像\",\"path\":\"" + imgpre + file.getName() + "\"}]", itemBh);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void SaveHeadimg(String headimgUrl, String itemBh) {
            TlkPhotographerEntity tlkPhotographerEntity = tLkPhotograoherService.getPhotographerBySysid(itemBh);
            tlkPhotographerEntity.setItemHeadimg(headimgUrl);
            tLkPhotograoherService.UpdateSysInfo(tlkPhotographerEntity);
        }
    }

    @RequestMapping("getOrderBySysId")
    public void getOrderBySysId(@RequestParam(name = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new GsonBuilder()
                .addSerializationExclusionStrategy(new PhotographerExclusionStrategy())
                .create().toJson(tLkPhotograoherService.getOrderBySysId(id)));
    }


    /**
     * 得到评价数量
     */
     @RequestMapping("getOrderNumBySysId")
    public void getOrderNumBySysId(@RequestParam(name = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.response(response, new GsonBuilder()
                .addSerializationExclusionStrategy(new PhotographerExclusionStrategy())
                .create().toJson(tLkPhotograoherService.getOrderNumBySysId(id)));
    }

    /**
     * 分页查询摄影师接口
     *
     * @param page
     * @param pagesize
     * @param response
     */
    @RequestMapping("GetSysFY")
    public void GetSysFY(@RequestParam(name = "page") int page, @RequestParam(name = "pagesize") int pagesize, HttpServletResponse response) {
        List<TlkPhotographerEntity> tlkPhotographerEntities = tLkPhotograoherService.GetSysFY(page, pagesize);
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new SysInforExclusionStrategy()).create();
        ResponseUtil.response(response, gson.toJson(tlkPhotographerEntities));
    }

    /**
     * 摄影师转账
     *
     * @param id
     * @param response
     */
    @RequestMapping("SysTransform")
    public void SysTransform(@RequestParam(name = "id") String id, HttpServletResponse response) {
        ResponseUtil.response(response, tLkPhotograoherService.SysTransform(orderService.findById(id)));
    }

    /**
     * 摄影师作品新建
     * @param request
     * @param response
     */
    @RequestMapping("savezuopin")
    public void savezuopin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                try {
                    YingjiJson yjson = new Gson().fromJson(request.getReader(), YingjiJson.class);
                    TlkProductshowEntity tlkProductshowEntity = new TlkProductshowEntity();
                    tlkProductshowEntity.setItemTitle(yjson.getTitle());
                    tlkProductshowEntity.setItemSysbh(tlkPhotographerEntity.getId());
                    tlkProductshowEntity.setItemZpms(yjson.getDes());
                    Set<TlkProductshowpicEntity> tlkProductshowpicEntitySet = new HashSet<TlkProductshowpicEntity>();
                    List<Yingjipic> yingjipicList = yjson.getYingjipics();
                    /**
                     * 设置作品封面
                     */
                    if (yjson.getCover() != null) {
                        if (yjson.getCover().getType().equals("user")) {
                            ZuoPinMediaOperate zuoPinMediaOperate = new ZuoPinMediaOperate();
                            mediaUtil.getMedia(accessTokenService.getAccessToken(), yjson.getCover().getTargetId(), zuoPinMediaOperate);
                            tlkProductshowEntity.setItemZpfm("[{\"name\":\"封面图片\",\"path\":\"" + zuoPinMediaOperate.getPicPath() + "\"}]");
                        } else if (yjson.getCover().getType().equals("service") || yjson.getCover().getType().equals("order")) {
                            tlkProductshowEntity.setItemZpfm(yjson.getCover().getTargetId());
                        }
                    }
                    tLkPhotograoherService.createZuopin(tlkProductshowEntity);
                    for (int i = 0; i < yingjipicList.size(); i++) {
                        TlkProductshowpicEntity tlkProductshowpicEntity = new TlkProductshowpicEntity();
                        tlkProductshowpicEntity.setItemOrder(Integer.valueOf(i));
                        tlkProductshowpicEntity.setItemDescript(yingjipicList.get(i).getDes());
                        tlkProductshowpicEntity.setTlkProductshowEntity(tlkProductshowEntity);
                        Yingjipic y = yingjipicList.get(i);
                        ZuoPinMediaOperate zuoPinMediaOperate = new ZuoPinMediaOperate();
                        mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), zuoPinMediaOperate);
                        tlkProductshowpicEntity.setItemPicurl("[{\"name\":\"作品图片\",\"path\":\"" + zuoPinMediaOperate.getPicPath() + "\"}]");
                        tLkPhotograoherService.createProductshowpicEntity(tlkProductshowpicEntity);
                    }
                    String id = tlkPhotographerEntity.getId();
                    map.put("errorCode", "200");
                    map.put("errorMsg", "success");

                    //若作品id为空则视为新建作品
//                    if(yjson.getId()==null){
//                        for (int i = 0; i < yingjipicList.size(); i++) {
//                            TlkProductshowpicEntity tlkProductshowpicEntity = new TlkProductshowpicEntity();
//                            tlkProductshowpicEntity.setItemOrder(Integer.valueOf(i));
//                            tlkProductshowpicEntity.setItemDescript(yingjipicList.get(i).getDes());
//                            Yingjipic y = yingjipicList.get(i);
//                            ZuoPinMediaOperate zuoPinMediaOperate = new ZuoPinMediaOperate();
//                            if ("user".equals(y.getType())) {
//                                zuoPinMediaOperate.setTlkProductshowpicEntity(tlkProductshowpicEntity);
//                                mediaUtil.getMedia(accessTokenService.getAccessToken(), y.getTargetId(), zuoPinMediaOperate);
//                                tlkProductshowpicEntity = zuoPinMediaOperate.getTlkProductshowpicEntity();
//                                tlkProductshowpicEntity.setTlkProductshowEntity(tlkProductshowEntity);
//                                tlkProductshowpicEntitySet.add(tlkProductshowpicEntity);
//                            } else if ("order".equals(y.getType())) {
//                                TlkProductshowpicEntity tl = tLkPhotograoherService.getProductshowpicByPicid(y.getTargetId());
//                                if (tlkOrderproductimgEntity != null) {
//                                    tlkProductshowpicEntity.setItemPicurl(tlkOrderproductimgEntity.getItemImgurl());
//                                    tlkProductshowpicEntity.setTlkProductshowEntity(tlkProductshowEntity);
//                                    tlkProductshowpicEntitySet.add(tlkProductshowpicEntity);
//                                }
//                            }
//                        }
//                        tlkProductshowEntity.setTlkProductshowpicEntities(tlkProductshowpicEntitySet);
//                        String id = (String) tLkPhotograoherService.createZuopin(tlkProductshowEntity);
//                        map.put("errorCode", "200");
//                        map.put("errorMsg", "success");
//                        map.put("id", id);
//                    }
                    //若id不等于空则是修改
//                    else{
//             yingjiService.updataYingji(yjson);
//                        map.put("errorCode", "200");
//                        map.put("errorMsg", "success");
//                        map.put("id", yjson.getId());
//                    }
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

    @RequestMapping("changezuopin")
    public void changezuopin(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        if(session!=null){
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                try{
                    YingjiJson yjson = new Gson().fromJson(request.getReader(), YingjiJson.class);
                    if(yjson.getId()!=null){
                       // TlkProductshowEntity tlkProductshowEntity = productShowEntityDao.findById(yingjiJson.getId());
                        productshowService.updatezuoping(yjson);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");

                    }
                    else {
                        map.put("result","fail");
                        map.put("errorMsg","未取得头文件的ID");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    map.put("errorCode", "500");
                    map.put("errorMsg", "access request fail");
                }
            }else {
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
     * 通过作品编号获得作品编号
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("getzuopincover")
    public void getzuopincover(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        TlkProductshowEntity tlkProductshowEntity = tLkPhotograoherService.getProductshowByZuopingid(id);
        if(tlkProductshowEntity!=null){
            map.put("errorCode", "200");
            map.put("errorMsg", "success");
            map.put("result",tlkProductshowEntity);
        }else {
            map.put("errorCode", "403");
            map.put("errorMsg", "target not exist");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new productshowWithShowPicStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    @RequestMapping("getzuopinpic")
    public void getzuopinpic(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<String, Object>();
        TlkProductshowEntity tlkProductshowEntity = tLkPhotograoherService.getProductshowByZuopingid(id);
        if(session!=null){
            TlkUserEntity tlkUserEntity = getWXUserBySession(session);
            if(tlkUserEntity!=null){
                map.put("user",tlkUserEntity);
                if(tlkProductshowEntity!=null){
                    map.put("errorCode", "200");
                    map.put("errorMsg", "success");
                    map.put("result",tlkProductshowEntity);
                }else {
                    map.put("errorCode","500");
                    map.put("errorMsg","没有取得作品信息");
                }
            }else {
                map.put("errorCode","400");
                map.put("errorMsg","without user information");
            }
        }else {
            map.put("errorCode","400");
            map.put("errorMsg","without user session");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new productshowWithShowPicStrategy()).addSerializationExclusionStrategy(new PhotographerExclusionStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 通过作品编号删除作品
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("deletezuoping")
    public void DeleteZuoping(@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        Map<String,Object> map = new HashMap<>();
        if(session!=null){
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if(tlkPhotographerEntity!=null){
                tLkPhotograoherService.deleteZuopingById(id);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            }else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        }else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new productshowWithShowPicStrategy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 通过id删除摄影师产品
     *
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping("deletesyscp")
    public void DeleteSysCp(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            TlkPhotographerEntity tlkPhotographerEntity = getUserBySession(session);
            if (tlkPhotographerEntity != null) {
                productService.DeleteProductById(id);
                map.put("errorCode", "200");
                map.put("errorMsg", "success");
            } else {
                map.put("errorCode", "400");
                map.put("errorMsg", "没有查到摄影师相关信息");
            }
        } else {
            map.put("errorCode", "400");
            map.put("errorMsg", "没有查到摄影师相关信息");
        }
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new OrderExclusionStrategycopy())
                .create();
        ResponseUtil.response(response, gson.toJson(map));
    }

    /**
     * 通过session获取用户信息
     *
     * @param session
     * @return
     */
    TlkUserEntity getWXUserBySession(HttpSession session) {
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

    class ZuoPinMediaOperate implements MediaOperate {

        String picPath;

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPicPath() {
            return picPath;
        }

        public ZuoPinMediaOperate() {
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
               picPath = imgpre + file.getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    TlkUserEntity getUserBySessionu(HttpSession session) {
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

    @RequestMapping("FindAllSysXJ")
    public void FindAllSysXJ(HttpServletResponse response) {
        ResponseUtil.response(response, new Gson().toJson(tLkPhotograoherService.FindAllSysXJ()));
    }
}
