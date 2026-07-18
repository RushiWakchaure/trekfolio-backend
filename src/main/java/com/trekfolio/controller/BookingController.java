package com.trekfolio.controller;

import com.trekfolio.entity.Booking;
import com.trekfolio.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Add Booking
    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    // Get All Bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get Booking By Id
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Update Booking
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id,
                                 @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    // Delete Booking
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking Deleted Successfully";
    }
}
