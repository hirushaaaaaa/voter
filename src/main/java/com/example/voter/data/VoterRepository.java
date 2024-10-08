package com.example.voter.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String> {

    // Retrieve all voters
    List<Voter> findAll();

    // Retrieve a voter by their ID
    Optional<Voter> findById(String vid);

    // Save a new or updated voter
    Voter save(Voter voter);

    // Delete a voter by their ID
    void deleteById(String vid);

    // Check if a voter exists by their ID
    boolean existsById(String vid);
}
