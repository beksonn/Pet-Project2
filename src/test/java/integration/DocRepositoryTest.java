package integration;

import kz.iitu.itse1905.komekbay.model.Doc;
import kz.iitu.itse1905.komekbay.repository.DocRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

class DocRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    DocRepository docRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllDocs() {
        List<Doc> result = docRepository.listAllDocs();
        Assertions.assertNotNull(result);
    }

    @Test
    void testSaveFile() {
        docRepository.saveFile(new Doc(null, "docName", "docType", null));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme