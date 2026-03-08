package com.jayanth.election_service.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String VOTE_EVENTS_EXCHANGE = "vote.events.exchange";
    public static final String VOTE_CAST_QUEUE = "election.vote.cast.queue";
    public static final String VOTE_CAST_ROUTING_KEY = "vote.cast";

    @Bean
    public TopicExchange voteEventsExchange() {
        return new TopicExchange(VOTE_EVENTS_EXCHANGE, true, false);
    }

    @Bean
    public Queue voteCastQueue() {
        return new Queue(VOTE_CAST_QUEUE, true);
    }

    @Bean
    public Binding voteCastBinding(Queue voteCastQueue, TopicExchange voteEventsExchange) {
        return BindingBuilder.bind(voteCastQueue).to(voteEventsExchange).with(VOTE_CAST_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
