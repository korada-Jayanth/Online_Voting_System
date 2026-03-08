package com.jayanth.vote_service.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteCastEvent {
    private Long voteId;
    private Long userId;
    private Long electionId;
    private Long candidateId;
    private String castAt;
}
