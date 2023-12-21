package com.amq.piotr.actor;

import static com.amq.piotr.queue.Queue.IMAGE_QUEUE;

import org.springframework.jms.core.JmsTemplate;

import com.amq.piotr.base.Actor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImageActor {

    private JmsTemplate jmsTemplate;
    private Actor<String> actor;

    public ImageActor(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.actor = new Actor<String>(message -> {
            log.debug("Sending image message: " + message);
            this.jmsTemplate.convertAndSend(IMAGE_QUEUE, message);
        }, IMAGE_QUEUE);
    }

    public void push(String message) {
        this.actor.process(message);
    }

}