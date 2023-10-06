package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.AddressDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "nation")
    private String nation;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "province")
    private String province;

    @OneToOne
    @JoinColumn(name = "costumer_id")
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
                .build();
    }
}


