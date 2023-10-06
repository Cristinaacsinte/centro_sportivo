package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.CourseRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }



    @Override
    public Course insert(Course course) {
        if (course.getId() != null) {
            throw new IdMustBeNullException();
        }
        return courseRepository.save(course);
    }

    @Override
    public Course  update(Course course) {
        if (course.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return courseRepository.save(course);
    }


    @Override
    public Boolean deleteById(Long idCourse) {
        courseRepository.deleteById(idCourse);

        return courseRepository.findById(idCourse).isEmpty();
    }

    @Override
    public Course  findById(Long idCourse) {
        return courseRepository.findById(idCourse).orElse(Course.builder().build());
    }




}
