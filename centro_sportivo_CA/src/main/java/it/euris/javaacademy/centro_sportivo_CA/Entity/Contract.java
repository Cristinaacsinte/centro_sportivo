package it.euris.javaacademy.centro_sportivo_CA.Entity;

import it.euris.javaacademy.centro_sportivo_CA.dto.ContractDTO;
import it.euris.javaacademy.centro_sportivo_CA.dto.archetype.Dto;
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
@Table(name = "contract")
public class Contract implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted= false;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Override
    public ContractDTO toDto() {
        return ContractDTO
                .builder()
                .id(id)
                .contactType(contactType)
                .deleted(deleted)
                .value(value)
                .build();
    }
}
