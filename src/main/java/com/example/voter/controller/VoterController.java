package com.example.voter.controller;

import com.example.voter.data.Voter;
import com.example.voter.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

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
    public Voter addVoter(@RequestBody Voter voter) {
        return voterService.addVoter(voter);
    }



    @DeleteMapping("/{vid}")
    public void deleteVoter(@PathVariable String vid) {
        voterService.deleteVoter(vid);
    }

}
