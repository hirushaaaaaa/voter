package com.example.voter.controller;

import com.example.voter.data.InvalidVoter;
import com.example.voter.data.Voter;
import com.example.voter.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/valid")
    public List<Voter> getAllValidVoters() {
        return voterService.getAllValidVoters();
    }

    @GetMapping("/valid/{vvid}")
    public ResponseEntity<Voter> getValidVoterByVvid(@PathVariable int vvid) {
        Voter voter = voterService.getValidVoterByVvid(vvid);
        if (voter != null) {
            return ResponseEntity.ok(voter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/valid")
    public Voter addValidVoter(@RequestBody Voter voter) {
        return voterService.addValidVoter(voter);
    }

    @DeleteMapping("/valid/{vvid}")
    public void deleteValidVoter(@PathVariable int vvid) {
        voterService.deleteValidVoter(vvid);
    }

    @GetMapping("/invalid")
    public List<InvalidVoter> getAllInvalidVoters() {
        return voterService.getAllInvalidVoters();
    }

    @GetMapping("/invalid/{ivid}")
    public ResponseEntity<InvalidVoter> getInvalidVoterByIvid(@PathVariable int ivid) {
        InvalidVoter invalidVoter = voterService.getInvalidVoterByIvid(ivid);
        if (invalidVoter != null) {
            return ResponseEntity.ok(invalidVoter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/invalid")
    public InvalidVoter addInvalidVoter(@RequestBody InvalidVoter invalidVoter) {
        return voterService.addInvalidVoter(invalidVoter);
    }

    @DeleteMapping("/invalid/{ivid}")
    public void deleteInvalidVoter(@PathVariable int ivid) {
        voterService.deleteInvalidVoter(ivid);
    }
}
