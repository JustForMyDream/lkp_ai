package com.lkp.controller.websocket;

/**
 *
 */
public interface WebSocketStore {
    /**
     * 参数键
     */
    String ACTION = "action";

    /**
     * ACTION动作类型值
     */
    interface WebSocketActionType {
        /**
         * 用户微信扫描二维码
         */
        String SCAN = "scan";
        /**
         * 用户从页面登录
         */
        String LOGIN = "login";
    }
}
