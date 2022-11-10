package kz.iitu.itse1905.komekbay.security;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.core.AuthenticationException;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

class EntryPointTest {
    EntryPoint entryPoint = new EntryPoint();
    @Mock
    HttpServletRequest httpServletRequest;

    @Test
    void testAfterPropertiesSet() {
        entryPoint.afterPropertiesSet();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme