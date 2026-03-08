package com.jayanth.vote_service.Service;

import com.jayanth.vote_service.DTO.ResultDTO;
import com.jayanth.vote_service.Event.VoteCastEvent;
import com.jayanth.vote_service.Model.Vote;
import com.jayanth.vote_service.Publisher.VoteEventPublisher;
import com.jayanth.vote_service.Repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoteEventPublisher voteEventPublisher;

    @Transactional
    public Vote castVote(Vote vote){

        if(voteRepository
                .findByUserIdAndElectionId(vote.getUserId(), vote.getElectionId())
                .isPresent()){

            throw new RuntimeException("User already voted");
        }

        Vote savedVote = voteRepository.save(vote);

        voteEventPublisher.publishVoteCast(
                new VoteCastEvent(
                        savedVote.getId(),
                        savedVote.getUserId(),
                        savedVote.getElectionId(),
                        savedVote.getCandidateId(),
                        Instant.now().toString()
                )
        );

        return savedVote;
    }

    public List<ResultDTO> getResults(Long electionId){
        return voteRepository.getElectionResults(electionId);
    }
}
