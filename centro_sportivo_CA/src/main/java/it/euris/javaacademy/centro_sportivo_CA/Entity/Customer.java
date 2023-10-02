package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.CustomerDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "custumer")
public class Customer implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedColumn("id")
    private Long id;

    @Column(name = "birth_name", nullable = false)
    private LocalDateTime birthName;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "tax_code", nullable = false)
    private String taxCode;

    @OneToOne
    @JoinColumn(name ="customer_id" )
    private Address address;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Contract> contracts;

    @Override
    public CustomerDTO toDto() {
        return CustomerDTO
                .builder()
                .id(id)
                .birthName(birthName)
                .deleted(deleted)
                .surname(surname)
                .taxCode(taxCode)
                .build();
    }
}

