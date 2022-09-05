package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.service.AddressToPeopleService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/address-to-people")
public class AddressToPeopleController {

    private AddressToPeopleService service;

    @GetMapping
    public ResponseEntity<List<AddressToPeople>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressToPeople> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddressToPeople> save(@RequestBody AddressToPeople address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressToPeople> putSave(@PathVariable UUID id, @RequestBody AddressToPeople address) {
        return service.putSave(id, address);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AddressToPeople> patchSave(@PathVariable UUID id, @RequestBody AddressToPeople address) {
        return service.patchSave(id, address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AddressToPeople> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
