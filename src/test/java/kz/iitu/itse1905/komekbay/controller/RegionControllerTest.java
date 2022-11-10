package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Region;
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

class RegionControllerTest {
    @Mock
    Service service;
    @InjectMocks
    RegionController regionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllRegion() {
        when(service.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        ResponseEntity<List<Region>> result = regionController.listAllRegion();
        Assertions.assertNotNull( result);
    }

    @Test
    void testCreateRegion() {
        when(service.createRegion(any())).thenReturn("createRegionResponse");

        ResponseEntity<String> result = regionController.createRegion(new Region(0, "name", 0f, 0f, 0f));
        Assertions.assertNotNull( result);
    }

    @Test
    void testFindHeadRegion() {
        when(service.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        ResponseEntity<List<Region>> result = regionController.findHeadRegion();
        Assertions.assertNotNull( result);
    }

    @Test
    void testCollectionOptionsRegion() {
        ResponseEntity<?> result = regionController.collectionOptionsRegion();
        Assertions.assertNotNull( result);
    }

    @Test
    void testGetAllItemWithPaging() {
        when(service.listAllRegionWithPagination(anyInt(), anyInt())).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        ResponseEntity<List<Region>> result = regionController.getAllItemWithPaging(0, 0);
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme