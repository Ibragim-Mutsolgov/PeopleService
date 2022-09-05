package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.Address;
import vip.redcode.people.service.AddressService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Address> save(@RequestBody Address address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> putSave(@PathVariable UUID id, @RequestBody Address address) {
        return service.putSave(id, address);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Address> patchSave(@PathVariable UUID id, @RequestBody Address address) {
        return service.patchSave(id, address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Address> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
