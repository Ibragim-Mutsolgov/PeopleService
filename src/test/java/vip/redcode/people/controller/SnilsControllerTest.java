package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Snils;
import vip.redcode.people.service.SnilsService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SnilsControllerTest {

    @Mock
    private SnilsService service;

    private SnilsController controller;

    private Snils snils;

    @BeforeEach
    void setUp() {
        controller = new SnilsController(service);
        snils = new Snils(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
                "123456789",
                new People()
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
        controller.findById(snils.getId());

        // then
        verify(service).findById(snils.getId());
    }

    @Test
    void save() {
        // given

        // when
        controller.save(snils);

        // then
        verify(service).save(snils);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(snils.getId(), snils);

        // then
        verify(service).putSave(snils.getId(), snils);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(snils.getId(), snils);

        // then
        verify(service).patchSave(snils.getId(), snils);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(snils.getId());

        // then
        verify(service).deleteById(snils.getId());
    }
}