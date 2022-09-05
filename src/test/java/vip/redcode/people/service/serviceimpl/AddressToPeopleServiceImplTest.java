package vip.redcode.people.service.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.AddressToPeopleRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressToPeopleServiceImplTest {

    private AddressToPeopleServiceImpl service;

    @Autowired
    private AddressToPeopleRepository repository;

    private AddressToPeople addressToPeople;

    @BeforeEach
    void setUp() {
        service = new AddressToPeopleServiceImpl(repository);
        Passport passport = new Passport(
                new People(),
                new Date(),
                1,
                "Республика Ингушетия",
                1234L,
                252525L,
                "Выдан",
                new Date(),
                "525-888"

        );
        Policy policy = new Policy();
        People people = new People(
                "Mutcolgov",
                "Ibragim",
                "Zurabovich",
                new Date(),
                1,
                80,
                178,
                50,
                41,
                new Timestamp(100),
                "123456789",
                List.of(passport),
                List.of(policy),
                List.of(new Snils()),
                List.of(new AddressToPeople())
        );
        AddressToPeople addressToPeopled = new AddressToPeople();
        Address address = new Address(
                List.of(addressToPeopled),
                "Россия",
                "Республика Ингушетия",
                "Назрановский",
                "Назрань",
                "Насыр-Корт",
                "Южная",
                "7",
                "-",
                "-",
                "-",
                "-"
        );
        addressToPeople = new AddressToPeople(
                people,
                address,
                1
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

        // when
        AddressToPeople addressSave = repository.save(addressToPeople);

        // then
        assertEquals(service.findById(addressSave.getId()).getBody(), addressSave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(addressToPeople).getBody(), addressToPeople);
    }

    @Test
    void putSave() {
        // given

        // when
        AddressToPeople address = repository.save(addressToPeople);

        // then
        assertEquals(service.putSave(address.getId(), address).getBody(), address);
    }

    @Test
    void patchSave() {
        // given

        // when
        AddressToPeople address = repository.save(addressToPeople);

        // then
        assertEquals(service.patchSave(address.getId(), address).getBody(), address);
    }

    @Test
    void deleteById() {
        // given

        // when
        AddressToPeople address = repository.save(addressToPeople);

        // then
        assertEquals(service.deleteById(address.getId()).getBody(), address);
    }
}