package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.repository.CourseRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.CourseService;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long idCourse) {
        courseRepository.deleteById(idCourse);

    }

    @Override
    public Optional<Course> findById(Long idCourse) {
        return Optional.ofNullable(courseRepository.findById(idCourse).orElse(Course.builder().build()));
    }

    @Override
    public List<Course> findByCustomer(Customer customer) {
        return courseRepository.findByCustomer(customer);
    }
}
