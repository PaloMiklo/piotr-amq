package com.piotr.amq.consumer;

import static com.piotr.amq.queue.Queue.GENERAL_QUEUE;
import static com.piotr.amq.queue.Queue.IMAGE_QUEUE;
import static com.piotr.amq.queue.Queue.PRODUCT_QUEUE;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    @JmsListener(destination = GENERAL_QUEUE)
    public void receiveGeneral(String message) {
        System.out.println("Received general message: " + message);
    }

    @JmsListener(destination = PRODUCT_QUEUE)
    public void receiveProduct(String message) {
        System.out.println("Received product message: " + message);
    }

    @JmsListener(destination = IMAGE_QUEUE)
    public void receiveImage(String message) {
        System.out.println("Received image message: " + message);
    }
}
