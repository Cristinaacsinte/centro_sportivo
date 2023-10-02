package it.euris.javaacademy.centro_sportivo_CA.dto;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO implements Dto {

    private Long id;

    private Boolean deleted;

    private String denomination;

    private String difficulty;

    private Double price;

    private String sport;

    @Override
    public Course toModel() {
        return Course
                .builder()
                .id(id)
                .deleted(deleted)
                .denomination(denomination)
                .difficulty(difficulty)
                .price(price)
                .sport(sport)
                .build();
    }


}
