package com.jayanth.election_service.Repository;


import com.jayanth.election_service.Model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
