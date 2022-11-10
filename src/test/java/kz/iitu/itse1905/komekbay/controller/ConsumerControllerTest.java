package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Consumer;
import kz.iitu.itse1905.komekbay.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

class ConsumerControllerTest {
    @Mock
    Service service;
    @InjectMocks
    ConsumerController consumerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllConsumer() {
        when(service.listAllConsumer()).thenReturn(Arrays.<Consumer>asList(new Consumer(0, "firstName", "lastName", "address", 0f, "region")));

        ResponseEntity<List<Consumer>> result = consumerController.listAllConsumer(new HashMap<String, String>() {{
            put("String", "String");
        }});
        Assertions.assertNotNull( result);
    }

    @Test
    void testCreateConsumer() {
        when(service.createConsumer(any())).thenReturn("createConsumerResponse");

        ResponseEntity<String> result = consumerController.createConsumer(new Consumer(0, "firstName", "lastName", "address", 0f, "region"));
        Assertions.assertNotNull( result);
    }

    @Test
    void testUpdateConsumerById() {
        when(service.updateConsumerById(any(), anyInt())).thenReturn("updateConsumerByIdResponse");

        ResponseEntity<String> result = consumerController.updateConsumerById(new Consumer(0, "firstName", "lastName", "address", 0f, "region"), 0);
        Assertions.assertNotNull( result);
    }

    @Test
    void testDeleteConsumerByPersonalAccount() {
        when(service.deleteConsumerByPersonalAccount(anyInt())).thenReturn("deleteConsumerByPersonalAccountResponse");

        ResponseEntity<String> result = consumerController.deleteConsumerByPersonalAccount(0);
        Assertions.assertNotNull( result);
    }

    @Test
    void testListConsumerByRegion() {
        when(service.listConsumerByRegion(anyInt())).thenReturn(Arrays.<Consumer>asList(new Consumer(0, "firstName", "lastName", "address", 0f, "region")));

        ResponseEntity<List<Consumer>> result = consumerController.listConsumerByRegion(0);
        Assertions.assertNotNull( result);
    }

    @Test
    void testMakeBillToConsumerByPersonalAccount() {
        when(service.makeBillToConsumerByPersonalAccount(anyInt(), anyFloat(), anyString())).thenReturn("makeBillToConsumerByPersonalAccountResponse");

        ResponseEntity<String> result = consumerController.makeBillToConsumerByPersonalAccount(0, 0f, "checkOrPay");
        Assertions.assertNotNull( result);
    }

    @Test
    void testCallInspector() {
        when(service.callInspector(anyInt())).thenReturn("callInspectorResponse");

        ResponseEntity<String> result = consumerController.callInspector(0);
        Assertions.assertNotNull( result);
    }

    @Test
    void testPayInspector() {
        when(service.payInspector(anyInt(), anyInt(), anyString())).thenReturn("payInspectorResponse");

        ResponseEntity<String> result = consumerController.payInspector(0, 0, "checkOrPay");
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme