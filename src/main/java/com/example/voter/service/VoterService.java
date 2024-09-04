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


    public List<Voter> getAllValidVoters() {
        return voterRepository.findAll();
    }

    public Voter getValidVoterByVvid(String vvid) {
        return voterRepository.findById(vvid).orElse(null);
    }

    public Voter addValidVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public void deleteValidVoter(String vvid) {
        voterRepository.deleteById(vvid);
    }


}
