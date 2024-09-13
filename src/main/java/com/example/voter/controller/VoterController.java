package com.example.voter.controller;

import com.example.voter.data.Voter;
import com.example.voter.data.VoterRepository;
import com.example.voter.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;
    @Autowired
    private VoterRepository voterRepository;

    @GetMapping()
    public List<Voter> getAllVoters() {

        return voterService.getAllVoters();
    }

    @GetMapping("/{vid}")
    public ResponseEntity<Voter> getVoterByVid(@PathVariable String vid) {
        Voter voter = voterService.getVoterByVid(vid);
        if (voter != null) {
            return ResponseEntity.ok(voter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addVoter(@RequestBody Voter voter) {
        if (voterRepository.existsById(voter.getVid())) {
            return ResponseEntity.ok(Collections.singletonMap("exists", true));
        } else {
            voterRepository.save(voter);
            return ResponseEntity.ok(Collections.singletonMap("exists", false));
        }
    }

    @DeleteMapping("/{vid}")
    public void deleteVoter(@PathVariable String vid) {
        voterService.deleteVoter(vid);
    }

}
