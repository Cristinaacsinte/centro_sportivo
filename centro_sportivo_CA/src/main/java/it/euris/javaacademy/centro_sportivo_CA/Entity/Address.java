package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.AddressDTO;
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
@Table(name = "address")
public class Address implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedColumn("id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "nation", nullable = false)
    private String nation;

    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;

    @Column(name = "province", nullable = false)
    private String province ;

    @Column(name = "customer_id")
    private Long customerId;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private Customer customer;


    @Override
    public AddressDTO toDto() {
        return AddressDTO
                .builder()
                .address(address)
                .city(city)
                .deleted(deleted)
                .nation(nation)
                .postalCode(postalCode)
                .province(province)
                .customerId(customerId)
                .build();
    }
}
