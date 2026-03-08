package com.jayanth.election_service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"electionId", "candidateId"})
)
public class VoteTally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long electionId;

    private Long candidateId;

    private Long voteCount;
}
