package com.example.demo.entity;

public class Response {

    private Integer productId;

    public Response(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
