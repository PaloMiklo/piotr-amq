package com.amq.piotr.queue;

import static com.amq.piotr.topic.Topic.EVENT_TOPIC;

public interface Queue {
    public static final String GENERAL_QUEUE = "general";
    public static final String PRODUCT_QUEUE = "product";
    public static final String IMAGE_QUEUE = "image";
    public static final String PIOTR_API_QUEUE = "piotr-api";
    public static final String PIOTR_API_QUEUE_COMPLET = EVENT_TOPIC + "::" + PIOTR_API_QUEUE;
}
