package com.jayanth.election_service.Consumer;

import com.jayanth.election_service.Config.RabbitMQConfig;
import com.jayanth.election_service.Event.VoteCastEvent;
import com.jayanth.election_service.Service.VoteTallyService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteCastEventConsumer {

    private final VoteTallyService voteTallyService;

    @RabbitListener(queues = RabbitMQConfig.VOTE_CAST_QUEUE)
    public void consume(VoteCastEvent voteCastEvent) {
        voteTallyService.recordVote(voteCastEvent.getElectionId(), voteCastEvent.getCandidateId());
    }
}
