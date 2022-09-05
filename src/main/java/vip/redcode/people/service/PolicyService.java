package vip.redcode.people.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.people.model.Policy;

import java.util.List;
import java.util.UUID;

public interface PolicyService {

    ResponseEntity<List<Policy>> findAll();

    ResponseEntity<Policy> findById(UUID id);

    ResponseEntity<Policy> save(Policy policy);

    ResponseEntity<Policy> putSave(UUID id, Policy policy);

    ResponseEntity<Policy> patchSave(UUID id, Policy policy);

    ResponseEntity<Policy> deleteById(UUID id);
}
