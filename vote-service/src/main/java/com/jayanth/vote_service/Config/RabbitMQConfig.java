package com.jayanth.vote_service.Config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String VOTE_EVENTS_EXCHANGE = "vote.events.exchange";
    public static final String VOTE_CAST_ROUTING_KEY = "vote.cast";

    @Bean
    public TopicExchange voteEventsExchange() {
        return new TopicExchange(VOTE_EVENTS_EXCHANGE, true, false);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
