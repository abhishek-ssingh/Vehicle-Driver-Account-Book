package com.cognizant.service.impl;

import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.Booking;
import com.cognizant.repository.BookingRepository;
import com.cognizant.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        super();
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking) ;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Booking> getBookingBySdTime(String sdTime) {
        return bookingRepository.findAllBySdTime(sdTime);
    }

    @Override
    public List<Booking> getBookingsByDateTime(String sdTime, String edTime) {
        return bookingRepository.findAllBySdTimeAndEdTime(sdTime,edTime);
    }

    @Override
    public Booking updateBooking(Booking booking, long bookingId) {
        Booking existingBooking = bookingRepository.findById(bookingId).orElseThrow( ()->
                new ResourceNotFoundException("Booking","Id",String.valueOf(bookingId)));

        existingBooking.setDistance(booking.getDistance());
        existingBooking.setDriver(booking.getDriver());
        existingBooking.setRemark(booking.getRemark());
        existingBooking.setEdTime(booking.getEdTime());
        existingBooking.setFromLocation(booking.getFromLocation());
        existingBooking.setToLocation(booking.getToLocation());
        existingBooking.setFuelExpense(booking.getFuelExpense());
        existingBooking.setTripFare(booking.getTripFare());
        existingBooking.setType(booking.getType());
        existingBooking.setVehicle(booking.getVehicle());
        existingBooking.setSdTime(booking.getSdTime());
        existingBooking.setDriverShare(booking.getDriverShare());

        bookingRepository.save(existingBooking);
        return existingBooking;
    }

    @Override
    public void deleteBookingDetails(long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
