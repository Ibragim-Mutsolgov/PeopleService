package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vip.redcode.people.model.Address;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.model.People;
import vip.redcode.people.service.AddressToPeopleService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressToPeopleControllerTest {

    @Mock
    private AddressToPeopleService service;

    private AddressToPeopleController controller;

    private AddressToPeople addressToPeople;

    @BeforeEach
    void setUp() {
        controller = new AddressToPeopleController(service);
        addressToPeople = new AddressToPeople(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
                new People(),
                new Address(),
                1
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
        controller.findById(addressToPeople.getId());

        // then
        verify(service).findById(addressToPeople.getId());
    }

    @Test
    void save() {
        // given

        // when
        controller.save(addressToPeople);

        // then
        verify(service).save(addressToPeople);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(addressToPeople.getId(), addressToPeople);

        // then
        service.putSave(addressToPeople.getId(), addressToPeople);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(addressToPeople.getId(), addressToPeople);

        // then
        verify(service).patchSave(addressToPeople.getId(), addressToPeople);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(addressToPeople.getId());

        // then
        verify(service).deleteById(addressToPeople.getId());
    }
}