package com.jayanth.election_service.Service;


import com.jayanth.election_service.Model.Election;
import com.jayanth.election_service.Repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepository;

    public Election createElection(Election election){
        election.setStatus("CREATED");
        return electionRepository.save(election);
    }

    public List<Election> getAllElections(){
        return electionRepository.findAll();
    }

    public Election getElection(Long id){
        return electionRepository.findById(id).orElseThrow();
    }

    public Election startElection(Long id){
        Election election = getElection(id);
        election.setStatus("ACTIVE");
        return electionRepository.save(election);
    }

    public Election closeElection(Long id){
        Election election = getElection(id);
        election.setStatus("CLOSED");
        return electionRepository.save(election);
    }
}
