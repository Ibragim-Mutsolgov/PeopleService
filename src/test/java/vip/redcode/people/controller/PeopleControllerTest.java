package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.Passport;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Policy;
import vip.redcode.people.service.PeopleService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PeopleControllerTest {

    @Mock
    private PeopleService service;

    private PeopleController controller;

    private People people;

    @BeforeEach
    void setUp() {
        controller = new PeopleController(service);
        people = new People(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
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
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
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
        controller.findById(people.getId());

        // then
        verify(service).findById(people.getId());
    }

    @Test
    void save() {
        // given

        // when
        controller.save(people);

        // then
        verify(service).save(people);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(people.getId(), people);

        // then
        verify(service).putSave(people.getId(), people);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(people.getId(), people);

        // then
        verify(service).patchSave(people.getId(), people);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(people.getId());

        // then
        verify(service).deleteById(people.getId());
    }
}