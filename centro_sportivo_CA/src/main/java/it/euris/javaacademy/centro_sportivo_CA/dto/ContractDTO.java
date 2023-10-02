package it.euris.javaacademy.centro_sportivo_CA.dto;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDTO implements Dto {

    private Long id;

    private String contactType;

    private Boolean deleted;

    private String value;


    @Override
    public Contract toModel() {
        return Contract
                .builder()
                .id(id)
                .contactType(contactType)
                .deleted(deleted)
                .value(value)
                .build();
    }
}
