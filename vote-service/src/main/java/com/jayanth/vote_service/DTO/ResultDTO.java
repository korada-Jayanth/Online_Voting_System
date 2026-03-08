package com.jayanth.vote_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDTO {

    private Long candidateId;
    private Long voteCount;

}
