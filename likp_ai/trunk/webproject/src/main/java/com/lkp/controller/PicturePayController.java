package com.lkp.controller;

import com.cxt.wechat.media.MediaOperate;
import com.cxt.wechat.media.MediaUtil;
import com.cxt.wechat.util.SignUtil;
import com.cxt.wechat.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lkp.bean.WeChatCfg;
import com.lkp.controller.exclusionStrategys.ProductWithShowPicExclusionStrategy;
import com.lkp.dao.TlkOrderproductimgEntityDao;
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
@RequestMapping("PICTUREPAY")
public class PicturePayController {
    final String domai = "http://www.91lkp.com";
    public final String context = "/Z22629";
    public final String imgpath = "D:/Project/LKP/BackPage/后台管理/WeiOA365_LKP/WeiOA365_V1.06/bin/apache-tomcat-7.0.57/webapps"+context;
    public final String imgpre = "/uploads/item/2016/";
    public final String filepath = imgpath + imgpre;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    PicturePayService picturePayService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserController userController;

    @Autowired
    YingjiService yingjiService;

    Gson gson = new Gson();

    MediaUtil mediaUtil = new MediaUtil();

    @RequestMapping("photographer")
    public String Newset(@RequestParam(name = "id",required = false)String id, @RequestParam(name = "orderid",required = false)String orderid , HttpServletRequest request, Model model, HttpSession session){
        if(userController.getUserBySession(session)==null){
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2f"+request.getServerName()+request.getContextPath()+"%2fuserlogin%2fyingji%2f1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        }
        String appid = weChatCfg.getAppId();
        String directUrl="/photographer/yingjidelivery";
        int timestamp = (int)(new Date().getTime()/1000);
        String nonceStr = StringUtil.getRandomString(10);
        String url = domai+request.getRequestURI();
        if(request.getQueryString()!=null){
            url+="?"+request.getQueryString();
        }
        TlkOrderproductEntity orderproductEntity = yingjiService.getOrderByYingjiId(id);
        TlkOrderproductEntity orderproductEntity1 = orderService.findOrderProductById(orderid);
        String sign = SignUtil.jssdkSign(accessTokenService.getJsticket(),nonceStr, String.valueOf(timestamp),url);
        model.addAttribute("appId",appid);
        model.addAttribute("timestamp",timestamp);
        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",sign.toUpperCase());
        if(id!=null&&!id.equals("")){
            TlkYingjiEntity yj = yingjiService.getYingjiById(id);
            if(orderproductEntity!=null&&!orderproductEntity.getItemOrderid().equals("")){
                model.addAttribute("orderid",orderproductEntity.getId());
            }else{
                if(orderid!=null&&!orderid.equals("")){
                    if(orderproductEntity1!=null&&!orderproductEntity1.getItemOrderid().equals("")) {
                        model.addAttribute("orderid", orderproductEntity1.getId());
                    }
                }
            }
        }else{
            if(orderid!=null&&!orderid.equals("")){
                if(orderproductEntity1!=null&&!orderproductEntity1.getItemOrderid().equals("")) {
                    model.addAttribute("orderid", orderproductEntity1.getId());
                }
            }
        }
        return directUrl;
    }

    @RequestMapping("OrderPicture")
    public String uploadpicture(@RequestParam("id")String id, HttpServletRequest request, Model model){
        // HttpSession session = request.getSession(false);
        String appid = weChatCfg.getAppId();
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
        model.addAttribute("id",id);
//        if(session!=null){
//            TlkUserEntity userEntity = userController.getUserBySession(session);
//            if(userEntity!=null)
//                model.addAttribute("id",id);
//            return "/photographer/OrderPicture.jsp";
//        }
//        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+id+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        return "/photographer/OrderPicture";
    }

    @RequestMapping("OrderTrimPicture")
    public String uploadtrimpicture(@RequestParam("id")String id, HttpServletRequest request, Model model){
        // HttpSession session = request.getSession(false);
        String appid = weChatCfg.getAppId();
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
        model.addAttribute("id",id);
//        if(session!=null){
//            TlkUserEntity userEntity = userController.getUserBySession(session);
//            if(userEntity!=null)
//                model.addAttribute("id",id);
//            return "/photographer/OrderPicture.jsp";
//        }
//        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41ae02856c6d39a6&redirect_uri=http%3a%2f%2fwww.91lkp.com%2flkpai_test%2fuserlogin%2factivityTemple%2f"+id+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        return "/photographer/OrderTrimPicture";
    }

    @RequestMapping("savePicture")
    public void savepicture(@RequestParam("orderId")String orderId, @RequestParam("upLoadPictures")String upLoadPictures, HttpServletResponse response){
        TlkOrderproductimgEntity tlkOrderproductimgEntity = new TlkOrderproductimgEntity();
        List<UPLP> ulps = gson.fromJson(upLoadPictures,new TypeToken<ArrayList<UPLP>>(){}.getType());
        Map<String,Object> message = new HashMap<>();
        for(int i = 0;i < ulps.size();i++){
            PicUploadMediaOperate picUploadMediaOperate = new PicUploadMediaOperate();
            mediaUtil.getMedia(accessTokenService.getAccessToken(),ulps.get(i).getTargetId(),picUploadMediaOperate);
            tlkOrderproductimgEntity.setItemImgurl("[{\"name\":\"111图片\",\"path\":\"" + picUploadMediaOperate.getPicPath() + "\"}]");
            tlkOrderproductimgEntity.setParent(orderId);
            picturePayService.saveOrderproductimgAndOrderId(tlkOrderproductimgEntity);
        }
        message.put("msg","success");
        ResponseUtil.response(response,new Gson().toJson(message));
    }

