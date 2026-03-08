package com.jayanth.election_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteTallyDTO {
    private Long candidateId;
    private Long voteCount;
}
