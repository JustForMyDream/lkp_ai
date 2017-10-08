package com.lkp.service.impl;

import com.cxt.wechat.Template.TemplateMessageBussinessImpl;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateItem;
import com.cxt.wechat.entity.WechatTemplate.WechatTemplateMessage;
import com.cxt.wechat.pay.unifiedorder.Entity.Orderquery;
import com.cxt.wechat.pay.unifiedorder.Entity.UnifiedorderRequestEntity;
import com.cxt.wechat.pay.unifiedorder.business.PayInterface;
import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.HttpUtil;
import com.cxt.wechat.util.StringUtil;
import com.cxt.wechat.util.WechatXmlUtil;
import com.google.gson.Gson;
import com.lkp.bean.WeChatCfg;
import com.lkp.dao.*;
import com.lkp.entity.*;
import com.lkp.service.AccessTokenService;
import com.lkp.service.OrderService;
import com.lkp.service.TLkPhotograoherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * 订单处理业务
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    WechatpayResultDao wechatpayResultDao;

    @Autowired
    WechatpayDao wechatpayDao;

    @Autowired
    TlkOrderproductimgEntityDao tlkOrderproductimgEntityDao;

    @Autowired
    OrderYingjiDao orderYingjiDao;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    UserWxbdDao userWxbdDao;

    @Autowired
    TLkPhotograoherService photograoherService ;

    TemplateMessageBussinessImpl templateMessageBussiness = new TemplateMessageBussinessImpl();

    PayInterface pay = new PayInterface()  {
        HttpUtil httpUtil = new HttpUtil();
        Gson gson = new Gson();
        WeChatSingUtil weChatSingUtil = new WeChatSingUtil();
        @Override
        public UnifiedorderRequestEntity unifiedorder(UnifiedorderRequestEntity unifiedorderRequestEntity, String s) {
            String akey = weChatSingUtil.getStringSignTemp(unifiedorderRequestEntity, s);
            unifiedorderRequestEntity.setSign(weChatSingUtil.getMD5(akey, "utf-8"));
            String queryString = (new WechatXmlUtil()).createDefaultXstream().simpleObjestToCDATAXml(unifiedorderRequestEntity);
            UnifiedorderRequestEntity unifiedorderRequestEntity1 = new UnifiedorderRequestEntity();
            try {
                String e = httpUtil.getHttpsPost("https://api.mch.weixin.qq.com/pay/unifiedorder", queryString);
                System.out.println("请求的数据1："+queryString);
                System.out.println("统一下单结果："+e);
                HashMap map = (new WechatXmlUtil()).createDefaultXstream().parseXml(e);
                if(map != null) {
                    unifiedorderRequestEntity1.setResultFromReturnMap(map);
                }
            } catch (Exception var7) {

            }

            return unifiedorderRequestEntity1;
        }

        @Override
        public Orderquery orderQueryBy_Transaction_id(Orderquery orderquery, String s) {
            String akey = weChatSingUtil.getStringSignTemp(orderquery, s);
            orderquery.setSign(weChatSingUtil.getMD5(akey, "utf-8"));
            String queryString = (new WechatXmlUtil()).createDefaultXstream().simpleObjestToCDATAXml(orderquery);
            try {
                String e = httpUtil.getHttpsPost("https://api.mch.weixin.qq.com/pay/orderquery", queryString);
                HashMap map = (new WechatXmlUtil()).createDefaultXstream().parseXml(e);
                String orderQueryStr = this.gson.toJson(map);
                return (Orderquery)this.gson.fromJson(orderQueryStr, Orderquery.class);
            } catch (Exception var7) {
                return null;
            }
        }
    };

    /**
     * 创建订单
     *
     * @param userid         用户编号
     * @param productId      产品编号
     * @param orderDate      预约日期
     * @param username       用户姓名
     * @param phone          预约电话
     * @param sex            用户性别
     * @param address        大概地址
     * @param detailposition 详细地址
     * @return 订单编号
     */
    public Serializable creatOrder(String userid, String productId, Date orderDate, String username, String phone, String sex, String address, String detailposition) {
        TlkUserEntity userEntity = userDao.findById(userid);
        TlkProductEntity productEntity = productDao.getProdctsByCPBH(productId);
        //用户或产品不存在
        if (userEntity == null || productEntity == null) {
            return null;
        }
        TlkOrderproductEntity orderproductntity = new TlkOrderproductEntity();
        //订单创建时间g
        Date create = new Date();
        //生成订单编号
        String orderid = "";
        orderid += new SimpleDateFormat("yyyyMMddHHmmss").format(create) + StringUtil.getRandomString(2);
        //设置订单信息
        orderproductntity.setItemOrderid(orderid);
        orderproductntity.setItemName(username);
        orderproductntity.setItemSex(sex);
        orderproductntity.setItemProductid(productEntity);
        orderproductntity.setItemUserid(userEntity);
        orderproductntity.setItemPhone(phone);
        orderproductntity.setItemPosition(address);
        orderproductntity.setItemDetailposition(detailposition);
        orderproductntity.setItemOrdertime(orderDate);
        orderproductntity.setItemXdrq(create);
        orderproductntity.setItemPrice(productEntity.getItemPrice());
        orderproductntity.setItemProductnum("1");

        if (productEntity.getItemPrice() != null && !productEntity.getItemPrice().equals("0")) {
            orderproductntity.setItemState(OrderState.WAITE_TO_PAY);
            if(productEntity.getItemSys() != null&&!productEntity.getItemSys().trim().equals("")){
                orderproductntity.setItemSysid(photograoherService.findById(productEntity.getItemSys()));
                orderproductntity.setItemSysxm(photograoherService.findById(productEntity.getItemSys()).getItemName());
            }
        } else if (Integer.parseInt(productEntity.getItemPrice()) == 0) {
            orderproductntity.setItemState(OrderState.PAYED_WAITE_SET_PHOTOGRAPHER);
            if(productEntity.getItemSys() != null&&!productEntity.getItemSys().trim().equals("")){
                orderproductntity.setItemSysid(photograoherService.findById(productEntity.getItemSys()));
                orderproductntity.setItemSysxm(photograoherService.findById(productEntity.getItemSys()).getItemName());
            }
        }
        Serializable id = orderDao.save(orderproductntity);
        return id;
    }

    public String create_prepay_id_by_id(String id, String ip) {
        TlkOrderproductEntity orderproductEntity = orderDao.findById(id);
        System.out.println("=================" + orderproductEntity);
        String prepay_id = null;
        //初始化支付单号
        TlkWechatpayEntity wechatpayEntity = new TlkWechatpayEntity();
        UnifiedorderRequestEntity unifiedorderRequestEntity = new UnifiedorderRequestEntity();
        unifiedorderRequestEntity.setAppid(weChatCfg.getAppId());
        wechatpayEntity.setAppid(unifiedorderRequestEntity.getAppid());
        unifiedorderRequestEntity.setMch_id(weChatCfg.getMic_id());
        wechatpayEntity.setMch_id(unifiedorderRequestEntity.getMch_id());
        unifiedorderRequestEntity.setDevice_info("WEB");
        wechatpayEntity.setDevice_info(unifiedorderRequestEntity.getDevice_info());
        unifiedorderRequestEntity.setNonce_str(StringUtil.getRandomString(16));
        wechatpayEntity.setNonce_str(unifiedorderRequestEntity.getNonce_str());
        unifiedorderRequestEntity.setBody(orderproductEntity.getItemProductid().getItemName());
        wechatpayEntity.setBody(unifiedorderRequestEntity.getBody());
        unifiedorderRequestEntity.setAttach(orderproductEntity.getItemOrderid());
        wechatpayEntity.setAttach(unifiedorderRequestEntity.getAttach());
        //设置商户订单号
        unifiedorderRequestEntity.setOut_trade_no(orderproductEntity.getItemOrderid() + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        wechatpayEntity.setOut_trade_no(unifiedorderRequestEntity.getOut_trade_no());
        double unitPrice = Double.parseDouble(orderproductEntity.getItemPrice());
        double totalprice = unitPrice * (Double.parseDouble(orderproductEntity.getItemProductnum())) * 100;
        int fee = (int) totalprice;
        unifiedorderRequestEntity.setTotal_fee(String.valueOf(fee));
        wechatpayEntity.setTotal_fee(unifiedorderRequestEntity.getTotal_fee());
        unifiedorderRequestEntity.setSpbill_create_ip(ip);
        wechatpayEntity.setSpbill_create_ip(unifiedorderRequestEntity.getSpbill_create_ip());
        unifiedorderRequestEntity.setNotify_url("http://www.91lkp.com/lkpai_test/payResult/orderpay");
        wechatpayEntity.setNotify_url(unifiedorderRequestEntity.getNotify_url());
        unifiedorderRequestEntity.setTrade_type("JSAPI");
        wechatpayEntity.setTrade_type(unifiedorderRequestEntity.getTrade_type());
        String openid = null;
        Iterator<TlkUserwechatinfoEntity> i = orderproductEntity.getItemUserid().getWechatInfo().iterator();
        if (i.hasNext()) {
            TlkUserwechatinfoEntity tlkUserwechatinfoEntity = i.next();
            openid = tlkUserwechatinfoEntity.getTlkWechatuserEntity().getOpenid();
        }
        if (openid != null) {
            unifiedorderRequestEntity.setOpenid(openid);
            wechatpayEntity.setOpenid(unifiedorderRequestEntity.getOpenid());
            //统一下单
            UnifiedorderRequestEntity unifiedorderRequestEntity1 = null;
            unifiedorderRequestEntity1 = pay.unifiedorder(unifiedorderRequestEntity, weChatCfg.getKey());
            if ("SUCCESS".equals(unifiedorderRequestEntity1.getReturn_code()) && "SUCCESS".equals(unifiedorderRequestEntity1.getResult_code())) {
                wechatpayEntity.setItemResultCode(unifiedorderRequestEntity1.getResult_code());
                prepay_id = unifiedorderRequestEntity1.getPrepay_id();
                wechatpayEntity.setPrepay_id(prepay_id);
            }
            wechatpayEntity.setItemErrCode(unifiedorderRequestEntity1.getErr_code());
            wechatpayEntity.setItemErrCodeDes(unifiedorderRequestEntity1.getErr_code_des());
            wechatpayEntity.setReturn_code(unifiedorderRequestEntity1.getReturn_code());
            wechatpayEntity.setReturn_msg(unifiedorderRequestEntity1.getReturn_msg());
            wechatpayDao.save(wechatpayEntity);
        }
        return prepay_id;
    }

    public String create_prepay_id_by_orderId(String orderid) {
        return null;
    }

    @Override
    public TlkOrderproductEntity findOrderProductById(String id) {
        return orderDao.findOrderProductById(id);
    }

    @Override
    public TlkOrderproductEntity findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public boolean updateOrderPayState(String out_trade_no, String transaction_id) {
        boolean handleResult = false;
        if (out_trade_no != null || transaction_id != null) {
            Orderquery orderquery = new Orderquery();
            TlkWechatpayresultEntity wechatpayresultEntity = new TlkWechatpayresultEntity();
            orderquery.setAppid(weChatCfg.getAppId());
            wechatpayresultEntity.setItemAppid(orderquery.getAppid());
            orderquery.setMch_id(weChatCfg.getMic_id());
            wechatpayresultEntity.setItemMchId(orderquery.getMch_id());
            orderquery.setNonce_str(StringUtil.getRandomString(16));
            wechatpayresultEntity.setItemNonceStr(orderquery.getNonce_str());
            if (out_trade_no != null) {
                orderquery.setOut_trade_no(out_trade_no);
                wechatpayresultEntity.setItemOutTradeNo(orderquery.getOut_trade_no());
            } else {
                orderquery.setTransaction_id(transaction_id);
                wechatpayresultEntity.setItemTransactionId(orderquery.getTransaction_id());
            }
            Orderquery orderquery1 = pay.orderQueryBy_Transaction_id(orderquery, weChatCfg.getKey());
            wechatpayresultEntity.setItemReturnCode(orderquery1.getReturn_code());
            wechatpayresultEntity.setItemReturnMsg(orderquery1.getReturn_msg());
            wechatpayresultEntity.setItemResultCode(orderquery1.getResult_code());
            wechatpayresultEntity.setItemReturnMsg(orderquery1.getReturn_msg());
            if ("SUCCESS".equals(orderquery1.getReturn_code()) && "SUCCESS".equals(orderquery1.getResult_code())) {
                wechatpayresultEntity.setItemTradeType(orderquery1.getTrade_state());
                wechatpayresultEntity.setItemAttach(orderquery1.getAttach());
                ;
                wechatpayresultEntity.setItemTotalFee(BigDecimal.valueOf(Double.parseDouble(orderquery1.getTotal_fee())));
                wechatpayresultEntity.setItemOpenid(orderquery1.getOpenid());
                wechatpayresultEntity.setItemOutTradeNo(orderquery1.getOut_trade_no());
                try {
                    wechatpayresultEntity.setItemTimeEnd(new SimpleDateFormat("yyyyMMddHHmmss").parse(orderquery1.getTime_end()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                wechatpayresultEntity.setItemDeviceInfo(orderquery1.getDevice_info());
                wechatpayresultEntity.setItemTradeType(orderquery1.getTrade_type());
                try {
                    wechatpayresultEntity.setItemTimeEnd(new SimpleDateFormat("yyyyMMddHHmmss").parse(orderquery1.getTime_end()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //支付成功
                if ("SUCCESS".equals(orderquery1.getTrade_state())) {
                    TlkOrderproductEntity tlkOrderproductEntity = orderDao.findOrderProductByOrderid(orderquery1.getAttach());
                    if (tlkOrderproductEntity.getItemState() == OrderState.WAITE_TO_PAY) {
                        if(tlkOrderproductEntity.getItemSysid() != null)
                        {
                            tlkOrderproductEntity.setItemState(OrderState.WAITE_TO_UPLOADIMG);
                            orderstateChangeTempleMessage(tlkOrderproductEntity, OrderState.WAITE_TO_UPLOADIMG);
                        }
                        else
                        {
                            tlkOrderproductEntity.setItemState(OrderState.PAYED_WAITE_SET_PHOTOGRAPHER);
                            orderstateChangeTempleMessage(tlkOrderproductEntity,OrderState.PAYED_WAITE_SET_PHOTOGRAPHER);
                        }
                    }
                }
                //转入退款
                else if ("REFUND".equals(orderquery1.getTrade_state())) {

                }
                //未支付
                else if ("NOTPAY".equals(orderquery1.getTrade_state())) {

                }
                //已关闭
                else if ("CLOSED".equals(orderquery1.getTrade_state())) {

                }
                //已撤销（刷卡支付）
                else if ("REVOKED".equals(orderquery1.getTrade_state())) {

                }
                //用户支付中
                else if ("USERPAYING".equals(orderquery1.getTrade_state())) {

                }
                //支付失败(其他原因，如银行返回失败)
                else if ("PAYERROR".equals(orderquery1.getTrade_state())) {

                }
                handleResult = true;
            }
            wechatpayResultDao.save(wechatpayresultEntity);
        }
        return handleResult;
    }

    @Override
    public List<TlkOrderproductEntity> getOrdersByUserBH(String userId) {
        return orderDao.getOrdersByUserbh(userId);
    }


    @Override
    public TlkOrderproductimgEntity getOrderimgByImgid(String imgid) {
        TlkOrderproductimgEntity tlkOrderproductimgEntity = tlkOrderproductimgEntityDao.findById(imgid);
        return tlkOrderproductimgEntity;
    }

    @Override
    public List<TlkOrderproductimgEntity> getImgById(String id) {
        return orderDao.getImgById(id);
    }

    @Override
    public List<TlkOrderproductEntity> getOrderImgList(String userid) {
        List<TlkOrderproductEntity> tlkOrderproductEntityList = new ArrayList<TlkOrderproductEntity>();
        List QueryList = orderDao.getOrderImgList(userid);
        for (Object o : QueryList) {
            TlkOrderproductEntity tlkOrderproductEntity = (TlkOrderproductEntity) o;

            if (tlkOrderproductEntity.getItemState() != null) {
                if (tlkOrderproductEntity.getItemState().equals(OrderState.WAITE_TO_CONFIRM) || tlkOrderproductEntity.getItemState().equals(OrderState.FINISHED) || tlkOrderproductEntity.getItemState().equals(OrderState.WAITE_TO_MAIL)) {
                    tlkOrderproductEntityList.add(tlkOrderproductEntity);
                }
            }
        }
        return tlkOrderproductEntityList;
    }

    @Override
    public List<TlkOrderproductEntity> getUnfinishOrder(String userid) {
        return orderDao.getUnfinishOrder(userid);
    }

    @Override
    public List<TlkOrderproductEntity> getfinishOrder(String userid) {
        return orderDao.getfinishOrder(userid);
    }

    @Override
    public List<TlkOrderproductEntity> getCanceledOrder(String userid) {
        return orderDao.getCanceledOrder(userid);
    }

    @Override
    public void updateOrderSate(String id, OrderState ordersate) {
        TlkOrderproductEntity orderproductEntity = orderDao.findOrderProductById(id);
        orderproductEntity.setItemState(ordersate);
    }

    @Override
    public TlkOrderproductimgEntity getOrderproductimgById(Serializable id) {
        return tlkOrderproductimgEntityDao.findById(id);
    }

    @Override
    public Serializable saveOrderYingji(TlkOrderyingjiEntity orderyingjiEntity) {
        return orderYingjiDao.save(orderyingjiEntity);
    }

    /**
     * 订单状态改变发送模板消息
     */
    public void orderstateChangeTempleMessage(TlkOrderproductEntity tlkOrderproductEntity, OrderState orderState) {
        WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
        if (orderState == OrderState.PAYED_WAITE_SET_PHOTOGRAPHER) {
            /**
             * 向客服发送消息通知
             */
            List<TlkPtUserWxbdEntity> userWxbdEntities = userWxbdDao.findAll();
            wechatTemplateMessage.setTemplate_id(MobalMessageInterface.NEW_ORDER_RECOMAIND);
            Map<String, WechatTemplateItem> map = new HashMap<>();
            map.put("first", new WechatTemplateItem("用户订单(" + tlkOrderproductEntity.getItemOrderid() + ")支付成功，请尽快为用户分配摄影师"));
            map.put("keyword1", new WechatTemplateItem(tlkOrderproductEntity.getItemName()));
            map.put("keyword2", new WechatTemplateItem(tlkOrderproductEntity.getItemPhone()));
            map.put("keyword3", new WechatTemplateItem(tlkOrderproductEntity.getItemProductid().getItemName()));
            map.put("keyword4", new WechatTemplateItem(new SimpleDateFormat("yyyy年MM月dd日HH时mm分").format(tlkOrderproductEntity.getItemOrdertime())));
            map.put("keyword5", new WechatTemplateItem("请尽快处理"));
            wechatTemplateMessage.setData(map);
            Iterator<TlkPtUserWxbdEntity> iterator = userWxbdEntities.iterator();
            if (iterator.hasNext()) {
                wechatTemplateMessage.setTouser(iterator.next().getItemOpenid());
                templateMessageBussiness.send(wechatTemplateMessage, accessTokenService.getAccessToken());
            }
            /**
             * 向用户发送订单通知
             */
            Set<TlkUserwechatinfoEntity> set = tlkOrderproductEntity.getItemUserid().getWechatInfo();
            if (set.size() > 0) {
                TlkUserwechatinfoEntity userwechatinfoEntity = set.iterator().next();
                wechatTemplateMessage.setTouser(userwechatinfoEntity.getTlkWechatuserEntity().getOpenid());
                wechatTemplateMessage.setTemplate_id(MobalMessageInterface.ORDER_PROCESS);
                Map<String, WechatTemplateItem> map1 = new HashMap<>();
                map1.put("first", new WechatTemplateItem("订单支付成功，稍后小拍会和您取得联系"));
                map1.put("keyword1", new WechatTemplateItem(tlkOrderproductEntity.getItemOrderid()));
                map1.put("keyword2", new WechatTemplateItem(tlkOrderproductEntity.getItemPrice()));
                map1.put("keyword3", new WechatTemplateItem(tlkOrderproductEntity.getItemState().getDes()));
                map1.put("keyword4", new WechatTemplateItem(new SimpleDateFormat("yyyy年MM月dd日HH时mm分").format(tlkOrderproductEntity.getCreated())));
                wechatTemplateMessage.setData(map1);
                templateMessageBussiness.send(wechatTemplateMessage, accessTokenService.getAccessToken());
            }
        } else if (orderState == OrderState.WAITE_TO_MAIL) {
            /**
             * 向客服发送消息通知(摄影师已上传完成)
             */
            wechatTemplateMessage.setTemplate_id(MobalMessageInterface.WAIT_TO_HANDLE);
            Map<String, WechatTemplateItem> map = new HashMap<>();
            map.put("first", new WechatTemplateItem("摄影师已上传订单(" + tlkOrderproductEntity.getItemOrderid() + ")的图片，请及时处理"));
            map.put("keyword1", new WechatTemplateItem("请确认摄影师提交的内容，并开始实物的制作"));
            map.put("keyword5", new WechatTemplateItem("请尽快处理"));
            wechatTemplateMessage.setData(map);
            List<TlkPtUserWxbdEntity> userWxbdEntities = userWxbdDao.findAll();
            Iterator<TlkPtUserWxbdEntity> iterator = userWxbdEntities.iterator();
            if (iterator.hasNext()) {
                wechatTemplateMessage.setTouser(iterator.next().getItemOpenid());
                templateMessageBussiness.send(wechatTemplateMessage, accessTokenService.getAccessToken());
            }
            /**
             * 向用户发送订单通知
             */
            Set<TlkUserwechatinfoEntity> set = tlkOrderproductEntity.getItemUserid().getWechatInfo();
            if (set.size() > 0) {
                TlkUserwechatinfoEntity userwechatinfoEntity = set.iterator().next();
                wechatTemplateMessage.setTouser(userwechatinfoEntity.getTlkWechatuserEntity().getOpenid());
                wechatTemplateMessage.setTemplate_id(MobalMessageInterface.PHOTOORDER_RECOMAIND);
                Map<String, WechatTemplateItem> map1 = new HashMap<>();
                map1.put("first", new WechatTemplateItem("摄影师已上传订单(" + tlkOrderproductEntity.getItemOrderid() + ")的图片，进入订单详情页查看"));
                map1.put("keyword1", new WechatTemplateItem(tlkOrderproductEntity.getItemProductid().getItemName()));
                map1.put("keyword2", new WechatTemplateItem(new SimpleDateFormat("yyyy年MM月dd日HH时mm分").format(tlkOrderproductEntity.getCreated())));
                map1.put("keyword3", new WechatTemplateItem(tlkOrderproductEntity.getItemPrice()));
                map1.put("keyword4", new WechatTemplateItem("摄影师已上传图片"));
                wechatTemplateMessage.setData(map1);
                templateMessageBussiness.send(wechatTemplateMessage, accessTokenService.getAccessToken());
            }
        }
    }

    public boolean updateOrderDate(String id, Date date) {
        if (orderDao.findById(id) != null) {
            orderDao.findById(id).setItemOrdertime(date);
            return true;
        }
        return false;
    }

    public boolean updateOrderPosition(String id, String position) {
        if (orderDao.findById(id) != null) {
            orderDao.findById(id).setItemPosition(position);
            return true;
        }
        return false;
    }

    public boolean updateOrderDetailPosition(String id, String detailposition) {
        if (orderDao.findById(id) != null) {
            orderDao.findById(id).setItemDetailposition(detailposition);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSyspj(String id, String num,String btn,String words,Date date) {
        TlkOrderproductEntity tlkOrderproductEntity = findOrderProductById(id);
        if(tlkOrderproductEntity!= null){
            tlkOrderproductEntity.setItemPjxj(num);
            tlkOrderproductEntity.setItemPjyd(btn);
            tlkOrderproductEntity.setItemPjnr(words);
            tlkOrderproductEntity.setItemPjsj(date);
            return true;
        }else {
            return false;
        }
    }

//    @Override
//    public List<TlkOrderproductEntity> getOrdersBySysid(String id) {
//        return orderDao.getOrderBySysId(id);
//    }
}
