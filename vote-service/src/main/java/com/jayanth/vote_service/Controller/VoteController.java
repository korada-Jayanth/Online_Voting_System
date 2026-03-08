package com.jayanth.vote_service.Controller;

import com.jayanth.vote_service.DTO.ResultDTO;
import com.jayanth.vote_service.Model.Vote;
import com.jayanth.vote_service.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public Vote vote(@RequestBody Vote vote){
        return voteService.castVote(vote);
    }

    @GetMapping("/results/{electionId}")
    public List<ResultDTO> getResults(@PathVariable Long electionId){
        return voteService.getResults(electionId);
    }
}
