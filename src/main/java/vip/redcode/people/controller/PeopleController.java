package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.People;
import vip.redcode.people.service.PeopleService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {

    private PeopleService service;

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<People> save(@RequestBody People people) {
        return service.save(people);
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> putSave(@PathVariable UUID id, @RequestBody People people) {
        return service.putSave(id, people);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<People> patchSave(@PathVariable UUID id, @RequestBody People people) {
        return service.patchSave(id, people);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<People> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
