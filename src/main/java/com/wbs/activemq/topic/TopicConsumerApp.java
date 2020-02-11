package com.wbs.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消费者主题模式
 *
 * @author: wangbingshuai
 * @create: 2019-08-10 13:10
 **/
public class TopicConsumerApp {
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String TOPIC_NAME = "test-activemq-topic";

    public static void main(String[] args) throws JMSException {
        //初始化ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //创建mq连接
        Connection conn = connectionFactory.createConnection();
        // 创建客户端ID，用于持久订阅
//        conn.setClientID("wbs");
        //启动连接
        conn.start();

        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //通过会话创建目标
        Topic dest = session.createTopic(TOPIC_NAME);
        //创建mq消息的消费者，是非持久订阅消费者
        MessageConsumer consumer = session.createConsumer(dest);

        // 持久订阅消费者
//        TopicSubscriber wbs = session.createDurableSubscriber(dest, "wbs");

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
