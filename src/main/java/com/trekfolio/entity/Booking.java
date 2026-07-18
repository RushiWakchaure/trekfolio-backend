package com.trekfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String phone;

    private Long trekId;

    private String bookingDate;

    private int numberOfPeople;

    private double totalAmount;

    private double advancePayment;

    private String paymentMode;

    private String paymentStatus;

    public Booking() {
    }

    public Booking(Long id, String userName, String email, String phone,
                   Long trekId, String bookingDate,
                   int numberOfPeople, double totalAmount,
                   double advancePayment, String paymentMode,
                   String paymentStatus) {

        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.trekId = trekId;
        this.bookingDate = bookingDate;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.advancePayment = advancePayment;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTrekId() {
        return trekId;
    }

    public void setTrekId(Long trekId) {
        this.trekId = trekId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}