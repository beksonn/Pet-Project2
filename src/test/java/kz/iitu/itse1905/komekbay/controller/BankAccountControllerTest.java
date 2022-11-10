package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.BankAccount;
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

class BankAccountControllerTest {
    @Mock
    Service service;
    @InjectMocks
    BankAccountController bankAccountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllBankAccount() {
        when(service.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, "ownerFullName", 0, 0f, true)));

        ResponseEntity<List<BankAccount>> result = bankAccountController.listAllBankAccount();
        Assertions.assertNotNull( result);
    }

    @Test
    void testFillUpBankAccount() {
        when(service.fillUpAccount(anyInt(), anyFloat())).thenReturn("fillUpAccountResponse");

        ResponseEntity<String> result = bankAccountController.fillUpBankAccount(0, 0f);
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme