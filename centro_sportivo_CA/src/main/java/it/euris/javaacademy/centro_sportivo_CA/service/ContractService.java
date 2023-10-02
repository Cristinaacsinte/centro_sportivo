package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService  {
    List<Contract> findAll();

    Contract save(Contract contract);

    void deleteById(Long idContract);

   Optional<Contract> findById(Long idContract);
}
