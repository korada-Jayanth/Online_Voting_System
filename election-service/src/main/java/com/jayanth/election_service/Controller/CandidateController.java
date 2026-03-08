package com.jayanth.election_service.Controller;


import com.jayanth.election_service.Model.Candidate;
import com.jayanth.election_service.Service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate){
        return candidateService.addCandidate(candidate);
    }

    @GetMapping("/{electionId}")
    public List<Candidate> getCandidates(@PathVariable Long electionId){
        return candidateService.getCandidates(electionId);
    }
}
