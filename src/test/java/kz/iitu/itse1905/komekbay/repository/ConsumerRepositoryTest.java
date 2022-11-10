package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ConsumerRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    ConsumerRepository consumerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllConsumers() {
        List<Consumer> result = consumerRepository.listAllConsumers();
        Assertions.assertNotNull(result);
    }

    @Test
    void testCreateConsumer() {
        String result = consumerRepository.createConsumer(new Consumer(0, "firstName", "lastName", "address", 0f, "region"));
        Assertions.assertEquals("Consumer added to Region successfully", result);
    }

    @Test
    void testUpdateConsumerById() {
        String result = consumerRepository.updateConsumerById(new Consumer(0, "firstName", "lastName", "address", 0f, "region"), 0);
        Assertions.assertEquals("Consumer updated successfully", result);
    }

    @Test
    void testDeleteConsumerByPersonalAccount() {
        String result = consumerRepository.deleteConsumerByPersonalAccount(0);
        Assertions.assertEquals("Consumer with personal account: 0 has been deleted", result);
    }

    @Test
    void testChangeLastMeterAfterBill() {
        consumerRepository.changeLastMeterAfterBill(0, 0f);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme