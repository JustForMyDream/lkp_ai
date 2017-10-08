package com.lkp.controller.websocket;

import com.lkp.entity.Qrcode_sql;
import com.lkp.controller.SessionStore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * websocket处理
 *
 */
public class SystemWebSocketHandler extends TextWebSocketHandler {
    private Gson gson = new Gson();

    private static final ArrayList<WebSocketSession> users;

    static {
        users = new ArrayList<WebSocketSession>();
    }

    public SystemWebSocketHandler() {
    }

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        users.add(webSocketSession);
        super.afterConnectionEstablished(webSocketSession);
    }

    /*    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
            TextMessage textMessage = (TextMessage) webSocketMessage;
            sendMessageToUsers(textMessage);
        }*/
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String str = new String(message.asBytes());
        Map<String,Object> msg = gson.fromJson(str,new TypeToken<HashMap<String,Object>>(){}.getType());
        /**
         * 用户登录
         */
        if(msg.get(WebSocketStore.ACTION).equals(WebSocketStore.WebSocketActionType.LOGIN)){

        }
    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        webSocketSession.close();
        users.remove(webSocketSession);
    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message 字符信息
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param ticket 二维码编号ticket
     * @param message    信息
     */
    public void sendMessageToUser(String ticket, TextMessage message) {
        for (WebSocketSession user : users) {
            Qrcode_sql qrcode_sql = (Qrcode_sql)user.getAttributes().get(SessionStore.QRCODE);
            if (qrcode_sql.getTicket().equals(ticket)) {
                try {
                    if (user.isOpen()) {
                        System.out.println("websocket消息已发送！！！！");
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param ticket 二维码编号ticket
     * @param message    信息
     */
    public void sendMessageToUser(String ticket, Map<String,Object> message) {
        for (WebSocketSession user : users) {
            Qrcode_sql qrcode_sql = (Qrcode_sql)user.getAttributes().get(SessionStore.QRCODE);
            if (qrcode_sql.getTicket().equals(ticket)) {
                try {
                    if (user.isOpen()) {

                        String m = new Gson().toJson(message);
                        user.sendMessage(new TextMessage(m));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    /**
     * 通用websocket处理
     *
     * @param commonWebSocketHandler 通用websocket处理类
     */
    public void commonHandle(CommonWebSocketHandler commonWebSocketHandler) {
        commonWebSocketHandler.excute(users);
    }
}
