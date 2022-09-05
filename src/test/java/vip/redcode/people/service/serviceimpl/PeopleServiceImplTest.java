package vip.redcode.people.service.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.PeopleRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PeopleServiceImplTest {

    private PeopleServiceImpl service;

    @Autowired
    private PeopleRepository repository;

    private People people;

    @BeforeEach
    void setUp() {
        service = new PeopleServiceImpl(repository);
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
        List<Passport> passports = new ArrayList<>();
        passports.add(passport);
        Policy policy = new Policy(
                new People(),
                "polis",
                "type_polis"
        );
        List<Policy> policies = new ArrayList<>();
        policies.add(policy);
        Address address = new Address(
                List.of(new AddressToPeople()),
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
        AddressToPeople addressToPeople = new AddressToPeople(
                people,
                address,
                1
        );
        List<AddressToPeople> addressToPeopleList = new ArrayList<>();
        addressToPeopleList.add(addressToPeople);
        people = new People(
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
                passports,
                policies,
                List.of(new Snils()),
                addressToPeopleList
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
        People peopleSave = repository.save(people);

        // then
        assertEquals(service.findById(peopleSave.getId()).getBody(), peopleSave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(people).getBody(), people);
    }

    @Test
    void putSave() {
        // given

        // when
        People peopleSave = repository.save(people);

        // then
        assertEquals(service.putSave(peopleSave.getId(), peopleSave).getBody(), peopleSave);
    }

    @Test
    void patchSave() {
        // given

        // when
        People peopleSave = repository.save(people);

        // then
        assertEquals(service.patchSave(peopleSave.getId(), peopleSave).getBody(), peopleSave);
    }

    @Test
    void deleteById() {
        // given

        // when
        People peopleSave = repository.save(people);

        // then
        assertEquals(service.deleteById(peopleSave.getId()).getBody(), peopleSave);
    }
}