package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.Passport;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Policy;
import vip.redcode.people.repository.PassportRepository;
import vip.redcode.people.service.PassportService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PassportServiceImpl implements PassportService {

    private PassportRepository repository;

    @Override
    public ResponseEntity<List<Passport>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Passport> findById(UUID id) {
        return repository.findById(id)
                .map(passport -> ResponseEntity.ok().body(passport))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> save(Passport passport) {
        return ResponseEntity.ok().body(repository.save(passport));
    }

    @Override
    public ResponseEntity<Passport> putSave(UUID id, Passport passport) {
        return repository.findById(id)
                .map(passportSave -> {
                    passportSave.setId(id);
                    passportSave.setPeople(passport.getPeople());
                    passportSave.setDate(passport.getDate());
                    passportSave.setGender(passport.getGender());
                    passportSave.setPlace_birth(passport.getPlace_birth());
                    passportSave.setPassport_series(passport.getPassport_series());
                    passportSave.setPassport_number(passport.getPassport_number());
                    passportSave.setPassport_issue(passport.getPassport_issue());
                    passportSave.setDate_issue(passport.getDate_issue());
                    passportSave.setDepartment_code(passport.getDepartment_code());
                    return ResponseEntity.ok().body(repository.save(passportSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> patchSave(UUID id, Passport passport) {
        return repository.findById(id)
                .map(passportSave -> {
                    if(passport.getPeople() != null) {
                        People people = new People();
                        if(passport.getPeople().getFirst_name() != null) {
                            people.setFirst_name(passport.getPeople().getFirst_name());
                        }
                        if(passport.getPeople().getLast_name() != null) {
                            people.setLast_name(passport.getPeople().getLast_name());
                        }
                        if(passport.getPeople().getMiddle_name() != null) {
                            people.setMiddle_name(passport.getPeople().getMiddle_name());
                        }
                        if(passport.getPeople().getBirth_date() != null) {
                            people.setBirth_date(passport.getPeople().getBirth_date());
                        }
                        if(passport.getPeople().getGender() != null) {
                            people.setGender(passport.getPeople().getGender());
                        }
                        if(passport.getPeople().getHeight() != null) {
                            people.setHeight(passport.getPeople().getHeight());
                        }
                        if(passport.getPeople().getWeight() != null) {
                            people.setWeight(passport.getPeople().getWeight());
                        }
                        if(passport.getPeople().getCloth_size() != null) {
                            people.setCloth_size(passport.getPeople().getCloth_size());
                        }
                        if(passport.getPeople().getFoot_size() != null) {
                            people.setFoot_size(passport.getPeople().getFoot_size());
                        }
                        if(passport.getPeople().getAdded() != null) {
                            people.setAdded(passport.getPeople().getAdded());
                        }
                        if(passport.getPeople().getInn() != null) {
                            people.setInn(passport.getPeople().getInn());
                        }
                        if(!passport.getPeople().getPassport().isEmpty()) {
                            List<Passport> list = new ArrayList<>();
                            for(Passport passportList: passport.getPeople().getPassport()) {
                                list.add(passportList);
                            }
                            people.setPassport(list);
                        }
                        if(!passport.getPeople().getPolicy().isEmpty()) {
                            List<Policy> list = new ArrayList<>();
                            for(Policy policy: passport.getPeople().getPolicy()) {
                                list.add(policy);
                            }
                            people.setPolicy(list);
                        }
                        if(!passport.getPeople().getAddress_to_people().isEmpty()) {
                            List<AddressToPeople> list = new ArrayList<>();
                            for(AddressToPeople address: passport.getPeople().getAddress_to_people()) {
                                list.add(address);
                            }
                            people.setAddress_to_people(list);
                        }
                        passportSave.setPeople(people);
                    }
                    if(passport.getDate() != null) {
                        passportSave.setDate(passport.getDate());
                    }
                    if(passport.getGender() != 0) {
                        passportSave.setGender(passport.getGender());
                    }
                    if(passport.getPlace_birth() != null) {
                        passportSave.setPlace_birth(passport.getPlace_birth());
                    }
                    if(passport.getPassport_series() != null) {
                        passportSave.setPassport_series(passport.getPassport_series());
                    }
                    if(passport.getPassport_number() != null) {
                        passportSave.setPassport_number(passport.getPassport_number());
                    }
                    if(passport.getPassport_issue() != null) {
                        passportSave.setPassport_issue(passport.getPassport_issue());
                    }
                    if(passport.getDate_issue() != null) {
                        passportSave.setDate_issue(passport.getDate_issue());
                    }
                    if(passport.getDepartment_code() != null) {
                        passportSave.setDepartment_code(passport.getDepartment_code());
                    }
                    return ResponseEntity.ok().body(repository.save(passportSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Passport> deleteById(UUID id) {
        return repository.findById(id)
                .map(passport -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(passport);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
