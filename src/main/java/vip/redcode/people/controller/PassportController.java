package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.Passport;
import vip.redcode.people.service.PassportService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/passport")
public class PassportController {

    private PassportService service;

    @GetMapping
    public ResponseEntity<List<Passport>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Passport> save(@RequestBody Passport passport) {
        return service.save(passport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passport> putSave(@PathVariable UUID id, @RequestBody Passport passport) {
        return service.putSave(id, passport);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passport> patchSave(@PathVariable UUID id, @RequestBody Passport passport) {
        return service.patchSave(id, passport);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Passport> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
