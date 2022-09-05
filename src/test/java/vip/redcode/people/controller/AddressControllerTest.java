package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vip.redcode.people.model.Address;
import vip.redcode.people.model.AddressToPeople;
import vip.redcode.people.service.AddressService;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressControllerTest {

    @Mock
    private AddressService service;

    private AddressController controller;

    private Address address;

    @BeforeEach
    void setUp() {
        controller = new AddressController(service);
        address = new Address(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
                List.of(new AddressToPeople()),
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
        controller.findAll();

        // then
        verify(service).findAll();
    }

    @Test
    void findById() {
        // given

        // when
        controller.findById(UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"));

        // then
        verify(service).findById(UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"));
    }

    @Test
    void save() {
        // given

        // when
        controller.save(address);

        // then
        verify(service).save(address);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(address.getId(), address);

        // then
        verify(service).putSave(address.getId(), address);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(address.getId(), address);

        // then
        verify(service).patchSave(address.getId(), address);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(address.getId());

        // then
        verify(service).deleteById(address.getId());
    }
}