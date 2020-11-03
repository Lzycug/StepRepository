package com.lzycug.websocket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description：
 * author：lzyCug
 * date: 2020/11/3 15:49
 */
@ServerEndpoint("/ws/{name}")
@Component
@Slf4j
public class WebSocketServer {
    private String name;

    private Session session;

    private static int onlineNum = 0;

    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session) {
        log.info("新连接接入,name:{}", name);
        clients.put(name, this);
        this.name = name;
        this.session = session;
        log.info("当前在线人数：{}", ++onlineNum);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自用户{}的信息:{}", name, message);
        //群发消息
        sendMessageAll(message);
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误:{}", error.getMessage());
        error.printStackTrace();
    }

    @OnClose
    public void onClose() {
        clients.remove(name);
        log.info("{}下线了", name);
        log.info("当前在线人数：{}", --onlineNum);
    }

    private void sendMessageAll(String message) {
        log.info("群发消息：{}", message);
        for (WebSocketServer server : clients.values()) {
            server.session.getAsyncRemote().sendText(message);
        }
    }

    private void sendMessageTo(String message, String name) {
        for (WebSocketServer server : clients.values()) {
            if (server.name.equals(name)) {
                server.session.getAsyncRemote().sendText(message);
            }
        }
    }
}
