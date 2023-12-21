package com.amq.piotr.actor;

import static com.amq.piotr.queue.Queue.PRODUCT_QUEUE;

import org.springframework.jms.core.JmsTemplate;

import com.amq.piotr.base.Actor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductActor {

    private JmsTemplate jmsTemplate;
    private Actor<String> actor;

    public ProductActor(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.actor = new Actor<String>(message -> {
            log.debug("Sending product message: " + message);
            this.jmsTemplate.convertAndSend(PRODUCT_QUEUE, message);
        }, PRODUCT_QUEUE);
    }

    public void push(String message) {
        this.actor.process(message);
    }

}