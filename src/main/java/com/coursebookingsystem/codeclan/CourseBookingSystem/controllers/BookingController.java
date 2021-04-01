package com.coursebookingsystem.codeclan.CourseBookingSystem.controllers;

import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Booking;
import com.coursebookingsystem.codeclan.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getBookingsByFilter(
            @RequestParam(name="date", required = false) String date){
        if(date != null){
            return new ResponseEntity<>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }
}
