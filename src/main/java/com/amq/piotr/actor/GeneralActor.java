package com.amq.piotr.actor;

import static com.amq.piotr.queue.Queue.GENERAL_QUEUE;

import org.springframework.jms.core.JmsTemplate;

import com.amq.piotr.base.Actor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralActor {

    private JmsTemplate jmsTemplate;
    private Actor<String> actor;

    public GeneralActor(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.actor = new Actor<String>(message -> {
            log.debug("Sending general message: " + message);
            this.jmsTemplate.convertAndSend(GENERAL_QUEUE, message);
        }, GENERAL_QUEUE);
    }

    public void push(String message) {
        this.actor.process(message);
    }

}
