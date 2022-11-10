package kz.iitu.itse1905.komekbay.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.security.web.RedirectStrategy;

import static org.mockito.Mockito.*;

class CustomAuthenticationFailureHandlerTest {
    @Mock
    ObjectMapper objectMapper;
    @Mock
    MessageSource messages;
    @Mock
    Log logger;
    @Mock
    RedirectStrategy redirectStrategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testOnAuthenticationFailure() {
//        customAuthenticationFailureHandler.onAuthenticationFailure(null, null, null);
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme