package com.lkp.controller.websocket;

import com.lkp.entity.Qrcode_sql;
import com.lkp.controller.SessionStore;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 建立连接处理
 * Created by cccxt on 2016/7/12.
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session == null) {
               return false;
            }else{
                Qrcode_sql qrcode_sql = (Qrcode_sql) session.getAttribute(SessionStore.QRCODE);
                if(qrcode_sql == null){
                    return false;
                }else{
                    map.put(SessionStore.QRCODE, qrcode_sql);
                    return true;
                }
            }
        }
        return true;
    }

    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
