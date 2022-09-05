package vip.redcode.people.service.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vip.redcode.people.model.*;
import vip.redcode.people.repository.PassportRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PassportServiceImplTest {

    private PassportServiceImpl service;

    @Autowired
    private PassportRepository repository;

    private Passport passport;

    @BeforeEach
    void setUp() {
        service = new PassportServiceImpl(repository);
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
        passport = new Passport(
                people,
                new Date(),
                1,
                "Ингушетия",
                2323L,
                121212L,
                "Выдан",
                new Date(),
                "122-569"
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
        Passport passportSave = repository.save(passport);

        // then
        assertEquals(service.findById(passport.getId()).getBody(), passportSave);
    }

    @Test
    void save() {
        // given

        // when

        // then
        assertEquals(service.save(passport).getBody(), passport);
    }

    @Test
    void putSave() {
        // given

        // when
        Passport passportSave = repository.save(passport);

        // then
        assertEquals(service.putSave(passportSave.getId(), passportSave).getBody(), passportSave);
    }

    @Test
    void patchSave() {
        // given

        // when
        Passport passportSave = repository.save(passport);

        // then
        assertEquals(service.patchSave(passportSave.getId(), passportSave).getBody(), passportSave);
    }

    @Test
    void deleteById() {
        // given

        // when
        Passport passportSave = repository.save(passport);

        // then
        assertEquals(service.deleteById(passportSave.getId()).getBody(), passportSave);
    }
}