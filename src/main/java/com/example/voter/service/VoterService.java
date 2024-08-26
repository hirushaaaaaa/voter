package com.example.voter.service;

import com.example.voter.data.InvalidVoter;
import com.example.voter.data.InvalidVoterRepository;
import com.example.voter.data.Voter;
import com.example.voter.data.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private InvalidVoterRepository invalidVoterRepository;

    public List<Voter> getAllValidVoters() {
        return voterRepository.findAll();
    }

    public Voter getValidVoterByVvid(int vvid) {
        return voterRepository.findById(vvid).orElse(null);
    }

    public Voter addValidVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public void deleteValidVoter(int VVID) {
        voterRepository.deleteById(VVID);
    }

    public List<InvalidVoter> getAllInvalidVoters() {
        return invalidVoterRepository.findAll();
    }

    public InvalidVoter getInvalidVoterByIvid(int IVID) {
        return invalidVoterRepository.findById(IVID).orElse(null);
    }

    public InvalidVoter addInvalidVoter(InvalidVoter invalidVoter) {
        return invalidVoterRepository.save(invalidVoter);
    }

    public void deleteInvalidVoter(int IVID) {
        invalidVoterRepository.deleteById(IVID);
    }


}
