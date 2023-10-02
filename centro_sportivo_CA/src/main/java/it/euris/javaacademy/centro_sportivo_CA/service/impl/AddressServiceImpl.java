package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.repository.AddressRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long idAddress) {
        addressRepository.deleteById(idAddress);

    }

    @Override
    public Address findById(Long idAddress) {
        return addressRepository.findById(idAddress).orElse(Address.builder().build());
    }
}
