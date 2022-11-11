package com.cognizant.service;

import com.cognizant.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking addBooking(Booking booking);
    List<Booking> getAllBookings();

    Optional<Booking> getBookingById(long bookingId);
    List<Booking> getBookingBySdTime(String sdTime);

    List<Booking> getBookingsByDateTime(String sdTime,String edTime);

    Booking updateBooking(Booking booking, long bookingId);
    void deleteBookingDetails(long bookingId);
}
