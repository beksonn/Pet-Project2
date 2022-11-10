package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class RegionRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    RegionRepository regionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllRegion() {
        List<Region> result = regionRepository.listAllRegion();
        Assertions.assertNotNull(result);
    }

    @Test
    void testCreateRegion() {
        String result = regionRepository.createRegion(new Region(0, "name", 0f, 0f, 0f));
        Assertions.assertEquals("Region added successfully", result);
    }




}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme