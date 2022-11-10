package integration;

import kz.iitu.itse1905.komekbay.model.Region;
import kz.iitu.itse1905.komekbay.repository.RegionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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