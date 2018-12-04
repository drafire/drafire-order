package com.drafire.jms;

import com.drafire.connection.ConnectionAddr;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activemq 持久化消费者
 */
public class TopicPersistenceReceiver {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + ConnectionAddr._128.getAddr() + ":61616");

        Connection connection = null;
        try {
            connection = factory.createConnection();
            connection.setClientID("drafire");   //持久化的唯一id
            connection.start();

            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("first-topic");
            MessageConsumer consumer = session.createDurableSubscriber(topic, "drafire");

            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("持久化topic，接收到消息：" + message.getText());
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
