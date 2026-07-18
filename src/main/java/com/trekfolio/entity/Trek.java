package com.trekfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "treks")
public class Trek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trekName;
    private String location;
    private double price;
    private String difficulty;
    private int duration;
    private String date;
    private String imageUrl;
    private String description;

    public Trek() {
    }

    public Trek(Long id, String trekName, String location, double price,
                String difficulty, int duration, String date,
                String imageUrl, String description) {
        this.id = id;
        this.trekName = trekName;
        this.location = location;
        this.price = price;
        this.difficulty = difficulty;
        this.duration = duration;
        this.date = date;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrekName() {
        return trekName;
    }

    public void setTrekName(String trekName) {
        this.trekName = trekName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}