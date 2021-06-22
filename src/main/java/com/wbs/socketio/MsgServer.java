package com.wbs.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.concurrent.TimeUnit;

/**
 * 聊天服务
 *
 * @author: wangbingshuai
 * @create: 2020-02-27 20:15
 **/
public class MsgServer {
    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhsot");
        config.setPort(8888);
        SocketIOServer server = new SocketIOServer(config);
        OneToOneChartListener listener = new OneToOneChartListener();
        listener.setServer(server);
        OneToManyChartListener listenerMany = new OneToManyChartListener();
        listenerMany.setServer(server);
        // chatOne，chatMany为事件名称
        server.addEventListener("chatOne", Msg.class, listener);
        server.addEventListener("chatMany", Msg.class, listenerMany);
        // 启动服务
        server.start();
        TimeUnit.DAYS.sleep(Integer.MAX_VALUE);
        server.stop();
    }
}
