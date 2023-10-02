package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;

import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address save(Address address);

    void deleteById(Long idAddress);

    Address findById(Long idAddress);

}
