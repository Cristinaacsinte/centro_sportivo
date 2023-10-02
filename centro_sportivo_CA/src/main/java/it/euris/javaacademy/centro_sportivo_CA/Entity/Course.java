package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.CourseDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedColumn("id")
    private Long id;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "denomination", nullable = false)
    private String denomination;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sport", nullable = false)
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


