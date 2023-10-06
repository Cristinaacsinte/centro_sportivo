package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;

import java.util.List;
import java.util.Optional;

public interface ContractService  {
    List<Contract> findAll();

    Contract insert(Contract contract);
    Contract update(Contract contract);

   Boolean deleteById(Long idContract);

   Contract findById(Long idContract);
}
