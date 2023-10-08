package it.euris.javaacademy.centro_sportivo_CA.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.centro_sportivo_CA.Entity.CustomerCourse;
import it.euris.javaacademy.centro_sportivo_CA.repository.CustomerCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customerCourse")
@AllArgsConstructor
@SecurityRequirement(name = "authentication")
public class CustomerCourseController {
    CustomerCourseRepository courseRepository;

}
