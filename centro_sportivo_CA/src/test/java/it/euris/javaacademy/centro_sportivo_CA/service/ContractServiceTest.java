package it.euris.javaacademy.centro_sportivo_CA.service;

import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
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
public class ContractServiceTest {

    @MockBean
    ContractRepository contractRepository;

    @Autowired
   ContractService contractService;

    @Test
    void shouldReturnAContract(){

        Contract contract = TestSupport.getContract(1L);

        List<Contract> contracts = List.of(contract);

        when(contractRepository.findAll()).thenReturn(contracts);

        List<Contract> returnedContracts = contractService.findAll();

        assertThat(returnedContracts)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
                .isEqualTo(contract);
    }
    @Test
    void shouldInsertAContract(){

        Contract contract = TestSupport.getContract(null);

        when(contractRepository.save(any())).thenReturn(contract);

        Contract returnedContract = contractService.insert(contract);
        assertThat(returnedContract.getContactType())
                .isEqualTo(contract.getContactType());
    }
    @Test
    void shouldNotInsertAnyContract(){

        Contract contract = TestSupport.getContract(1L);
        when(contractRepository.save(any())).thenReturn(contract);

        assertThrows(IdMustBeNullException.class, () -> contractService.insert(contract));

        assertThatThrownBy(() -> contractService.insert(contract))
                .isInstanceOf(IdMustBeNullException.class);

    }
    @Test
    void shouldUpdateAContract(){

        Contract contract = TestSupport.getContract(1L);

        when(contractRepository.save(any())).thenReturn(contract);

        Contract returnedContract = contractService.update(contract);
        assertThat(returnedContract.getContactType())
                .isEqualTo(contract.getContactType());
    }
    @Test
    void shouldNotUpdateAnyContract(){

        Contract contract = TestSupport.getContract(null);
        when(contractRepository.save(any())).thenReturn(contract);

        assertThatThrownBy(() ->contractService.update(contract))
                .isInstanceOf(IdMustNotBeNullException.class);
    }
    @Test
    void shouldDeleteAContract() {
        //arrange
        Long id = 12L;

        doNothing().when(contractRepository).deleteById(anyLong());
        when(contractRepository.findById(id)).thenReturn(Optional.empty());
        assertTrue(contractService.deleteById(id));
        Mockito.verify(contractRepository, times(1)).deleteById(id);
    }
}
