package it.euris.javaacademy.centro_sportivo_CA.repository;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
