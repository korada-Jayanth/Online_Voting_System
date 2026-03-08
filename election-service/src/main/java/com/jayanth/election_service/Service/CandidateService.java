package com.jayanth.election_service.Service;



import com.jayanth.election_service.Model.Candidate;
import com.jayanth.election_service.Repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public Candidate addCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getCandidates(Long electionId){
        return candidateRepository.findByElectionId(electionId);
    }
}
