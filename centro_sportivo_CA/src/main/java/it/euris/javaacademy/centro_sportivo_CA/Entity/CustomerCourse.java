package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.Entity.key.CustomerCourseKey;
import it.euris.javaacademy.centro_sportivo_CA.dto.CustomerCourseDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {
    @EmbeddedId
    private CustomerCourseKey id;
    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Builder.Default
    @Column(name = "deleted")
    private Boolean deleted = false;

    @Override
    public CustomerCourseDTO toDto() {
        return CustomerCourseDTO
                .builder()
                .customerId(customer==null ? null : customer.getId().toString())
                .courseId(course==null ? null : course.getId().toString())
                .build();
    }
}
