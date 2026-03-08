package com.jayanth.election_service.Repository;


import com.jayanth.election_service.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByElectionId(Long electionId);
    boolean existsByIdAndElectionId(Long id, Long electionId);

}
