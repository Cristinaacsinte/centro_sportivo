package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.repository.AddressRepository;
import it.euris.javaacademy.centro_sportivo_CA.repository.ContractRepository;
import it.euris.javaacademy.centro_sportivo_CA.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AddressServiceTest {
    @MockBean
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;

    @Test
    void shouldReturnAAddress(){

        Address address = TestSupport.getAddress(1L);

        List<Address> addresses = List.of(address);

        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> returnedAddress = addressService.findAll();

        assertThat(returnedAddress)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
                .isEqualTo(address);
    }
    @Test
    void shouldInsertAAddress(){

        Address address = TestSupport.getAddress(null);

        when(addressRepository.save(any())).thenReturn(address);

        Address returnedAddress =addressService.insert(address);
        assertThat(returnedAddress.getCity())
                .isEqualTo(address.getCity());
    }
    @Test
    void shouldNotInsertAnyAddress(){

        Address address = TestSupport.getAddress(1L);
        when(addressRepository.save(any())).thenReturn(address);

        assertThrows(IdMustBeNullException.class, () -> addressService.insert(address));

        assertThatThrownBy(() -> addressService.insert(address))
                .isInstanceOf(IdMustBeNullException.class);

    }
    @Test
    void shouldUpdateAAddress(){

        Address address = TestSupport.getAddress(1L);

        when(addressRepository.save(any())).thenReturn(address);

        Address returnedAddress = addressService.update(address);
        assertThat(returnedAddress.getCity())
                .isEqualTo(address.getCity());
    }
    @Test
    void shouldNotUpdateAnyAddress(){

        Address address = TestSupport.getAddress(null);
        when(addressRepository.save(any())).thenReturn(address);

        assertThatThrownBy(() ->addressService.update(address))
                .isInstanceOf(IdMustNotBeNullException.class);
    }
    @Test
    void shouldDeleteAAddress() {
        //arrange
        Long id = 12L;

        doNothing().when(addressRepository).deleteById(anyLong());
        when(addressRepository.findById(id)).thenReturn(Optional.empty());
        assertTrue(addressService.deleteById(id));
        Mockito.verify(addressRepository, times(1)).deleteById(id);
    }
}
