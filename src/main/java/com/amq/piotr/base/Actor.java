package com.amq.piotr.base;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class Actor<MESSAGE> {

    private final ExecutorService queue;
    private final Consumer<MESSAGE> consumer;

    public Actor(Consumer<MESSAGE> consumer, String identifier) {
        this.consumer = consumer;
        this.queue = newSingleThreadExecutor(runnable -> new Thread(runnable, identifier));
    }

    public final CompletableFuture<Void> process(MESSAGE mssg) {
        return CompletableFuture.runAsync(() -> consumer.accept(mssg), queue);
    }
}
