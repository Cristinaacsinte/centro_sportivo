package it.euris.javaacademy.centro_sportivo_CA.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.javaacademy.centro_sportivo_CA.dto.CustomerDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "birth_name")
    private LocalDateTime birthName;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tax_code")
    private String taxCode;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Address address;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    List<Contract> contracts;

    @OneToMany(mappedBy = "customer")
    private List<CustomerCourse> customerCourses = new ArrayList<>();

    @Override
    public CustomerDTO toDto() {
        return CustomerDTO
                .builder()
                .id(id)
                .birthName(birthName)
                .surname(surname)
                .taxCode(taxCode)
                .build();
    }


}

