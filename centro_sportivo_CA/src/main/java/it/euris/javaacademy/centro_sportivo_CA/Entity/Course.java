package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.CourseDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "price")
    private Double price;

    @Column(name = "sport")
    private String sport;


    @Override
    public CourseDTO toDto() {
        return CourseDTO.builder()
                .id(id)
                .deleted(deleted)
                .denomination(denomination)
                .difficulty(difficulty)
                .price(price)
                .sport(sport)
                .build();
    }
}


