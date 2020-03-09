package com.ahdy.xem.websocket.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/test-one")
@Component
public class MyWebSocket {

    private static AtomicInteger count  = new AtomicInteger(0);

    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<MyWebSocket>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        addOnline();
        System.out.println("有新连接加入！当前在线人数为" + count.get());
        try {
            sendMessage("webSocket message!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        subOnline();
        System.out.println("有新连接退出！当前在线人数为" + count.get());
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.println("客户端消息为：" + msg);
        for(MyWebSocket socket : webSockets) {
            try {
                socket.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    private int addOnline() {
        return count.incrementAndGet();
    }

    private int subOnline() {
        return count.decrementAndGet();
    }

}
