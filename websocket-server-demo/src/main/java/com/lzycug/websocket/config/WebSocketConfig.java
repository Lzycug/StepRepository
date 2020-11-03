package com.lzycug.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * description：
 * author：lzyCug
 * date: 2020/11/3 15:46
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter endpointExporter(){
        return new ServerEndpointExporter();
    }
}
