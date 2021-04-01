package com.coursebookingsystem.codeclan.CourseBookingSystem.repositories;

import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseName(String name);

    List<Customer> findCustomersByTownAndBookingsCourseName(String town, String name);

    List<Customer> findCustomersByTownAndBookingsCourseNameAndAgeGreaterThan(String town, String name, int age);

    List<Customer> findCustomersByAgeGreaterThanAndTownAndBookingsCourseName(int Age, String town, String name);

    List<Customer> findCustomersByAgeGreaterThan(int age);
}
