package it.euris.javaacademy.centro_sportivo_CA.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.dto.CustomerDTO;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/customers")
@SecurityRequirement(name = "authentication")
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the customers from the database<br>
            """)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll().stream().map(Customer::toDto).toList();
    }

    @PostMapping("/v1")
    public CustomerDTO insertCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = customerDTO.toModel();
            return customerService.insert(customer).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = customerDTO.toModel();
            return customerService.update(customer).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteCustomer(@PathVariable("id") Long idCustomer) {
        return customerService.deleteById(idCustomer);
    }

    @GetMapping("/v1/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long idCustomer) {
        return customerService.findById(idCustomer).toDto();
    }



}
