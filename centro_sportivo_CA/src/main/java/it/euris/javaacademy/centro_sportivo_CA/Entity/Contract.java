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
    @GeneratedColumn("id")
    private Long id;

    @Column(name = "contact_type", nullable = false)
    private String contactType;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
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
