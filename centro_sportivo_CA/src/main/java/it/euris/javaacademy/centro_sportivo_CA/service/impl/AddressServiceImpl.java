package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.AddressRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address insert(Address address) {
        if (address.getId() != null) {
            throw new IdMustBeNullException();
        }
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        if (address.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return addressRepository.save(address);
    }
    @Override
    public Boolean deleteById(Long idAddress) {
        addressRepository.deleteById(idAddress);

        return addressRepository.findById(idAddress).isEmpty();
    }

    @Override
    public Address findById(Long idAddress) {
        return addressRepository.findById(idAddress).orElse(Address.builder().build());
    }
}
