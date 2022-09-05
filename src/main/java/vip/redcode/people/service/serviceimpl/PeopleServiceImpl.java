package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.Passport;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Policy;
import vip.redcode.people.repository.PeopleRepository;
import vip.redcode.people.service.PeopleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository repository;

    @Override
    public ResponseEntity<List<People>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<People> findById(UUID id) {
        return repository.findById(id)
                .map(people -> ResponseEntity.ok().body(people))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> save(People people) {
        return ResponseEntity.ok().body(repository.save(people));
    }

    @Override
    public ResponseEntity<People> putSave(UUID id, People people) {
        return repository.findById(id)
                .map(peopleSave -> {
                    peopleSave.setId(id);
                    peopleSave.setFirst_name(people.getFirst_name());
                    peopleSave.setLast_name(people.getLast_name());
                    peopleSave.setMiddle_name(people.getMiddle_name());
                    peopleSave.setBirth_date(people.getBirth_date());
                    peopleSave.setGender(people.getGender());
                    peopleSave.setHeight(people.getHeight());
                    peopleSave.setWeight(people.getWeight());
                    peopleSave.setCloth_size(people.getCloth_size());
                    peopleSave.setFoot_size(people.getFoot_size());
                    peopleSave.setAdded(people.getAdded());
                    peopleSave.setInn(people.getInn());
                    peopleSave.setPassport(people.getPassport());
                    peopleSave.setPolicy(people.getPolicy());
                    peopleSave.setAddress_to_people(people.getAddress_to_people());
                    return ResponseEntity.ok().body(repository.save(peopleSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> patchSave(UUID id, People people) {
        return repository.findById(id)
                .map(peopleSave -> {
                    if(people.getFirst_name() != null) {
                        peopleSave.setFirst_name(peopleSave.getFirst_name());
                    }
                    if(people.getLast_name() != null) {
                        peopleSave.setLast_name(people.getLast_name());
                    }
                    if(people.getMiddle_name() != null) {
                        peopleSave.setMiddle_name(people.getMiddle_name());
                    }
                    if(people.getBirth_date() != null) {
                        peopleSave.setBirth_date(people.getBirth_date());
                    }
                    if(people.getGender() != 0) {
                        peopleSave.setGender(people.getGender());
                    }
                    if(people.getHeight() != null) {
                        peopleSave.setHeight(people.getHeight());
                    }
                    if(people.getWeight() != null) {
                        peopleSave.setWeight(people.getWeight());
                    }
                    if(people.getCloth_size() != null) {
                        peopleSave.setFoot_size(people.getFoot_size());
                    }
                    if(people.getAdded() != null) {
                        peopleSave.setAdded(people.getAdded());
                    }
                    if(people.getInn() != null) {
                        peopleSave.setInn(people.getInn());
                    }
                    if(!people.getPassport().isEmpty()) {
                        List<Passport> list = new ArrayList<>();
                        for(Passport passportList: people.getPassport()) {
                            list.add(passportList);
                        }
                        peopleSave.setPassport(list);
                    }
                    if(!people.getPolicy().isEmpty()) {
                        List<Policy> list = new ArrayList<>();
                        for(Policy policy: people.getPolicy()) {
                            list.add(policy);
                        }
                        peopleSave.setPolicy(list);
                    }
                    if(!people.getAddress_to_people().isEmpty()) {
                        List<AddressToPeople> list = new ArrayList<>();
                        for(AddressToPeople address: people.getAddress_to_people()) {
                            list.add(address);
                        }
                        peopleSave.setAddress_to_people(list);
                    }
                    return ResponseEntity.ok().body(repository.save(peopleSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<People> deleteById(UUID id) {
        return repository.findById(id)
                .map(people -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(people);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
