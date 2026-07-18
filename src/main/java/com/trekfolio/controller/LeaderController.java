package com.trekfolio.controller;

import com.trekfolio.entity.Leader;
import com.trekfolio.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaders")
@CrossOrigin("*")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    // Add Leader
    @PostMapping
    public Leader addLeader(@RequestBody Leader leader) {
        return leaderService.addLeader(leader);
    }

    // Get All Leaders
    @GetMapping
    public List<Leader> getAllLeaders() {
        return leaderService.getAllLeaders();
    }

    // Get Leader By Id
    @GetMapping("/{id}")
    public Leader getLeaderById(@PathVariable Long id) {
        return leaderService.getLeaderById(id);
    }

    // Update Leader
    @PutMapping("/{id}")
    public Leader updateLeader(@PathVariable Long id,
                               @RequestBody Leader leader) {
        return leaderService.updateLeader(id, leader);
    }

    // Delete Leader
    @DeleteMapping("/{id}")
    public String deleteLeader(@PathVariable Long id) {
        leaderService.deleteLeader(id);
        return "Leader Deleted Successfully";
    }
}