package vip.redcode.people.service.serviceimpl;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.Address;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.People;
import vip.redcode.people.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@DataJpaTest
class AddressServiceImplTest {

    private AddressServiceImpl service;

    @Autowired
    private AddressRepository repository;

    private Address address;

    @BeforeEach
    void setUp() {
        service = new AddressServiceImpl(repository);
        AddressToPeople addressToPeople = new AddressToPeople();
        addressToPeople.setPeople(new People());
        addressToPeople.setAddress(new Address());
        addressToPeople.setAddress_type(1);
        List<AddressToPeople> list = new ArrayList<>();
        list.add(addressToPeople);
        address = new Address(
                list,
                "Россия",
                "Республика Ингушетия",
                "Назрановский район",
                "Назрань",
                "Насыр-Корт",
                "Южная",
                "7",
                "-",
                "-",
                "-",
                "-"
        );
    }

    @Test
    void findAll() {
        // given

        // when

        // then
        assertEquals(service.findAll().getBody().size(), 0);
    }

    @Test
    void findById() {
        // given
        Address addressSave;

        // when
        addressSave = repository.save(address);

        // then
        assertEquals(service.findById(addressSave.getId()).getBody(), addressSave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(address).getBody(), address);
    }

    @Test
    void putSave() {
        // given

        // when
        Address addressSave = repository.save(address);

        // then
        assertEquals(service.putSave(addressSave.getId(), addressSave).getBody(), address);
    }

    @Test
    void patchSave() {
        // given

        // when
        Address addressSave = repository.save(address);

        // then
        assertEquals(service.patchSave(addressSave.getId(), address).getBody(), address);
    }

    @Test
    void deleteById() {
        // given

        // when
        Address addressSave = repository.save(address);

        // then
        assertEquals(addressSave, service.deleteById(address.getId()).getBody());
    }
}