    @RequestMapping("saveTrimPicture")
    public void savetrimpicture(@RequestParam("orderId")String orderId, @RequestParam("upLoadPictures")String upLoadPictures, HttpServletResponse response){
        TlkOrderproductimgEntity tlkOrderproductimgEntity = new TlkOrderproductimgEntity();
        List<UPLP> ulps = gson.fromJson(upLoadPictures,new TypeToken<ArrayList<UPLP>>(){}.getType());
        Map<String,Object> message = new HashMap<>();
        for(int i = 0;i < ulps.size();i++){
            PicUploadMediaOperate picUploadMediaOperate = new PicUploadMediaOperate();
            mediaUtil.getMedia(accessTokenService.getAccessToken(),ulps.get(i).getTargetId(),picUploadMediaOperate);
            tlkOrderproductimgEntity.setItemImgurl("[{\"name\":\"111图片\",\"path\":\"" + picUploadMediaOperate.getPicPath() + "\"}]");
            tlkOrderproductimgEntity.setParent(orderId);
            tlkOrderproductimgEntity.setItemTplx("精修");
            picturePayService.saveOrderproductimgAndOrderId(tlkOrderproductimgEntity);
        }
        message.put("msg","success");
        ResponseUtil.response(response,new Gson().toJson(message));
    }

    @RequestMapping("getPictures")
    public void getpictures(@RequestParam("orderId")String orderId,HttpServletRequest request,HttpServletResponse response){
        List<TlkOrderproductimgEntity> tlkOrderproductimgEntities = picturePayService.getPicturesByOrderId(orderId);
        Map<String,Object> message = new HashMap<String,Object>();
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ProductWithShowPicExclusionStrategy()).create();
        if(tlkOrderproductimgEntities.size() == 0){
            message.put("result","null");
            message.put("msg","没有图片");
            ResponseUtil.response(response,new Gson().toJson(message));
        }
        else {
            ResponseUtil.response(response,new Gson().toJson(tlkOrderproductimgEntities));
        }
    }

    @RequestMapping("deletePictures")
    public void deletepictures(@RequestParam("pictureId")String pictureId,HttpServletRequest request,HttpServletResponse response){
        TlkOrderproductimgEntity tlkOrderproductimgEntity = new TlkOrderproductimgEntity();
        picturePayService.deletePicturesById(pictureId);
        Map<String,Object> message = new HashMap<>();
        message.put("result","success");
        ResponseUtil.response(response,new Gson().toJson(message));
    }

    @RequestMapping("yingjiUp")
    public void yingjiUp(HttpServletRequest request,HttpServletResponse response){
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
                    if(yjson.getId()==null){
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
                        String idd = (String) yingjiService.cerateYingji(tlkYingjiEntity);

                        TlkOrderproductEntity tlkOrderproductEntity = picturePayService.findOrderIdById(yjson.getOrderid());
                        TlkOrderyingjiEntity tlkOrderyingjiEntity = picturePayService.findOrderByOrderId(tlkOrderproductEntity.getItemOrderid());
                        if(tlkOrderproductEntity!=null){
                            tlkOrderyingjiEntity.setItemYingjiid(tlkYingjiEntity.getItemBh());
                            picturePayService.updateOrderYingByOrderID(tlkOrderyingjiEntity);
                            map.put("result","更新订单");
                            map.put("errorCode", "200");
                            map.put("errorMsg", "success");
                            map.put("id", idd);
                        }
                        else {
                            tlkOrderyingjiEntity = new TlkOrderyingjiEntity();
                            if(tlkOrderproductEntity!=null){
                                tlkOrderyingjiEntity.setItemOrderid(tlkOrderproductEntity.getItemOrderid());
                                tlkOrderyingjiEntity.setItemYingjiid(tlkYingjiEntity.getItemBh());
                                picturePayService.saveYingByOrderId(tlkOrderyingjiEntity);
                                map.put("errorCode", "200");
                                map.put("errorMsg", "success");
                                map.put("id", idd);
                            }
                            else {
                                map.put("result","没有相关订单");
                            }
                        }
                    }
                    //若id不等于空则是修改
                    else{
                        yingjiService.updataYingji(yjson);
                        map.put("errorCode", "200");
                        map.put("errorMsg", "success");
                        map.put("id", yjson.getId());
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
        map.put("success","保存成功");
        ResponseUtil.response(response, new Gson().toJson(map));
    }


    public class PicUploadMediaOperate implements MediaOperate {
        String picPath;

        public PicUploadMediaOperate() {
        }
        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
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
                picPath = imgpre + file.getName() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public class UPLP{
        String src;
        String targetId;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }
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
}

