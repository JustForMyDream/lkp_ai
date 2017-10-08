package com.lkp.controller;

import com.cxt.wechat.pay.unifiedorder.util.WeChatSingUtil;
import com.cxt.wechat.util.WechatXmlUtil;
import com.lkp.bean.WeChatCfg;
import com.lkp.service.OrderService;
import com.lkp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * 微信支付通知接收
 */
@Controller
@RequestMapping("payResult")
public class PayResultAccepter {
    WechatXmlUtil wechatXmlUtil = new WechatXmlUtil();

    @Autowired
    WeChatCfg weChatCfg;

    @Autowired
    OrderService orderService;

    @RequestMapping("orderpay")
    public void getOrderPay(HttpServletRequest request, HttpServletResponse response){
        try {
            //解析支付通知
            Map<String, String> map = wechatXmlUtil.parseXml(request);
            if (map.get("return_code").equals("SUCCESS")) {
                if (map.get("result_code").equals("SUCCESS")) {
                    String sign = map.get("sign");
                    map.remove("sign");
                    if (new WeChatSingUtil().checkMD5(map, weChatCfg.getKey(), sign)) {
                        String out_trade_no = map.get("out_trade_no");
                        String transaction_id = map.get("transaction_id");
                        //处理微信支付消息
                        if(orderService.updateOrderPayState(out_trade_no,transaction_id)){
                            ResponseUtil.response(response, "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseUtil.response(response, "<xml><return_code><![CDATA[FAIL]]></return_code></xml>");
    }
}
