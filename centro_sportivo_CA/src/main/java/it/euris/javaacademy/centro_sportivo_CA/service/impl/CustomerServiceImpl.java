package it.euris.javaacademy.centro_sportivo_CA.service.impl;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.CustomerRepository;
import it.euris.javaacademy.centro_sportivo_CA.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
   CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insert(Customer customer) {
        if (customer.getId() != null) {
            throw new IdMustNotBeNullException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return customerRepository.save(customer);
    }


    @Override
    public Boolean deleteById(Long idCustomer) {
        customerRepository.deleteById(idCustomer);

        return null;
    }

    @Override
    public Customer findById(Long idCustomer) {
        return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
    }


}

