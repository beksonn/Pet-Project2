package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Doc;
import kz.iitu.itse1905.komekbay.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DocControllerTest {
    @Mock
    Service service;
    @InjectMocks
    DocController docController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGet() {
        when(service.getFiles()).thenReturn(Arrays.<Doc>asList(new Doc(Integer.valueOf(0), "docName", "docType", new byte[]{(byte) 0})));

        List<Doc> result = docController.get(null);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUploadMultipleFiles() {
        String result = docController.uploadMultipleFiles(new MultipartFile[]{null});
        Assertions.assertEquals("1 Files Uploaded", result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme