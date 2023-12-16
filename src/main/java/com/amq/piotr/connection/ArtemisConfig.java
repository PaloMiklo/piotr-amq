package com.amq.piotr.connection;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtemisConfig {

    @Value("${spring.artemis.username}")
    private String username;

    @Value("${spring.artemis.password}")
    private String password;

    @Value("${spring.artemis.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);

        factory.setUser(username);
        factory.setPassword(password);

        return factory;
    }
}
