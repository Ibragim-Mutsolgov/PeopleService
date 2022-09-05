package vip.redcode.people.service;

import org.springframework.http.ResponseEntity;
import vip.redcode.people.model.Passport;

import java.util.List;
import java.util.UUID;

public interface PassportService {

    ResponseEntity<List<Passport>> findAll();

    ResponseEntity<Passport> findById(UUID id);

    ResponseEntity<Passport> save(Passport passport);

    ResponseEntity<Passport> putSave(UUID id, Passport passport);

    ResponseEntity<Passport> patchSave(UUID id, Passport passport);

    ResponseEntity<Passport> deleteById(UUID id);
}
