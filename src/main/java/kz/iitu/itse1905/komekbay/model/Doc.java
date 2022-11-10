package kz.iitu.itse1905.komekbay.model;


public class Doc {
    private Integer id;

    private String docName;
    private String docType;
    private byte[] data;


    public Doc(Integer id, String docName, String docType, byte[] data) {
        this.id = id;
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public Doc() {
    }

    public Doc(String docName, String docType, byte[] data) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
    public String getDocType() {
        return docType;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
}
