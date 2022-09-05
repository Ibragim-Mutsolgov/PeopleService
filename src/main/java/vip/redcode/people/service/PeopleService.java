package vip.redcode.people.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.people.model.People;

import java.util.List;
import java.util.UUID;

public interface PeopleService {

    ResponseEntity<List<People>> findAll();

    ResponseEntity<People> findById(UUID id);

    ResponseEntity<People> save(People people);

    ResponseEntity<People> putSave(UUID id, People people);

    ResponseEntity<People> patchSave(UUID id, People people);

    ResponseEntity<People> deleteById(UUID id);
}
