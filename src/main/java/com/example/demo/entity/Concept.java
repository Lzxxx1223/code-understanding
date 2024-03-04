package com.example.demo.entity;

import java.util.List;

public class Concept {

    private EnumType enumType;
    private String name;
    private List<Attribute> columns;

    public EnumType getEnumType() {
        return enumType;
    }

    public void setEnumType(EnumType enumType) {
        this.enumType = enumType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getColumns() {
        return columns;
    }

    public void setColumns(List<Attribute> columns) {
        this.columns = columns;
    }
}
