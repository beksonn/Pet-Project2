package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class OutputMessageTest {
    OutputMessage outputMessage = new OutputMessage("from","text","time");
    @Test
    public void Test(){
        outputMessage.setFrom("from");
        outputMessage.setText("text");
        outputMessage.setTime("time");

        String resultFrom = outputMessage.getFrom();
        String resultText = outputMessage.getText();
        String resultTime = outputMessage.getTime();

        Assertions.assertEquals("from", resultFrom);
        Assertions.assertEquals("text", resultText);
        Assertions.assertEquals("time", resultTime);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme