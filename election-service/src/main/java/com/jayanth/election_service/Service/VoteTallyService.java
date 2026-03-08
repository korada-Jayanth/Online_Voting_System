package com.jayanth.election_service.Service;

import com.jayanth.election_service.DTO.VoteTallyDTO;
import com.jayanth.election_service.Model.VoteTally;
import com.jayanth.election_service.Repository.CandidateRepository;
import com.jayanth.election_service.Repository.VoteTallyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteTallyService {

    private final VoteTallyRepository voteTallyRepository;
    private final CandidateRepository candidateRepository;

    @Transactional
    public void recordVote(Long electionId, Long candidateId) {
        if (!candidateRepository.existsByIdAndElectionId(candidateId, electionId)) {
            throw new IllegalArgumentException("Candidate does not belong to election");
        }

        VoteTally voteTally = voteTallyRepository
                .findByElectionIdAndCandidateId(electionId, candidateId)
                .orElseGet(() -> {
                    VoteTally tally = new VoteTally();
                    tally.setElectionId(electionId);
                    tally.setCandidateId(candidateId);
                    tally.setVoteCount(0L);
                    return tally;
                });

        voteTally.setVoteCount(voteTally.getVoteCount() + 1);
        voteTallyRepository.save(voteTally);
    }

    public List<VoteTallyDTO> getElectionTally(Long electionId) {
        return voteTallyRepository.findByElectionIdOrderByVoteCountDesc(electionId)
                .stream()
                .map(v -> new VoteTallyDTO(v.getCandidateId(), v.getVoteCount()))
                .toList();
    }
}
