package com.trekfolio.service;

import com.trekfolio.entity.Leader;
import com.trekfolio.repository.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderService {

    @Autowired
    private LeaderRepository leaderRepository;

    // Save Leader
    public Leader addLeader(Leader leader) {
        return leaderRepository.save(leader);
    }

    // Get All Leaders
    public List<Leader> getAllLeaders() {
        return leaderRepository.findAll();
    }

    // Get Leader By ID
    public Leader getLeaderById(Long id) {
        return leaderRepository.findById(id).orElse(null);
    }

    // Delete Leader
    public void deleteLeader(Long id) {
        leaderRepository.deleteById(id);
    }

    // Update Leader
    public Leader updateLeader(Long id, Leader leader) {

        Leader existingLeader = leaderRepository.findById(id).orElse(null);

        if (existingLeader != null) {

            existingLeader.setFullName(leader.getFullName());
            existingLeader.setEmail(leader.getEmail());
            existingLeader.setPhone(leader.getPhone());
            existingLeader.setCity(leader.getCity());
            existingLeader.setExperience(leader.getExperience());

            return leaderRepository.save(existingLeader);
        }

        return null;
    }

}
