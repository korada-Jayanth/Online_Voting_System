package com.jayanth.election_service.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String party;

    private Long electionId;
}
