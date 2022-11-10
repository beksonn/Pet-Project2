package integration;

import kz.iitu.itse1905.komekbay.model.Inspector;
import kz.iitu.itse1905.komekbay.repository.InspectorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

class InspectorRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    InspectorRepository inspectorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllInspectors() {
        List<Inspector> result = inspectorRepository.listAllInspectors();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme