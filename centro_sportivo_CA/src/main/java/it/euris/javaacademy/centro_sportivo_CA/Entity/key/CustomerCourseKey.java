package it.euris.javaacademy.centro_sportivo_CA.Entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CustomerCourseKey implements Serializable {
    @Column(name="course_id")
    private Long courseId;

    @Column(name="customer_id")
    private Long customerId;
}
