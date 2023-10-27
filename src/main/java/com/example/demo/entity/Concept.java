package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Concept {

    private EnumType enumType;
    private String name;
    private List<Attribute> columns;

}
