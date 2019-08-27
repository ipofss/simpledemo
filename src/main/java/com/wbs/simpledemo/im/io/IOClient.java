package com.wbs.simpledemo.im.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * io客户端
 *
 * @author: wangbingshuai
 * @create: 2019-08-08 23:54
 **/
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
