package com.drafire.jms;

import com.drafire.connection.ConnectionAddr;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueReceiver {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://" + ConnectionAddr._128.getAddr() + ":61616");

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            Destination destination = session.createQueue("first-queue");
            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println(receive.getText());
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
