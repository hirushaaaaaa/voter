package com.example.voter.service;

import com.example.voter.data.Voter;
import com.example.voter.data.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;


    public List<Voter> getAllVoters() {

        return voterRepository.findAll();
    }

    public Voter getVoterByVid(String vid) {
        return voterRepository.findById(vid).orElse(null);
    }

    public Voter addVoter(Voter voter) {

        return voterRepository.save(voter);
    }

    public void deleteVoter(String vid) {
        voterRepository.deleteById(vid);
    }


}
