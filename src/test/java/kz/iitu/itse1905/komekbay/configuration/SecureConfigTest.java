package kz.iitu.itse1905.komekbay.configuration;

import kz.iitu.itse1905.komekbay.security.EntryPoint;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.accept.ContentNegotiationStrategy;

import javax.sql.DataSource;

import java.util.Map;

import static org.mockito.Mockito.*;

class SecureConfigTest {
    @Mock
    DataSource dataSource;
    @Mock
    EntryPoint entryPoint;
    @Mock
    Log logger;
    @Mock
    ApplicationContext context;
    @Mock
    ContentNegotiationStrategy contentNegotiationStrategy;
    @Mock
    ObjectPostProcessor<Object> objectPostProcessor;
    @Mock
    AuthenticationConfiguration authenticationConfiguration;
    @Mock
    AuthenticationManagerBuilder authenticationBuilder;
    @Mock
    AuthenticationManagerBuilder localConfigureAuthenticationBldr;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    Map<Class<?>,Object> sharedObjects;
    @Mock
    AuthenticationTrustResolver trustResolver;
    //Field http of type HttpSecurity - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    SecureConfig secureConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testConfigureGlobal() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        secureConfig.configureGlobal(authenticationManagerBuilder);
    }

    @Test
    void testPasswordEncoder() {
        PasswordEncoder result = secureConfig.passwordEncoder();
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme