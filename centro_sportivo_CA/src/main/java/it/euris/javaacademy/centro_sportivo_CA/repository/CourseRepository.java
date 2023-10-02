package it.euris.javaacademy.centro_sportivo_CA.repository;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
