package it.euris.javaacademy.centro_sportivo_CA.dto;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratedColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO implements Dto {

    private Long id;

    private String address;

    private String city;

    private Boolean deleted;

    private String nation;

    private Integer postalCode;

    private String province ;

    private Long customerId;
    @Override
    public Address toModel() {
        return Address
                .builder()
                .id(id)
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
