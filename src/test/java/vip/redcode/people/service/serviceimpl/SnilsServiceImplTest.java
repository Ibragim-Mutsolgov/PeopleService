package vip.redcode.people.service.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.SnilsRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SnilsServiceImplTest {

    private SnilsServiceImpl service;

    @Autowired
    private SnilsRepository repository;

    private Snils snils;

    @BeforeEach
    void setUp() {
        service = new SnilsServiceImpl(repository);
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
                List.of(new Passport()),
                List.of(new Policy()),
                List.of(new Snils()),
                List.of(new AddressToPeople())
        );
        snils = new Snils(
                "123456789",
                people
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
        Snils snilsSave = repository.save(snils);

        // then
        assertEquals(service.findById(snilsSave.getId()).getBody(), snilsSave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(snils).getBody(), snils);
    }

    @Test
    void putSave() {
        // given

        // when
        Snils snilsSave = repository.save(snils);

        // then
        assertEquals(service.putSave(snilsSave.getId(), snilsSave).getBody(), snilsSave);
    }

    @Test
    void patchSave() {
        // given

        // when
        Snils snilsSave = repository.save(snils);

        // then
        assertEquals(service.patchSave(snilsSave.getId(), snilsSave).getBody(), snilsSave);
    }

    @Test
    void deleteById() {
        // given

        // when
        Snils snilsSave = repository.save(snils);

        // then
        assertEquals(service.deleteById(snilsSave.getId()).getBody(), snilsSave);
    }
}