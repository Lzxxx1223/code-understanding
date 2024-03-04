package com.example.demo.entity;

public class Attribute {

    private Integer dcaId;
    private String fieldName;
    private String name;

    public Attribute(Integer dcaId, String fieldName, String name) {
        this.dcaId = dcaId;
        this.fieldName = fieldName;
        this.name = name;
    }

    public Integer getDcaId() {
        return dcaId;
    }

    public void setDcaId(Integer dcaId) {
        this.dcaId = dcaId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
