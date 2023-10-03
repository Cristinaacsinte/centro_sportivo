package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Course save(Course course);

    void deleteById(Long idCourse);

    Optional<Course> findById(Long idCourse);

}
