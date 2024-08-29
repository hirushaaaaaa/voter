package com.example.voter.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvalidVoterRepository extends JpaRepository<InvalidVoter, String> {

    // Retrieve all invalid voters
    List<InvalidVoter> findAll();

    // Retrieve an invalid voter by their ID
    Optional<InvalidVoter> findById(String ivid);

    // Save a new or updated invalid voter
    InvalidVoter save(InvalidVoter invalidVoter);

    // Delete an invalid voter by their ID
    void deleteById(String ivid);

    // Check if an invalid voter exists by their ID
    boolean existsById(String ivid);
}
