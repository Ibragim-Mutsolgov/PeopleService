package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.SnilsRepository;
import vip.redcode.people.service.SnilsService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class SnilsServiceImpl implements SnilsService {

    private SnilsRepository repository;

    @Override
    public ResponseEntity<List<Snils>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Snils> findById(UUID id) {
        return repository.findById(id)
                .map(snils -> ResponseEntity.ok().body(snils))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> save(Snils snils) {
        return ResponseEntity.ok().body(repository.save(snils));
    }

    @Override
    public ResponseEntity<Snils> putSave(UUID id, Snils snils) {
        return repository.findById(id)
                .map(snilsSave -> {
                    snilsSave.setId(snils.getId());
                    snilsSave.setSnils_number(snils.getSnils_number());
                    snilsSave.setPeople(snils.getPeople());
                    return ResponseEntity.ok().body(repository.save(snilsSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> patchSave(UUID id, Snils snils) {
        return repository.findById(id)
                .map(snilsSave -> {
                    if(snils.getSnils_number() != null) {
                        snilsSave.setSnils_number(snils.getSnils_number());
                    }
                    if(snils.getPeople() != null) {
                        People people = new People();
                        if(snils.getPeople().getFirst_name() != null) {
                            people.setFirst_name(snils.getPeople().getFirst_name());
                        }
                        if(snils.getPeople().getLast_name() != null) {
                            people.setLast_name(snils.getPeople().getLast_name());
                        }
                        if(snils.getPeople().getMiddle_name() != null) {
                            people.setMiddle_name(snils.getPeople().getMiddle_name());
                        }
                        if(snils.getPeople().getBirth_date() != null) {
                            people.setBirth_date(snils.getPeople().getBirth_date());
                        }
                        if(snils.getPeople().getGender() != 0) {
                            people.setGender(snils.getPeople().getGender());
                        }
                        if(snils.getPeople().getHeight() != null) {
                            people.setHeight(snils.getPeople().getHeight());
                        }
                        if(snils.getPeople().getWeight() != null) {
                            people.setWeight(snils.getPeople().getWeight());
                        }
                        if(snils.getPeople().getCloth_size() != null) {
                            people.setCloth_size(snils.getPeople().getCloth_size());
                        }
                        if(snils.getPeople().getFoot_size() != null) {
                            people.setFoot_size(snils.getPeople().getFoot_size());
                        }
                        if(snils.getPeople().getAdded() != null) {
                            people.setAdded(snils.getPeople().getAdded());
                        }
                        if(snils.getPeople().getInn() != null) {
                            people.setInn(snils.getPeople().getInn());
                        }
                        if(!snils.getPeople().getPassport().isEmpty()) {
                            List<Passport> list = new ArrayList<>();
                            for(Passport passport: snils.getPeople().getPassport()) {
                                list.add(passport);
                            }
                            people.setPassport(list);
                        }
                        if(!snils.getPeople().getPolicy().isEmpty()) {
                            List<Policy> list = new ArrayList<>();
                            for(Policy policyList: snils.getPeople().getPolicy()) {
                                list.add(policyList);
                            }
                            people.setPolicy(list);
                        }
                        if(!snils.getPeople().getAddress_to_people().isEmpty()) {
                            List<AddressToPeople> list = new ArrayList<>();
                            for(AddressToPeople address: snils.getPeople().getAddress_to_people()) {
                                list.add(address);
                            }
                            people.setAddress_to_people(list);
                        }
                        snilsSave.setPeople(people);
                    }
                    return ResponseEntity.ok().body(repository.save(snilsSave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Snils> deleteById(UUID id) {
        return repository.findById(id)
                .map(snils -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(snils);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
