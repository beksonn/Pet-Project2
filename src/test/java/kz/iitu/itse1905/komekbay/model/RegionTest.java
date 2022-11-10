package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class RegionTest {
    Region region = new Region(1,"name",2,2,3);
    @Test
    public void testGetID() {
        ReflectionTestUtils.setField(region, "id", 1);
        Assertions.assertEquals(region.getId(), 1);
        region.setId(2);
        Assertions.assertEquals(region.getId(), 2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme