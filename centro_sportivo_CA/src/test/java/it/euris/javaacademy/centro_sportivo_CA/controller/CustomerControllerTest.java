package it.euris.javaacademy.centro_sportivo_CA.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Customer;
import it.euris.javaacademy.centro_sportivo_CA.dto.CustomerDTO;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.service.CustomerService;
import it.euris.javaacademy.centro_sportivo_CA.service.impl.CustomerServiceImpl;
import it.euris.javaacademy.centro_sportivo_CA.utility.TestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerServiceImpl customerService;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void shouldGetOneCustomer() throws Exception {

        Customer customer = TestSupport.getCustomer(1L);
        List<Customer> customers = List.of(customer);

        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
//                .andExpect(jsonPath("$[0].firstName").value(customer.getFirstName()))
//                .andExpect(jsonPath("$[0].lastName").value(customer.getLastName()));
    }
    @Test
    void shouldInsertACustomer() throws Exception {

        Customer customer = TestSupport.getCustomer(1L);

        when(customerService.insert(any())).thenReturn(customer);

        String auth = Base64.getEncoder().encodeToString(("academy:academy").getBytes());

        mockMvc.perform(post("/customers/v1")
                        .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer.toDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
//                .andExpect(jsonPath("$.firstName").value(customer.getFirstName()))
//                .andExpect(jsonPath("$.lastName").value(customer.getLastName()));
    }


}