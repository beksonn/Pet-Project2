package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class InspectorTest {
    Inspector inspector = new Inspector(1,"name","name","name",2,true);
    @Test
    public void testGetID() {
        ReflectionTestUtils.setField(inspector, "id", 1);
        Assertions.assertEquals(inspector.getRegion(), "name");
        inspector.setId(2);
        Assertions.assertEquals(inspector.getId(), 2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme