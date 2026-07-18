package com.trekfolio.service;

import com.trekfolio.entity.Booking;
import com.trekfolio.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Save Booking
    public Booking addBooking(Booking booking) {

        if (booking.getAdvancePayment() > booking.getTotalAmount()) {
            throw new RuntimeException("Advance Payment cannot be greater than Total Amount");
        }

        if (booking.getAdvancePayment() == 0) {
            booking.setPaymentStatus("Pending");
        } else if (booking.getAdvancePayment() < booking.getTotalAmount()) {
            booking.setPaymentStatus("Partial");
        } else {
            booking.setPaymentStatus("Paid");
        }

        return bookingRepository.save(booking);
    }

    // Get All Bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get Booking By Id
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // Update Booking
    public Booking updateBooking(Long id, Booking booking) {

        Booking existingBooking = bookingRepository.findById(id).orElse(null);

        if (existingBooking != null) {

            existingBooking.setUserName(booking.getUserName());
            existingBooking.setEmail(booking.getEmail());
            existingBooking.setPhone(booking.getPhone());
            existingBooking.setTrekId(booking.getTrekId());
            existingBooking.setBookingDate(booking.getBookingDate());
            existingBooking.setNumberOfPeople(booking.getNumberOfPeople());
            existingBooking.setTotalAmount(booking.getTotalAmount());
            existingBooking.setAdvancePayment(booking.getAdvancePayment());
            existingBooking.setPaymentMode(booking.getPaymentMode());

            if (booking.getAdvancePayment() > booking.getTotalAmount()) {
                throw new RuntimeException("Advance Payment cannot be greater than Total Amount");
            }

            if (booking.getAdvancePayment() == 0) {
                existingBooking.setPaymentStatus("Pending");
            } else if (booking.getAdvancePayment() < booking.getTotalAmount()) {
                existingBooking.setPaymentStatus("Partial");
            } else {
                existingBooking.setPaymentStatus("Paid");
            }

            return bookingRepository.save(existingBooking);
        }

        return null;
    }

    // Delete Booking
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}