package it.euris.javaacademy.centro_sportivo_CA.repository;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
