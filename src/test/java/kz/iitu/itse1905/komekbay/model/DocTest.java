package kz.iitu.itse1905.komekbay.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class DocTest {
    //Field data of type byte[] - was not mocked since Mockito doesn't mock arrays
    Doc doc = new Doc("docName", "docType", new byte[]{(byte) 0});
    Doc doc1 = new Doc();

    @Test
    public void testGetID() {
        ReflectionTestUtils.setField(doc1, "id", 1);

        Assertions.assertEquals(doc1.getId(), 1);
        doc1.setId(2);
        Assertions.assertEquals(doc1.getId(), 2);
    }
    @Test
    public void testGetDocName() {
        ReflectionTestUtils.setField(doc1, "docName", "someDocName");

        Assertions.assertEquals(doc1.getDocName(), "someDocName");
        doc1.setDocName("someDocName2");
        Assertions.assertEquals(doc1.getDocName(), "someDocName2");
    }
    @Test
    public void testGetDocType() {
        ReflectionTestUtils.setField(doc1, "docType", "someDocType");

        Assertions.assertEquals(doc1.getDocType(), "someDocType");
        doc1.setDocType("someDocType2");
        Assertions.assertEquals(doc1.getDocType(), "someDocType2");
    }
    @Test
    void testGetData() {
        byte[] result = doc.getData();
        Assertions.assertArrayEquals(new byte[]{(byte) 0}, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme