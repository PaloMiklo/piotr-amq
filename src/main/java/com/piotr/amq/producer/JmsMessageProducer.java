package com.piotr.amq.producer;

import static com.piotr.amq.queue.Queue.GENERAL_QUEUE;
import static com.piotr.amq.queue.Queue.IMAGE_QUEUE;
import static com.piotr.amq.queue.Queue.PRODUCT_QUEUE;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageProducer {

    private final JmsTemplate jmsTemplate;

    public JmsMessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        sendGeneral("HELLO GENERAL 🥰");
        sendProduct("HELLO PRODUCT 😘");
        sendImage("HELLO IMAGE 🤗");
    }

    public void sendGeneral(String message) {
        System.out.println("Sending general message: " + message);
        jmsTemplate.convertAndSend(GENERAL_QUEUE, message);
    }

    public void sendProduct(String message) {
        System.out.println("Sending product message: " + message);
        jmsTemplate.convertAndSend(PRODUCT_QUEUE, message);
    }

    public void sendImage(String message) {
        System.out.println("Sending image message : " + message);
        jmsTemplate.convertAndSend(IMAGE_QUEUE, message);
    }
}
