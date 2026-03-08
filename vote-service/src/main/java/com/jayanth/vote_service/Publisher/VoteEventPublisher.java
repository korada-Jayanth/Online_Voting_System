package com.jayanth.vote_service.Publisher;

import com.jayanth.vote_service.Config.RabbitMQConfig;
import com.jayanth.vote_service.Event.VoteCastEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishVoteCast(VoteCastEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.VOTE_EVENTS_EXCHANGE,
                RabbitMQConfig.VOTE_CAST_ROUTING_KEY,
                event
        );
    }
}
