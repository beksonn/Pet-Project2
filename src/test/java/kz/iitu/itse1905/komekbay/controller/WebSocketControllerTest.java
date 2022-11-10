package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Message;
import kz.iitu.itse1905.komekbay.model.OutputMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WebSocketControllerTest {
    WebSocketController webSocketController = new WebSocketController();

    @Test
    void testSend() throws Exception {
        OutputMessage result = webSocketController.send(new Message());
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme