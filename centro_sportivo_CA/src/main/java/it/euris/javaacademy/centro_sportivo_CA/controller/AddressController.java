package it.euris.javaacademy.centro_sportivo_CA.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.centro_sportivo_CA.Entity.Address;
import it.euris.javaacademy.centro_sportivo_CA.dto.AddressDTO;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centro_sportivo_CA.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/address")
@SecurityRequirement(name = "authentication")
public class AddressController {

     private  AddressService addressService;




    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the address from the database<br>
            """)
    public List<AddressDTO> getAllAddress() {

        return addressService.findAll().stream().map(Address::toDto).toList();
    }

    @PostMapping("/v1")
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        try {
            Address address = addressDTO.toModel();
            return addressService.insert(address).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO) {
        try {
            Address address = addressDTO.toModel();
            return addressService.update(address).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteAddress(@PathVariable("id") Long idAddress) {
        return addressService.deleteById(idAddress);
    }

    @GetMapping("/v1/{id}")
    public AddressDTO getAddressById(@PathVariable("id") Long idAddress) {
        return addressService.findById(idAddress).toDto();
    }
}
