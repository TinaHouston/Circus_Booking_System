package com.coursebookingsystem.codeclan.CourseBookingSystem.controllers;

import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Course;
import com.coursebookingsystem.codeclan.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

//    @GetMapping(value = "/courses")
//    public ResponseEntity<List<Course>> getAllCourses(){
//        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCoursesByFilters(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customer_name", required = false) String name){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.findCourseByStarRating(rating), HttpStatus.OK);}
        if(name != null){
            return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value= "/courses/customers")
//    public ResponseEntity<List<Course>> getCoursesByCustomer(@RequestParam(name="customer_name") String name){
//        return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerName(name), HttpStatus.OK);
//    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }
}
