package vip.redcode.people.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.redcode.people.model.Address;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.repository.AddressRepository;
import vip.redcode.people.service.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    @Override
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Override
    public ResponseEntity<Address> findById(UUID id) {
        return repository.findById(id)
                .map(address -> ResponseEntity.ok().body(address))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> save(Address address) {
        return ResponseEntity.ok().body(repository.save(address));
    }

    @Override
    public ResponseEntity<Address> putSave(UUID id, Address address) {
        return repository.findById(id)
                .map(addressSave -> {
                    addressSave.setId(id);
                    addressSave.setAddress_to_people(address.getAddress_to_people());
                    addressSave.setCountry(address.getCountry());
                    addressSave.setRegion(address.getRegion());
                    addressSave.setLocality(address.getLocality());
                    addressSave.setCity(address.getCity());
                    addressSave.setNeighborhood(address.getNeighborhood());
                    addressSave.setStreet(address.getStreet());
                    addressSave.setHouse(address.getHouse());
                    addressSave.setStructure(address.getStructure());
                    addressSave.setEntrance(address.getEntrance());
                    addressSave.setFloor(address.getFloor());
                    addressSave.setFlat(address.getFlat());
                    return ResponseEntity.ok().body(repository.save(addressSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> patchSave(UUID id, Address address) {
        return repository.findById(id)
                .map(addressSave -> {
                    if(!address.getAddress_to_people().isEmpty()){
                        List<AddressToPeople> address1 = new ArrayList<>();
                        for(AddressToPeople addressToPeople: address.getAddress_to_people()) {
                            address1.add(addressToPeople);
                        }
                        addressSave.setAddress_to_people(address1);
                    }
                    if(address.getCountry() != null) {
                        addressSave.setCountry(address.getCountry());
                    }
                    if(address.getRegion() != null) {
                        addressSave.setRegion(address.getRegion());
                    }
                    if(address.getLocality() != null) {
                        addressSave.setLocality(address.getLocality());
                    }
                    if(address.getCity() != null) {
                        addressSave.setCity(address.getCity());
                    }
                    if(address.getNeighborhood() != null) {
                        addressSave.setNeighborhood(address.getNeighborhood());
                    }
                    if(address.getStreet() != null) {
                        addressSave.setStreet(address.getStreet());
                    }
                    if(address.getHouse() != null) {
                        addressSave.setHouse(address.getHouse());
                    }
                    if(address.getStructure() != null) {
                        addressSave.setStructure(address.getStructure());
                    }
                    if(address.getEntrance() != null) {
                        addressSave.setEntrance(address.getEntrance());
                    }
                    if(address.getFloor() != null) {
                        addressSave.setFloor(address.getFloor());
                    }
                    if(address.getFlat() != null) {
                        addressSave.setFlat(address.getFlat());
                    }
                    return ResponseEntity.ok().body(repository.save(addressSave));
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Address> deleteById(UUID id) {
        return repository.findById(id)
                .map(address -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(address);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
