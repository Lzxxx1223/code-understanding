package com.example.demo.entity;

public enum EnumType {

    PRODUCT("product.dc", "pin"),
    VENDOR("vendor.dc", "vin");

    private final String tableName;
    private final String fieldName;

    EnumType(String tableName, String fieldName) {
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
