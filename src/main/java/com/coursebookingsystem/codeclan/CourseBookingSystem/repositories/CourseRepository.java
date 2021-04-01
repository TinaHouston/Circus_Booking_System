package com.coursebookingsystem.codeclan.CourseBookingSystem.repositories;

import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByStarRating(int rating);

    List<Course> findCourseByBookingsCustomerName(String name);
}
