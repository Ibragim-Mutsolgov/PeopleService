package vip.redcode.people.service.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.PolicyRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PolicyServiceImplTest {

    private PolicyServiceImpl service;

    @Autowired
    private PolicyRepository repository;

    private Policy policy;

    @BeforeEach
    void setUp() {
        service = new PolicyServiceImpl(repository);
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
                List.of(new Policy()),
                List.of(new Snils()),
                List.of(new AddressToPeople())
        );
        policy = new Policy(
                people,
                "polis",
                "type_polis"
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
        Policy policySave = repository.save(policy);

        // then
        assertEquals(service.findById(policySave.getId()).getBody(), policySave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(policy).getBody(), policy);
    }

    @Test
    void putSave() {
        // given

        // when
        Policy policySave = repository.save(policy);

        // then
        assertEquals(service.putSave(policySave.getId(), policySave).getBody(), policySave);
    }

    @Test
    void patchSave() {
        // given

        // when
        Policy policySave = repository.save(policy);

        // then
        assertEquals(service.patchSave(policySave.getId(), policySave).getBody(), policySave);
    }

    @Test
    void deleteById() {
        // given

        // when
        Policy policySave = repository.save(policy);

        // then
        assertEquals(service.deleteById(policySave.getId()).getBody(), policySave);
    }
}