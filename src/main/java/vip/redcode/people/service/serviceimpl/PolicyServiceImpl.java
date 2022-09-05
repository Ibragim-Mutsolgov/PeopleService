package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.Passport;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Policy;
import vip.redcode.people.repository.PolicyRepository;
import vip.redcode.people.service.PolicyService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private PolicyRepository repository;

    @Override
    public ResponseEntity<List<Policy>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Policy> findById(UUID id) {
        return repository.findById(id)
                .map(policy -> ResponseEntity.ok().body(policy))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> save(Policy policy) {
        return ResponseEntity.ok().body(repository.save(policy));
    }

    @Override
    public ResponseEntity<Policy> putSave(UUID id, Policy policy) {
        return repository.findById(id)
                .map(policySave -> {
                    policySave.setId(policy.getId());
                    policySave.setPeople(policy.getPeople());
                    policySave.setPolicy(policy.getPolicy());
                    policySave.setType_policy(policy.getType_policy());
                    return ResponseEntity.ok().body(repository.save(policySave));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> patchSave(UUID id, Policy policy) {
        return repository.findById(id)
                .map(policySave -> {
                    if(policy.getPeople() != null) {
                        People people = new People();
                        if(policy.getPeople().getFirst_name() != null) {
                            people.setFirst_name(policy.getPeople().getFirst_name());
                        }
                        if(policy.getPeople().getLast_name() != null) {
                            people.setLast_name(policy.getPeople().getLast_name());
                        }
                        if(policy.getPeople().getMiddle_name() != null) {
                            people.setMiddle_name(policy.getPeople().getMiddle_name());
                        }
                        if(policy.getPeople().getBirth_date() != null) {
                            people.setBirth_date(policy.getPeople().getBirth_date());
                        }
                        if(policy.getPeople().getGender() != 0) {
                            people.setGender(policy.getPeople().getGender());
                        }
                        if(policy.getPeople().getHeight() != null) {
                            people.setHeight(policy.getPeople().getHeight());
                        }
                        if(policy.getPeople().getWeight() != null) {
                            people.setWeight(policy.getPeople().getWeight());
                        }
                        if(policy.getPeople().getCloth_size() != null) {
                            people.setCloth_size(policy.getPeople().getCloth_size());
                        }
                        if(policy.getPeople().getFoot_size() != null) {
                            people.setFoot_size(policy.getPeople().getFoot_size());
                        }
                        if(policy.getPeople().getAdded() != null) {
                            people.setAdded(policy.getPeople().getAdded());
                        }
                        if(policy.getPeople().getInn() != null) {
                            people.setInn(policy.getPeople().getInn());
                        }
                        if(!policy.getPeople().getPassport().isEmpty()) {
                            List<Passport> list = new ArrayList<>();
                            for(Passport passport: policy.getPeople().getPassport()) {
                                list.add(passport);
                            }
                            people.setPassport(list);
                        }
                        if(!policy.getPeople().getPolicy().isEmpty()) {
                            List<Policy> list = new ArrayList<>();
                            for(Policy policyList: policy.getPeople().getPolicy()) {
                                list.add(policyList);
                            }
                            people.setPolicy(list);
                        }
                        if(!policy.getPeople().getAddress_to_people().isEmpty()) {
                            List<AddressToPeople> list = new ArrayList<>();
                            for(AddressToPeople address: policy.getPeople().getAddress_to_people()) {
                                list.add(address);
                            }
                            people.setAddress_to_people(list);
                        }
                        policySave.setPeople(people);
                    }
                    if(policy.getPolicy() != null) {
                        policySave.setPolicy(policy.getPolicy());
                    }
                    if(policy.getType_policy() != null) {
                        policySave.setType_policy(policy.getType_policy());
                    }
                    return ResponseEntity.ok().body(repository.save(policySave));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Policy> deleteById(UUID id) {
        return repository.findById(id)
                .map(policy -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(policy);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
