package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

class SwaggerConfigTest {
    SwaggerConfig swaggerConfig = new SwaggerConfig();

    @Test
    void testSwaggerConfiguration() {
        Docket result = swaggerConfig.swaggerConfiguration();
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme