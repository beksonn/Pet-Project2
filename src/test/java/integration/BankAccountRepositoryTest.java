package integration;

import kz.iitu.itse1905.komekbay.model.BankAccount;
import kz.iitu.itse1905.komekbay.repository.BankAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

class BankAccountRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    BankAccountRepository bankAccountRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllBankAccount() {
        List<BankAccount> result = bankAccountRepository.listAllBankAccount();
        Assertions.assertNotNull(result);
    }

    @Test
    void testChangeOwnerPersonalAccount() {
        bankAccountRepository.changeOwnerPersonalAccount(new BankAccount(0, "ownerFullName", 0, 0f, true));
    }

    @Test
    void testFillUpAccount() {
        String result = bankAccountRepository.fillUpAccount(new BankAccount(0, null, 0, 0f, true), 0f);
        Assertions.assertEquals("Bank account filled up", result);
    }

    @Test
    void testFillDownAfterPayment() {
        String result = bankAccountRepository.fillDownAfterPayment(new BankAccount(0, null, 0, 0f, true), 0f, true);
        Assertions.assertEquals("You paid for this month", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme