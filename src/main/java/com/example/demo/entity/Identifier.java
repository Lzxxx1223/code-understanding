package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Identifier {

    Concept concept;
    Map<Attribute, String> attributeValue;
}
