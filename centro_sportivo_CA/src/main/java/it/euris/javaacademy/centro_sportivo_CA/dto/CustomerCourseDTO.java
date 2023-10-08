package it.euris.javaacademy.centro_sportivo_CA.dto;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.Entity.CustomerCourse;
import it.euris.javaacademy.centro_sportivo_CA.Entity.key.CustomerCourseKey;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.centro_sportivo_CA.utility.DataConversionUtility.stringToLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCourseDTO implements Dto {

    private String CustomerCourseId;

    private String customerId;

    private String courseId;

    private Boolean deleted = false;

    @Override
    public CustomerCourse toModel() {
        return CustomerCourse
                .builder()
                .id(new CustomerCourseKey (stringToLong(courseId),stringToLong(customerId)))
                .customer(Customer.builder().id(stringToLong(customerId)).build())
                .course(Course.builder().id(stringToLong(courseId)).build())
                .build();
    }
}
