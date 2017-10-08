package com.lkp.controller.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 *
 * Created by cccxt on 2016/7/19.
 */
public interface CommonWebSocketHandler {
    void excute(List<WebSocketSession> webSocketSessions);
}
