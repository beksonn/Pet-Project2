package kz.iitu.itse1905.komekbay.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageRecieverTest {
    MessageReciever messageReciever = new MessageReciever();

    @Test
    void testReceiveMessage() {
        messageReciever.receiveMessage(Integer.valueOf(0));
    }

    @Test
    void testMessageInQueue() {
        Integer result = messageReciever.messageInQueue();
        Assertions.assertNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme