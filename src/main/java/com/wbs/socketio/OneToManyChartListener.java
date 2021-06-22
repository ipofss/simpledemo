package com.wbs.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import lombok.Setter;

/**
 * 聊天室通讯监听器
 *
 * @author: wangbingshuai
 * @create: 2020-02-27 20:08
 **/
public class OneToManyChartListener implements DataListener<Msg> {
    @Setter
    private SocketIOServer server;

    @Override
    public void onData(SocketIOClient socketIOClient, Msg msg, AckRequest ackRequest) throws Exception {
        System.out.println("一对多" + socketIOClient.getSessionId());
        // chatEvent为事件的名称，data为发送的内容
        this.server.getBroadcastOperations().sendEvent("chatMany", msg);
    }
}
