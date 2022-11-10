package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Inspector;
import kz.iitu.itse1905.komekbay.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class InspectorControllerTest {
    @Mock
    Service service;
    @InjectMocks
    InspectorController inspectorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllInspector() {
        when(service.listAllInspector()).thenReturn(Arrays.<Inspector>asList(new Inspector(0, "firstName", "lastName", "region", 0, true)));

        ResponseEntity<List<Inspector>> result = inspectorController.listAllInspector();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme