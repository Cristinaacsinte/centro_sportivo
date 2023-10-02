package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.repository.CustomerRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long idCustomer) {customerRepository.deleteById(idCustomer);

    }

    @Override
    public Customer findById(Long idCustomer) {
        return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
    }
}

