package com.amq.piotr.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.amq.piotr.actor.GeneralActor;
import com.amq.piotr.actor.ImageActor;
import com.amq.piotr.actor.ProductActor;

@Component
public class JmsMessageProducer {

    private final JmsTemplate jmsTemplate;

    public JmsMessageProducer(JmsTemplate jmsTemplate) throws InterruptedException {
        this.jmsTemplate = jmsTemplate;
        // for (var i = 0; i <= 10; i++) {
        // Thread.sleep(3000);
        sendGeneral("HELLO GENERAL 🥰");
        sendProduct("HELLO PRODUCT 😘");
        sendImage("HELLO IMAGE 🤗");
        // }
    }

    public void sendGeneral(String message) {
        GeneralActor actor = new GeneralActor(jmsTemplate);
        actor.push(message);
    }

    public void sendProduct(String message) {
        ProductActor actor = new ProductActor(jmsTemplate);
        actor.push(message);
    }

    public void sendImage(String message) {
        ImageActor actor = new ImageActor(jmsTemplate);
        actor.push(message);
    }
}
