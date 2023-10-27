package com.example.demo.service;

import com.example.demo.dao.SQLProcess;
import com.example.demo.entity.Attribute;
import com.example.demo.entity.Concept;
import com.example.demo.entity.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendorWrite {

    @Autowired
    private SQLProcess sqlProcess;

    public Identifier getSt(Concept concept, Integer vin) {
        Identifier identifier = new Identifier();
        Map<Attribute, String> map = new HashMap<>();
        String sql = "select * from " +
                concept.getEnumType().getTableName() + " where vin=" +
                vin;
        Map<String, Object> result = sqlProcess.select(sql).get(0);
        concept.getColumns().forEach(c -> {
            map.put(c, String.valueOf(result.get(c.getFieldName())));
        });
        identifier.setAttributeValue(map);
        return identifier;
    }

}
