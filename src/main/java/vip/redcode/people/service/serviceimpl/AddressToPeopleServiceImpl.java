package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.AddressToPeopleRepository;
import vip.redcode.people.service.AddressToPeopleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AddressToPeopleServiceImpl implements AddressToPeopleService {

    private AddressToPeopleRepository repository;

    @Override
    public ResponseEntity<List<AddressToPeople>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<AddressToPeople> findById(UUID id) {
        return repository.findById(id)
                .map(addressToPeople -> ResponseEntity.ok().body(addressToPeople))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> save(AddressToPeople addressToPeople) {
        return ResponseEntity.ok().body(repository.save(addressToPeople));
    }

    @Override
    public ResponseEntity<AddressToPeople> putSave(UUID id, AddressToPeople addressToPeople) {
        return repository.findById(id)
                .map(addressToPeopleSave -> {
                    addressToPeopleSave.setId(id);
                    addressToPeopleSave.setPeople(addressToPeople.getPeople());
                    addressToPeopleSave.setAddress(addressToPeople.getAddress());
                    addressToPeopleSave.setAddress_type(addressToPeople.getAddress_type());
                    return ResponseEntity.ok().body(repository.save(addressToPeopleSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> patchSave(UUID id, AddressToPeople addressToPeople) {
        return repository.findById(id)
                .map(addressToPeopleSave -> {
                    if(addressToPeople.getPeople() != null) {
                        People people = new People();
                        if(addressToPeople.getPeople().getFirst_name() != null) {
                            people.setFirst_name(addressToPeople.getPeople().getFirst_name());
                        }
                        if(addressToPeople.getPeople().getLast_name() != null) {
                            people.setLast_name(addressToPeople.getPeople().getLast_name());
                        }
                        if(addressToPeople.getPeople().getMiddle_name() != null) {
                            people.setMiddle_name(addressToPeople.getPeople().getMiddle_name());
                        }
                        if(addressToPeople.getPeople().getBirth_date() != null) {
                            people.setBirth_date(addressToPeople.getPeople().getBirth_date());
                        }
                        if(addressToPeople.getPeople().getGender() != null) {
                            people.setGender(addressToPeople.getPeople().getGender());
                        }
                        if(addressToPeople.getPeople().getHeight() != null) {
                            people.setHeight(addressToPeople.getPeople().getHeight());
                        }
                        if(addressToPeople.getPeople().getWeight() != null) {
                            people.setWeight(addressToPeople.getPeople().getWeight());
                        }
                        if(addressToPeople.getPeople().getCloth_size() != null) {
                            people.setCloth_size(addressToPeople.getPeople().getCloth_size());
                        }
                        if(addressToPeople.getPeople().getFoot_size() != null) {
                            people.setFoot_size(addressToPeople.getPeople().getFoot_size());
                        }
                        if(addressToPeople.getPeople().getAdded() != null) {
                            people.setAdded(addressToPeople.getPeople().getAdded());
                        }
                        if(addressToPeople.getPeople().getInn() != null) {
                            people.setInn(addressToPeople.getPeople().getInn());
                        }
                        if(!addressToPeople.getPeople().getPassport().isEmpty()) {
                            List<Passport> passports = new ArrayList<>();
                            for(Passport passport: addressToPeople.getPeople().getPassport()) {
                                passports.add(passport);
                            }
                            people.setPassport(passports);
                        }
                        if(!addressToPeople.getPeople().getPolicy().isEmpty()) {
                            List<Policy> policies = new ArrayList<>();
                            for(Policy policy: addressToPeople.getPeople().getPolicy()) {
                                policies.add(policy);
                            }
                            people.setPolicy(policies);
                        }
                        if(!addressToPeople.getPeople().getAddress_to_people().isEmpty()) {
                            List<AddressToPeople> addresses = new ArrayList<>();
                            for(AddressToPeople address: addressToPeople.getPeople().getAddress_to_people()) {
                                addresses.add(address);
                            }
                            people.setAddress_to_people(addresses);
                        }
                        addressToPeopleSave.setPeople(people);
                    }
                    if(addressToPeople.getAddress() != null) {
                        Address address = new Address();
                        if(!addressToPeople.getAddress().getAddress_to_people().isEmpty()) {
                            List<AddressToPeople> addresses = new ArrayList<>();
                            for(AddressToPeople addressList: addressToPeople.getAddress().getAddress_to_people()) {
                                addresses.add(addressList);
                            }
                            address.setAddress_to_people(addresses);
                        }
                        if(addressToPeople.getAddress().getCountry() != null) {
                            address.setCountry(addressToPeople.getAddress().getCountry());
                        }
                        if(addressToPeople.getAddress().getRegion() != null) {
                            address.setRegion(addressToPeople.getAddress().getRegion());
                        }
                        if(addressToPeople.getAddress().getLocality() != null) {
                            address.setLocality(addressToPeople.getAddress().getLocality());
                        }
                        if(addressToPeople.getAddress().getCity() != null) {
                            address.setCity(addressToPeople.getAddress().getCity());
                        }
                        if(addressToPeople.getAddress().getNeighborhood() != null) {
                            address.setNeighborhood(addressToPeople.getAddress().getNeighborhood());
                        }
                        if(addressToPeople.getAddress().getStreet() != null) {
                            address.setStreet(addressToPeople.getAddress().getStreet());
                        }
                        if(addressToPeople.getAddress().getHouse() != null) {
                            address.setHouse(addressToPeople.getAddress().getHouse());
                        }
                        if(addressToPeople.getAddress().getStructure() != null) {
                            address.setStructure(addressToPeople.getAddress().getStructure());
                        }
                        if(addressToPeople.getAddress().getEntrance() != null) {
                            address.setEntrance(addressToPeople.getAddress().getEntrance());
                        }
                        if(addressToPeople.getAddress().getFloor() != null) {
                            address.setFloor(addressToPeople.getAddress().getFloor());
                        }
                        if(addressToPeople.getAddress().getFlat() != null) {
                            address.setFlat(addressToPeople.getAddress().getFlat());
                        }
                        addressToPeopleSave.setAddress(address);
                    }
                    if(addressToPeople.getAddress_type() != null) {
                        addressToPeopleSave.setAddress_type(addressToPeople.getAddress_type());
                    }
                    return ResponseEntity.ok().body(repository.save(addressToPeopleSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<AddressToPeople> deleteById(UUID id) {
        return repository.findById(id)
                .map(addressToPeople -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(addressToPeople);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
