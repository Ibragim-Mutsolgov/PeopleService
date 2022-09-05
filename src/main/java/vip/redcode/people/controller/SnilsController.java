package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.Snils;
import vip.redcode.people.service.SnilsService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/snils")
public class SnilsController {

    private SnilsService service;

    @GetMapping
    public ResponseEntity<List<Snils>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snils> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Snils> save(@RequestBody Snils snils) {
        return service.save(snils);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Snils> putSave(@PathVariable UUID id, @RequestBody Snils snils) {
        return service.putSave(id, snils);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Snils> patchSave(@PathVariable UUID id, @RequestBody Snils snils) {
        return service.patchSave(id, snils);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Snils> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
