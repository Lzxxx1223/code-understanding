package com.example.demo.service;

import com.example.demo.dao.SQLProcess;
import com.example.demo.entity.*;
import com.example.demo.model.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
    private static final Integer vin = 1;
public class Process {

    private static Integer vin = 1;

    @Autowired
    private SQLProcess sqlProcess;

    @Autowired
    private InitService initService;

    @Autowired
    private VendorWrite vendorWrite;

    @Autowired
    private ProductWrite productWrite;

    public Response link() {
        Integer pin = sqlProcess.findMaxPin() + 1;

        Concept vinConcept = initService.getConceptSchema().get(EnumType.VENDOR);
        Map<Integer, Attribute> vinAttrMap = vinConcept.getColumns()
                .stream().collect(Collectors.toMap(Attribute::getDcaId, vDCA -> vDCA));

        Concept pinConcept = initService.getConceptSchema().get(EnumType.PRODUCT);
        Map<Integer, Attribute> pinAttrMap = pinConcept.getColumns()
                .stream().collect(Collectors.toMap(Attribute::getDcaId, pDCA -> pDCA));

        Identifier vinIdentifier = vendorWrite.getSt(vinConcept, vin);

        List<Mapping> mappings = initService.getMappings();

        Map<Attribute, String> pinResult = new HashMap<>();
        for (Mapping mapping : mappings) {
            Integer vinDCAId = mapping.getVinDCAId();
            Integer pinDCAId = mapping.getPinDCAId();
            Attribute vinAttr = vinAttrMap.get(vinDCAId);
            Attribute pinAttr = pinAttrMap.get(pinDCAId);
            pinResult.put(pinAttr, vinIdentifier.getAttributeValue().get(vinAttr));
        }

        Identifier pinIdentifier = new Identifier();
        pinIdentifier.setConcept(pinConcept);
        pinIdentifier.setAttributeValue(pinResult);

        String insertSt = productWrite.getInsertStr();
        insertSt = insertSt.replaceFirst("\\?", String.valueOf(pin));
        for (Attribute column : pinConcept.getColumns()) {
            String value = pinIdentifier.getAttributeValue().get(column);
            insertSt = insertSt.replaceFirst("\\?", "'" + value + "'" );
        }
        sqlProcess.insert(insertSt);
        return new Response(pin);
    }
}
