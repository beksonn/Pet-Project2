package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class BankAccountTest {
    BankAccount bankAccount = new BankAccount(0,"ss",0,0,true);
    @Test
    public void testGetID() {
        ReflectionTestUtils.setField(bankAccount, "id", 1);
        Assertions.assertEquals(bankAccount.getId(), 1);
        bankAccount.setId(2);
        bankAccount.setOwnerPersonalAccount(2);
        Assertions.assertEquals(bankAccount.getId(), 2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme