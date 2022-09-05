package vip.redcode.people.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.people.model.Policy;
import vip.redcode.people.service.PolicyService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/policy")
public class PolicyController {

    private PolicyService service;

    @GetMapping
    public ResponseEntity<List<Policy>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Policy> save(@RequestBody Policy policy) {
        return service.save(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> putSave(@PathVariable UUID id, @RequestBody Policy policy) {
        return service.putSave(id, policy);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Policy> patchSave(@PathVariable UUID id, @RequestBody Policy policy) {
        return service.patchSave(id, policy);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Policy> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
