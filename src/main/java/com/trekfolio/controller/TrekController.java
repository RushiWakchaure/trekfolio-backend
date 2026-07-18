package com.trekfolio.controller;

import com.trekfolio.entity.Trek;
import com.trekfolio.service.TrekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treks")
@CrossOrigin("*")
public class TrekController {

    @Autowired
    private TrekService trekService;

    // Add Trek
    @PostMapping
    public Trek addTrek(@RequestBody Trek trek) {
        return trekService.addTrek(trek);
    }

    // Get All Treks
    @GetMapping
    public List<Trek> getAllTreks() {
        return trekService.getAllTreks();
    }

    // Get Trek By Id
    @GetMapping("/{id}")
    public Trek getTrekById(@PathVariable Long id) {
        return trekService.getTrekById(id);
    }

    // Update Trek
    @PutMapping("/{id}")
    public Trek updateTrek(@PathVariable Long id,
                           @RequestBody Trek trek) {
        return trekService.updateTrek(id, trek);
    }

    // Delete Trek
    @DeleteMapping("/{id}")
    public String deleteTrek(@PathVariable Long id) {
        trekService.deleteTrek(id);
        return "Trek Deleted Successfully";
    }
}
