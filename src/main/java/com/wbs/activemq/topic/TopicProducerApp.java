package com.wbs.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者主题模式
 *
 * @author: wangbingshuai
 * @create: 2019-08-10 11:45
 **/
public class TopicProducerApp {
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String TOPIC_NAME = "test-activemq-topic";

    public static void main(String[] args) throws JMSException {
        //初始化连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //获得连接
        Connection conn = connectionFactory.createConnection();
        //启动连接
        conn.start();

        //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建队列
        Destination dest = session.createTopic(TOPIC_NAME);
        //createTopic方法用来创建Topic
        //session.createTopic("TOPIC");

        //通过session可以创建消息的生产者
        MessageProducer producer = session.createProducer(dest);

        // 设置持久订阅模式
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for (int i = 0; i < 100; i++) {
            //初始化一个mq消息
            TextMessage message = session.createTextMessage("hello active mq 中文" + i);
            //发送消息
            producer.send(message);
            System.out.println("hello active mq 中文" + i);
        }

        //关闭mq连接
        conn.close();
    }

}
