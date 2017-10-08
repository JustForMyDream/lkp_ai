package com.lkp.controller.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * websocket服务端连接配置
 * Created by cccxt on 2016/7/12.
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig /*extends WebMvcConfigurerAdapter*/ implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("/ws/webSocketServer");
        registry.addHandler(systemWebSocketHandler(), "/ws/webSocketServer").addInterceptors(webSocketHandshakeInterceptor()).setAllowedOrigins("*");

        registry.addHandler(systemWebSocketHandler(), "/ws/sockjs/webSocketServer").addInterceptors(webSocketHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public WebSocketHandler systemWebSocketHandler() {
        return new SystemWebSocketHandler();
    }
    @Bean
    public WebSocketHandshakeInterceptor webSocketHandshakeInterceptor(){
        return new WebSocketHandshakeInterceptor();
    }
}
