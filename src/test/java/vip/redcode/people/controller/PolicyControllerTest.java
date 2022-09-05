package vip.redcode.people.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vip.redcode.people.model.People;
import vip.redcode.people.model.Policy;
import vip.redcode.people.service.PolicyService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PolicyControllerTest {

    @Mock
    private PolicyService service;

    private PolicyController controller;

    private Policy policy;

    @BeforeEach
    void setUp() {
        controller = new PolicyController(service);
        policy = new Policy(
                UUID.fromString("cd837474-2d18-11ed-a261-0242ac120002"),
                new People(),
                "polis",
                "type_polis"
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
        controller.findById(policy.getId());

        // then
        verify(service).findById(policy.getId());
    }

    @Test
    void save() {
        // given

        // when
        controller.save(policy);

        // then
        verify(service).save(policy);
    }

    @Test
    void putSave() {
        // given

        // when
        controller.putSave(policy.getId(), policy);

        // then
        verify(service).putSave(policy.getId(), policy);
    }

    @Test
    void patchSave() {
        // given

        // when
        controller.patchSave(policy.getId(), policy);

        // then
        verify(service).patchSave(policy.getId(), policy);
    }

    @Test
    void deleteById() {
        // given

        // when
        controller.deleteById(policy.getId());

        // then
        verify(service).deleteById(policy.getId());
    }
}