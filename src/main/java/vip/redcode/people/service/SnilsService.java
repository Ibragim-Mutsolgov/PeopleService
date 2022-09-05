package vip.redcode.people.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.people.model.Snils;

import java.util.List;
import java.util.UUID;

public interface SnilsService {

    ResponseEntity<List<Snils>> findAll();

    ResponseEntity<Snils> findById(UUID id);

    ResponseEntity<Snils> save(Snils snils);

    ResponseEntity<Snils> putSave(UUID id, Snils snils);

    ResponseEntity<Snils> patchSave(UUID id, Snils snils);

    ResponseEntity<Snils> deleteById(UUID id);
}
