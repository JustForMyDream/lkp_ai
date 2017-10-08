package com.lkp.controller.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 *
 *
 */
public interface CommonWebSocketHandler {
    void excute(List<WebSocketSession> webSocketSessions);
}
