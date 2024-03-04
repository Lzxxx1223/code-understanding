package com.example.demo.entity;

import java.util.Map;

public class Identifier {

    Concept concept;
    Map<Attribute, String> attributeValue;

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Map<Attribute, String> getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Map<Attribute, String> attributeValue) {
        this.attributeValue = attributeValue;
    }
}
