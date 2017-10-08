package com.lkp.base.config;

/**
 * Created by 王干 on 2016/8/21.
 * 消息类型
 */
public interface MsgType {
    String UnRead = "未读";
    String Read = "已读";
    String Progress = "订单进度通知";
    String Yuyue = "预约消息";
    String Quxiao = "订单取消通知";
    String Finish = "订单完成通知";
    String YhRefound = "用户退款通知";
    String YhDDDQX = "用户订单待取消";
    String YHDSTZ = "用户打赏通知";
}
