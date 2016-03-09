package com.test.msg;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {

	public static void main(String[] args) throws JMSException {
		//create connection factory
		ConnectionFactory cf = new  ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		//create connection
		Connection connection = cf.createConnection();
		
		//start the connection
		connection.start();
		
		//create a session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//queue
		Destination queue = session.createQueue("queue1");
		
		//Queuesender
		MessageProducer msgproducer = session.createProducer(queue);
		
		
		for(int i=0;i<=10;i++){
			
			TextMessage msg = session.createTextMessage("app message no !!!!" +i);
			msgproducer.send(msg);
			System.out.println("akjbakb");
			System.out.println(msg.getJMSMessageID());
		}
		
		connection.close();
		
		
		
	}

}
