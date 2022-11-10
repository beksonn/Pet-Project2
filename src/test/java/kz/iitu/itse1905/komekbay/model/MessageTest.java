package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class MessageTest {
    Message message = new Message();
    @Test
    public void testGetFrom(){
        message.setFrom("form");
        String result = message.getFrom();
        Assertions.assertEquals("form", result);
        message.setText("text");
        String results = message.getText();
        Assertions.assertEquals("text", results);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme