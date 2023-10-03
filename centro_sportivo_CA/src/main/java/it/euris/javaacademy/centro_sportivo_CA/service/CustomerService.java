package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer insert(Customer customer);

    Customer update(Customer customer);


    Boolean deleteById(Long idCustomer);

    Customer findById(Long idCustomer);



}

