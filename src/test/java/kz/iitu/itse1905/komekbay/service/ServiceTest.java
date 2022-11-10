package kz.iitu.itse1905.komekbay.service;

import kz.iitu.itse1905.komekbay.model.*;
import kz.iitu.itse1905.komekbay.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ServiceTest {
    @Mock
    ConsumerRepository consumerRepository;
    @Mock
    RegionRepository regionRepository;
    @Mock
    DocRepository docRepository;
    @Mock
    BankAccountRepository bankAccountRepository;
    @Mock
    InspectorRepository inspectorRepository;
    @Mock
    MessageReciever messageReciever;
    @Mock
    MessageSender messageSender;
    @InjectMocks
    Service service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListAllConsumer() {
        when(consumerRepository.listAllConsumers()).thenReturn(Arrays.<Consumer>asList(new Consumer(0, "firstName", "lastName", "address", 0f, "region")));

        List<Consumer> result = service.listAllConsumer();
        Assertions.assertNotNull( result);
    }

    @Test
    void testCreateConsumer() {
        List<Consumer> consumers = Arrays.<Consumer>asList(new Consumer(0, "firstName", "lastName", null, 0f, "region"));
        when(consumerRepository.listAllConsumers()).thenReturn(consumers);
        when(consumerRepository.createConsumer(any())).thenReturn("createConsumerResponse");
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));
        when(bankAccountRepository.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, "BexultanKomekbay", 0, 0f, true)));

        String result = service.createConsumer(new Consumer(0, "firstName", "lastName", null, 0f, "region"));
        String result2 = service.createConsumer(new Consumer(0, "firstName", "lastName", null, 0f, "name"));
        String result3 = service.createConsumer(new Consumer(0, "Bexultan", "Komekbay", null, 0f, "name"));
        Assertions.assertEquals("There is no like this Region", result);
        Assertions.assertEquals("This consumer already exists", result2);
        Assertions.assertEquals("createConsumerResponse", result3);
    }

    @Test
    void testUpdateConsumerById() {
        when(consumerRepository.updateConsumerById(any(), anyInt())).thenReturn("updateConsumerByIdResponse");
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        String result = service.updateConsumerById(new Consumer(0, null, null, null, 0f, "region"), 0);
        String result2 = service.updateConsumerById(new Consumer(0, null, null, null, 0f, "name"), 0);
        Assertions.assertEquals("There is no like this Region", result);
        Assertions.assertEquals("updateConsumerByIdResponse", result2);
    }

    @Test
    void testDeleteConsumerByPersonalAccount() {
        when(consumerRepository.deleteConsumerByPersonalAccount(anyInt())).thenReturn("deleteConsumerByPersonalAccountResponse");

        String result = service.deleteConsumerByPersonalAccount(0);
        Assertions.assertEquals("deleteConsumerByPersonalAccountResponse", result);
    }

    @Test
    void testListConsumerByRegion(){
        when(consumerRepository.listAllConsumers()).thenReturn(Arrays.<Consumer>asList(new Consumer(0, null, null, null, 0f, "name")));
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(1, "name", 0f, 0f, 0f)));
        List<Consumer> result = service.listConsumerByRegion(1);
        Assertions.assertNotNull( result);

    }


    @Test
    void testMakeBillToConsumerByPersonalAccount() {
        when(consumerRepository.listAllConsumers()).thenReturn(Arrays.<Consumer>asList(new Consumer(0, null, null, null, 0f, "name")));
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));
        when(bankAccountRepository.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, null, 0, 0f, true)));
        when(bankAccountRepository.fillDownAfterPayment(any(), anyFloat(), anyBoolean())).thenReturn("fillDownAfterPaymentResponse");

        String result = service.makeBillToConsumerByPersonalAccount(0, 0f, "checkOrPay");
        String result2 = service.makeBillToConsumerByPersonalAccount(0, 0f, "check");

        String result3 = service.makeBillToConsumerByPersonalAccount(0, 0f, "pay");
        String result4 = service.makeBillToConsumerByPersonalAccount(0, 320, "check");
        String result5 = service.makeBillToConsumerByPersonalAccount(0, 500, "check");
        Assertions.assertEquals("You must write 'check' or 'pay' after personalAccount and meterReading", result);
        Assertions.assertEquals("For payment: 0.0", result2);
        Assertions.assertEquals("fillDownAfterPaymentResponse", result3);
        Assertions.assertEquals("For payment: 0.0", result4);
        Assertions.assertEquals("For payment: 0.0", result5);
    }

    @Test
    void testListAllRegion() {
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        List<Region> result = service.listAllRegion();
        Assertions.assertNotNull( result);
    }

    @Test
    void testCreateRegion() {
        when(regionRepository.listAllRegion()).thenReturn(Arrays.<Region>asList(new Region(0, "name", 0f, 0f, 0f)));

        String result = service.createRegion(new Region(0, "name", 0f, 0f, 0f));
        String result2 = service.createRegion(new Region(1, "names", 0f, 0f, 0f));
        Assertions.assertEquals("This region already exists", result);
        Assertions.assertNull(result2);
    }



    @Test
    void testGetFile() {
        when(docRepository.listAllDocs()).thenReturn(Arrays.<Doc>asList(new Doc(Integer.valueOf(0), null, null, null)));

        Doc result = service.getFile(Integer.valueOf(0));
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetFiles() {
        when(docRepository.listAllDocs()).thenReturn(Arrays.<Doc>asList(new Doc(Integer.valueOf(0), "docName", "docType", new byte[]{(byte) 0})));

        List<Doc> result = service.getFiles();
        Assertions.assertNotNull( result);
    }

    @Test
    void testListAllBankAccount() {
        when(bankAccountRepository.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, "ownerFullName", 0, 0f, true)));

        List<BankAccount> result = service.listAllBankAccount();
        Assertions.assertNotNull( result);
    }

    @Test
    void testFillUpAccount() {
        when(bankAccountRepository.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, null, 0, 0f, true)));
        when(bankAccountRepository.fillUpAccount(any(), anyFloat())).thenReturn("fillUpAccountResponse");

        String result = service.fillUpAccount(0, 0f);
        Assertions.assertEquals("fillUpAccountResponse", result);
    }

    @Test
    void testListAllInspector() {
        when(inspectorRepository.listAllInspectors()).thenReturn(Arrays.<Inspector>asList(new Inspector(0, "firstName", "lastName", "region", 0, true)));

        List<Inspector> result = service.listAllInspector();
        Assertions.assertNotNull(result);
    }

    @Test
    void testCallInspector() {
        when(inspectorRepository.listAllInspectors()).thenReturn(Arrays.<Inspector>asList(new Inspector(0, null, null, null, 0, true)));

        String result = service.callInspector(0);
        Assertions.assertEquals("Inspector accepted, work will done after pay", result);
    }

    @Test
    void testPayInspector() {
        when(bankAccountRepository.listAllBankAccount()).thenReturn(Arrays.<BankAccount>asList(new BankAccount(0, null, 0, 0f, true)));
        when(bankAccountRepository.fillDownAfterPayment(any(), anyFloat(), anyBoolean())).thenReturn("fillDownAfterPaymentResponse");
        when(inspectorRepository.listAllInspectors()).thenReturn(Arrays.<Inspector>asList(new Inspector(0, null, null, null, 0, true)));
        when(messageReciever.messageInQueue()).thenReturn(Integer.valueOf(0));

        String result = service.payInspector(0, 0, "pay");
        String result2 = service.payInspector(0, 0, "check");
        Assertions.assertEquals("0 you paid service", result);
        Assertions.assertEquals("0 for payment", result2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme