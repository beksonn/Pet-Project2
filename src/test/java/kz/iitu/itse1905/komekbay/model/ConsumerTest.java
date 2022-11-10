package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Test;

class ConsumerTest {
    Consumer consumer = new Consumer(1,"name","name","name",2,"ss");
    @Test
    public void testSetRegion(){
        consumer.setRegion("name");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme