package com.jayanth.election_service.Controller;


import com.jayanth.election_service.DTO.VoteTallyDTO;
import com.jayanth.election_service.Model.Election;
import com.jayanth.election_service.Service.ElectionService;
import com.jayanth.election_service.Service.VoteTallyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elections")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionService electionService;
    private final VoteTallyService voteTallyService;

    @PostMapping
    public Election createElection(@RequestBody Election election){
        return electionService.createElection(election);
    }

    @GetMapping
    public List<Election> getAll(){
        return electionService.getAllElections();
    }

    @GetMapping("/{id}")
    public Election getElection(@PathVariable Long id){
        return electionService.getElection(id);
    }

    @PostMapping("/start/{id}")
    public Election startElection(@PathVariable Long id){
        return electionService.startElection(id);
    }

    @PostMapping("/close/{id}")
    public Election closeElection(@PathVariable Long id){
        return electionService.closeElection(id);
    }

    @GetMapping("/{id}/tally")
    public List<VoteTallyDTO> getTally(@PathVariable Long id) {
        return voteTallyService.getElectionTally(id);
    }
}
