package it.euris.javaacademy.centro_sportivo_CA.dto;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
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

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements  Dto {

    private Long id;

    private LocalDateTime birthName;

    private Boolean deleted;

    private String name;

    private String surname;

    private String taxCode;


    @Override
    public Customer toModel() {
        return Customer
                .builder()
                .id(id)
                .birthName(birthName)
                .name(name)
                .surname(surname)
                .taxCode(taxCode)
                .build();
    }
}
