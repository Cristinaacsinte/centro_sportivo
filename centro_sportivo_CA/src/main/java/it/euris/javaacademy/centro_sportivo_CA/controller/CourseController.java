package it.euris.javaacademy.centro_sportivo_CA.controller;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.dto.CourseDTO;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    CourseService courseService;
    @GetMapping("/v1")
    public List<CourseDTO> getAllCourse() {

        return courseService.findAll().stream().map(Course::toDto).toList();
    }

    @PostMapping("/v1")
    public CourseDTO insertCourse(@RequestBody CourseDTO courseDTO) {
        try {
            Course course = courseDTO.toModel();
            return courseService.insert(course).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public CourseDTO updateCustomer(@RequestBody CourseDTO courseDTO) {
        try {
            Course course = courseDTO.toModel();
            return courseService.update(course).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteCourse(@PathVariable("id") Long idCourse) {
        return courseService.deleteById(idCourse);
    }

    @GetMapping("/v1/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long idCourse) {
        return courseService.findById(idCourse).toDto();
    }
}
