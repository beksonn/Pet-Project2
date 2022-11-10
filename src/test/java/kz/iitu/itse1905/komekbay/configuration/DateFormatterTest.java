package kz.iitu.itse1905.komekbay.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.format.support.FormattingConversionService;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

class DateFormatterTest {
    DateFormatter dateFormatter = new DateFormatter();

    @Mock
    Locale locale = new Locale("ua");

    @Test
    void testPrint() {
        String result = dateFormatter.print(new GregorianCalendar(2022, Calendar.JUNE, 3, 18, 55).getTime(), locale);
        Assertions.assertEquals("20220603", result);

        String resultNull = dateFormatter.print(null, locale);
        Assertions.assertEquals("", resultNull);
    }

    @Test
    void testParse() throws ParseException {
        Date result = dateFormatter.parse("20220603", locale);
        Date resultNull = dateFormatter.parse("", locale);
        Assertions.assertEquals(new GregorianCalendar(2022, Calendar.JUNE, 3, 0, 0).getTime(), result);
        Assertions.assertNull(resultNull);
    }

    @Test
    void testGetDateFormat() {
        DateFormat result = dateFormatter.getDateFormat(locale);
        Assertions.assertNotNull( result);
    }

    @Test
    void testConversionService() {
        FormattingConversionService result = dateFormatter.conversionService();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme