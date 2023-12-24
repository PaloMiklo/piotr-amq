package com.amq.piotr.consumer;

import static com.amq.piotr.queue.Queue.GENERAL_QUEUE;
import static com.amq.piotr.queue.Queue.IMAGE_QUEUE;
import static com.amq.piotr.queue.Queue.PIOTR_API_QUEUE_COMPLET;
import static com.amq.piotr.queue.Queue.PRODUCT_QUEUE;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JmsMessageConsumer {

    @JmsListener(destination = PIOTR_API_QUEUE_COMPLET)
    public void receiveEvent(String message) {
        log.debug("Received event: " + message);
    }

    @JmsListener(destination = GENERAL_QUEUE)
    public void receiveGeneral(String message) {
        log.debug("Received general message: " + message);
    }

    @JmsListener(destination = PRODUCT_QUEUE)
    public void receiveProduct(String message) {
        log.debug("Received product message: " + message);
    }

    @JmsListener(destination = IMAGE_QUEUE)
    public void receiveImage(String message) {
        log.debug("Received image message: " + message);
    }
}
