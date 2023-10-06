package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address insert(Address address);
     Address update(Address address);
    Boolean deleteById(Long idAddress);

    Address findById(Long idAddress);

}
