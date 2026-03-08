package com.jayanth.vote_service.Repository;

import com.jayanth.vote_service.DTO.ResultDTO;
import com.jayanth.vote_service.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndElectionId(Long userId, Long electionId);

    List<Vote> findByElectionId(Long electionId);

    @Query("""
           SELECT new com.jayanth.vote_service.DTO.ResultDTO(v.candidateId, COUNT(v))
           FROM Vote v
           WHERE v.electionId = :electionId
           GROUP BY v.candidateId
           """)
    List<ResultDTO> getElectionResults(Long electionId);

}
