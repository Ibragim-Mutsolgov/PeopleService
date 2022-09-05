package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import vip.redcode.people.model.Passport;
import vip.redcode.people.model.People;
import vip.redcode.people.service.PassportService;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PassportControllerTest {

    @Mock
    private PassportService service;

    private PassportController controller;

    private Passport passport;

    @BeforeEach
    void setUp() {
        controller = new PassportController(service);
        passport = new Passport(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
                new People(),
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
        controller.findAll();

        // then
        verify(service).findAll();
    }

    @Test
    void findById() {
        // given

        // when
        controller.findById(passport.getId());

        // then
        verify(service).findById(passport.getId());
    }

    @Test
    void save() {
        // given

        // when
        controller.save(passport);

        // then
        verify(service).save(passport);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(passport.getId(), passport);

        // then
        verify(service).putSave(passport.getId(), passport);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(passport.getId(), passport);

        // then
        verify(service).patchSave(passport.getId(), passport);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(passport.getId());

        // then
        verify(service).deleteById(passport.getId());
    }
}