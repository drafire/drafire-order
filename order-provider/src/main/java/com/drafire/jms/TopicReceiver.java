package com.drafire.jms;

import com.drafire.connection.ConnectionAddr;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activemq topic 模式下的消费者
 */
public class TopicReceiver {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + ConnectionAddr._128.getAddr() + ":61616");
        Connection connection = null;

        try {
            connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createTopic("first-topic");
            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("接收到topic模式下的消息：" + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                connection.close();
            }
        }
    }
}
