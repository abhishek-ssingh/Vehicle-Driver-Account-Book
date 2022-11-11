package com.cognizant.controller;


import com.cognizant.model.Booking;
import com.cognizant.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        super();
        this.bookingService = bookingService;
    }

    //build create booking REST API
    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Booking> getALLBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable("bookingId") long bookingId){
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/sdt/{sdTime}")
    public List<Booking> getBookingBySdTime(@PathVariable("sdTime") String sdTime){
        return bookingService.getBookingBySdTime(sdTime);
    }

    @GetMapping("/date/{sdTime}/{edTime}")
    public List<Booking> getBookingsByDateTime(@PathVariable("sdTime") String sdTime, @PathVariable("edTime") String edTime){
        return bookingService.getBookingsByDateTime(sdTime,edTime);
    }

    @PutMapping("/id/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") long bookingId, @RequestBody Booking booking){
        return new ResponseEntity<Booking>(bookingService.updateBooking(booking, bookingId),HttpStatus.OK);
    }

    @DeleteMapping("/id/{bookingId}")
    public ResponseEntity<String> deleteBookingDetails(@PathVariable("bookingId") long bookingId){
        try{
            bookingService.deleteBookingDetails(bookingId);
            return new ResponseEntity<String>("Booking details deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
