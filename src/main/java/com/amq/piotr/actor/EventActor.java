package com.amq.piotr.actor;

import static com.amq.piotr.topic.Topic.EVENT_TOPIC;

import org.springframework.jms.core.JmsTemplate;

import com.amq.piotr.base.Actor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventActor {

    private JmsTemplate jmsTemplate;
    private Actor<String> actor;

    public EventActor(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.actor = new Actor<String>(message -> {
            log.debug("Sending event: " + message);
            this.jmsTemplate.convertAndSend(EVENT_TOPIC, message);
        }, EVENT_TOPIC);
    }

    public void push(String message) {
        this.actor.process(message);
    }

}