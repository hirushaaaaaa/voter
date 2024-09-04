package com.example.voter.controller;

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

    @GetMapping()
    public List<Voter> getAllValidVoters() {
        return voterService.getAllValidVoters();
    }

    @GetMapping("/{vvid}")
    public ResponseEntity<Voter> getValidVoterByVvid(@PathVariable String vvid) {
        Voter voter = voterService.getValidVoterByVvid(vvid);
        if (voter != null) {
            return ResponseEntity.ok(voter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public Voter addValidVoter(@RequestBody Voter voter) {
        return voterService.addValidVoter(voter);
    }

    @DeleteMapping("/{vvid}")
    public void deleteValidVoter(@PathVariable String vvid) {
        voterService.deleteValidVoter(vvid);
    }

}
