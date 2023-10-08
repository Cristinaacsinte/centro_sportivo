package it.euris.javaacademy.centro_sportivo_CA.utility;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Course;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;

import java.time.LocalDateTime;

public class TestSupport {
    public static Customer getCustomer(Long id) {
        return Customer
                .builder()
                .id(id)
                .birthName(LocalDateTime.parse("2023-09-13T12:12:00"))
                .surname("test surname")
                .taxCode("test taxCode")
                .build();
    }

    public static Course getCourse(Long id) {
        return Course
                .builder()
                .id(id)
                .price(0.0)
                .denomination("test denomination")
                .difficulty("test difficulty")
                .deleted(false)
                .build();
    }

    public static Contract getContract(Long id) {
        return Contract
                .builder()
                .id(id)
                .value("test value")
                .contactType("test ContractType")
                .customer(Customer.builder().id(id).build())
                .deleted(false)
                .build();
    }

    public static Address getAddress(Long id) {
        return Address
                .builder()
                .id(id)
                .address("test address")
                .province("test province")
                .nation("test nation")
                .customer(Customer.builder().id(id).build())
                .deleted(false)
                .build();
    }

}
