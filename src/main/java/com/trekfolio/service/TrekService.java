package com.trekfolio.service;

import com.trekfolio.entity.Trek;
import com.trekfolio.repository.TrekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrekService {

    @Autowired
    private TrekRepository trekRepository;

    // Add Trek
    public Trek addTrek(Trek trek) {
        return trekRepository.save(trek);
    }

    // Get All Treks
    public List<Trek> getAllTreks() {
        return trekRepository.findAll();
    }

    // Get Trek By ID
    public Trek getTrekById(Long id) {
        return trekRepository.findById(id).orElse(null);
    }

    // Update Trek
    public Trek updateTrek(Long id, Trek trek) {

        Trek existingTrek = trekRepository.findById(id).orElse(null);

        if (existingTrek != null) {

            existingTrek.setTrekName(trek.getTrekName());
            existingTrek.setLocation(trek.getLocation());
            existingTrek.setPrice(trek.getPrice());
            existingTrek.setDifficulty(trek.getDifficulty());
            existingTrek.setDuration(trek.getDuration());
            existingTrek.setDate(trek.getDate());
            existingTrek.setImageUrl(trek.getImageUrl());
            existingTrek.setDescription(trek.getDescription());

            return trekRepository.save(existingTrek);
        }

        return null;
    }

    // Delete Trek
    public void deleteTrek(Long id) {
        trekRepository.deleteById(id);
    }

}