package com.jayanth.election_service.Repository;

import com.jayanth.election_service.Model.VoteTally;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteTallyRepository extends JpaRepository<VoteTally, Long> {

    Optional<VoteTally> findByElectionIdAndCandidateId(Long electionId, Long candidateId);

    List<VoteTally> findByElectionIdOrderByVoteCountDesc(Long electionId);
}
