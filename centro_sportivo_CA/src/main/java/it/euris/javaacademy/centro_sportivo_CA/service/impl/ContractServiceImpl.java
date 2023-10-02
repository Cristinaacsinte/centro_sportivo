package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.repository.ContractRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.ContractService;

import java.util.List;
import java.util.Optional;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long idContract) {
        contractRepository.deleteById(idContract);

    }

    @Override
    public Optional<Contract> findById(Long idContract) {
        return Optional.ofNullable(contractRepository.findById(idContract).orElse(Contract.builder().build()));
    }
}
