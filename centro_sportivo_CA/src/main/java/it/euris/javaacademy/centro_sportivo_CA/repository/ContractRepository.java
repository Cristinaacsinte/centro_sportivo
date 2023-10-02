package it.euris.javaacademy.centro_sportivo_CA.repository;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
