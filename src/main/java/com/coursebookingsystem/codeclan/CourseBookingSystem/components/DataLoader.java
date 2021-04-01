package com.coursebookingsystem.codeclan.CourseBookingSystem.components;

import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Booking;
import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Course;
import com.coursebookingsystem.codeclan.CourseBookingSystem.models.Customer;
import com.coursebookingsystem.codeclan.CourseBookingSystem.repositories.BookingRepository;
import com.coursebookingsystem.codeclan.CourseBookingSystem.repositories.CourseRepository;
import com.coursebookingsystem.codeclan.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){
        Course juggling = new Course("Juggling for Clumsies", "Inverness", 4);
        courseRepository.save(juggling);

        Course trapeze = new Course("Trapeze for Runners", "Glasgow", 3);
        courseRepository.save(trapeze);

        Course tightlining = new Course("Tightlining for Tall People", "Glasgow", 5);
        courseRepository.save(tightlining);

        Course unicycling = new Course("Unicycling for Busy Mums", "Edinburgh", 2);
        courseRepository.save(unicycling);

        Course ringmastery = new Course("Ringmastery for Dummies", "Dumfries", 4);
        courseRepository.save(ringmastery);

        Customer charlie = new Customer("Charlie Chaplin", "Inverness", 92);
        customerRepository.save(charlie);

        Customer bean = new Customer("Mr Bean", "Glasgow", 42);
        customerRepository.save(bean);

        Customer basil = new Customer("Basil Fawlty", "Edinburgh", 36);
        customerRepository.save(basil);

        Customer olive = new Customer("Olive Oil", "Glasgow", 21);
        customerRepository.save(olive);

        Customer andre = new Customer("Andre the Giant", "Dumfries", 51);
        customerRepository.save(andre);

        Booking booking1 = new Booking("1/4/2021", juggling, charlie);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("18/10/2021", trapeze, bean);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("20/8/2021", tightlining, basil);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("24/6/2021", unicycling, olive);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("30/12/2021", ringmastery, andre);
        bookingRepository.save(booking5);
    }
}
