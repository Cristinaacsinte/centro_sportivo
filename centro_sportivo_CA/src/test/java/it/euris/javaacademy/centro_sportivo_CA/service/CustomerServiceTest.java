package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.CustomerRepository;
import it.euris.javaacademy.centro_sportivo_CA.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {
    @MockBean
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;
    @Test
    void shouldReturnACustomer(){

        Customer customer = TestSupport.getCustomer(1L);

        List<Customer> customers = List.of(customer);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> returnedCustomers = customerService.findAll();

        assertThat(returnedCustomers)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
                .isEqualTo(customer);
    }

    @Test
    void shouldInsertACustomer(){

        Customer customer = TestSupport.getCustomer(null);

        when(customerRepository.save(any())).thenReturn(customer);

        Customer returnedCustomer = customerService.insert(customer);
        assertThat(returnedCustomer.getName())
                .isEqualTo(customer.getName());
    }
    @Test
    void shouldNotInsertAnyCustomer(){

        Customer customer = TestSupport.getCustomer(1L);
        when(customerRepository.save(any())).thenReturn(customer);

        assertThrows(IdMustBeNullException.class, () -> customerService.insert(customer));

        assertThatThrownBy(() -> customerService.insert(customer))
                .isInstanceOf(IdMustBeNullException.class);

    }

    @Test
    void shouldUpdateACustomer(){

        Customer customer = TestSupport.getCustomer(1L);

        when(customerRepository.save(any())).thenReturn(customer);

        Customer returnedCustomer = customerService.update(customer);
        assertThat(returnedCustomer.getName())
                .isEqualTo(customer.getName());
    }

    @Test
    void shouldNotUpdateAnyCustomer(){

        Customer customer = TestSupport.getCustomer(null);
        when(customerRepository.save(any())).thenReturn(customer);

        assertThatThrownBy(() -> customerService.update(customer))
                .isInstanceOf(IdMustNotBeNullException.class);
    }

}