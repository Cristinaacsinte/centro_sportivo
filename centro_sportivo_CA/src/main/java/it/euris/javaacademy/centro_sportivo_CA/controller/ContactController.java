package it.euris.javaacademy.centro_sportivo_CA.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Contract;
import it.euris.javaacademy.centro_sportivo_CA.dto.ContractDTO;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/contract")
@SecurityRequirement(name = "authentication")
public class ContactController {
    ContractService contractService;

    @GetMapping("/v1")
    public List<ContractDTO> getAllContract() {

        return contractService.findAll().stream().map(Contract::toDto).toList();
    }

    @PostMapping("/v1")
    public ContractDTO saveContract(@RequestBody ContractDTO contractDTO) {
        try {
            Contract contract = contractDTO.toModel();
            return contractService.insert(contract).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public ContractDTO updateContract(@RequestBody ContractDTO contractDTO) {
        try {
            Contract contract = contractDTO.toModel();
            return contractService.update(contract).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteContact(@PathVariable("id") Long idContract) {
        return contractService.deleteById(idContract);
    }

    @GetMapping("/v1/{id}")
    public ContractDTO getContactById(@PathVariable("id") Long idContract) {
        return contractService.findById(idContract).toDto();
    }
}
