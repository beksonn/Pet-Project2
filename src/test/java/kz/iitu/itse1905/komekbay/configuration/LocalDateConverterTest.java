package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class LocalDateConverterTest {
    LocalDateConverter localDateConverter = new LocalDateConverter();

    @Test
    void testConvert() {
        LocalDate result = localDateConverter.convert("06-03-2022");
        LocalDate resultNull = localDateConverter.convert(null);
        Assertions.assertEquals(LocalDate.of(2022, Month.JUNE, 3), result);
        Assertions.assertNull(resultNull);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme