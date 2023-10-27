package com.example.demo.service;

import com.example.demo.dao.SQLProcess;
import com.example.demo.entity.Attribute;
import com.example.demo.entity.Concept;
import com.example.demo.entity.EnumType;
import com.example.demo.model.DC;
import com.example.demo.model.DCA;
import com.example.demo.model.Mapping;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Getter
public class InitService {

    private final Map<EnumType, Concept> conceptSchema = new HashMap<>();
    private List<Mapping> mappings;

    @Autowired
    private SQLProcess sqlProcess;

    @Autowired
    private ProductWrite productWrite;

    @PostConstruct
    public void init() {
        mappings = sqlProcess.selectMapping();
        loadSchema(EnumType.VENDOR);
        loadSchema(EnumType.PRODUCT);
    }

    private void loadSchema(EnumType enumType) {
        Concept concept = new Concept();
        concept.setEnumType(enumType);
        DC dc = sqlProcess.selectDCByDCTable(enumType.getTableName());
        List<DCA> dcaList = sqlProcess.selectDCAByDCId(dc.getDcId());
        concept.setName(dc.getName());
        List<Attribute> attributes = dcaList.stream()
                .map(dca -> new Attribute(dca.getDcaId(), dca.getField(), dca.getName()))
                .collect(Collectors.toList());
        concept.setColumns(attributes);
        conceptSchema.put(enumType, concept);
        if (enumType == EnumType.PRODUCT) {
            productWrite.insertSt(concept);
        }
    }
}
