package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.ContractRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
    @Override
    public Contract insert(Contract contract) {
        if (contract.getId() != null) {
            throw new IdMustBeNullException();
        }
        return contractRepository.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        if (contract.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return contractRepository.save(contract);
    }


    @Override
    public Boolean deleteById(Long idContract) {
        contractRepository.deleteById(idContract);

        return contractRepository.findById(idContract).isEmpty();
    }

    @Override
    public Contract findById(Long idContract) {
        return contractRepository.findById(idContract).orElse(Contract.builder().build());
    }

}
