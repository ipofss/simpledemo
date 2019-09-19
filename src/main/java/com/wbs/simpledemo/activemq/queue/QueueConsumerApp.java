package com.wbs.simpledemo.activemq.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消费者队列模式
 *
 * @author: wangbingshuai
 * @create: 2019-08-10 13:10
 **/
public class QueueConsumerApp {
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String QUEUE_NAME = "test-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //初始化ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //创建mq连接
        Connection conn = connectionFactory.createConnection();
        //启动连接
        conn.start();

        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //通过会话创建目标
        Destination dest = session.createQueue(QUEUE_NAME);
        //创建mq消息的消费者
        MessageConsumer consumer = session.createConsumer(dest);

        //给消费者设定监听对象
        consumer.setMessageListener(message -> {
            TextMessage txtMessage = (TextMessage) message;
            try {
                System.out.println("get message " + txtMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }
}
