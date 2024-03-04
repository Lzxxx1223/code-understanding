package com.example.demo.service;

import com.example.demo.entity.Attribute;
import com.example.demo.entity.Concept;
import org.springframework.stereotype.Service;

@Service
public class ProductWrite {

    private String insertStr;

    public void insertSt(Concept concept) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ")
                .append(concept.getEnumType().getTableName()).append(" (")
                .append(concept.getEnumType().getFieldName());

        int attrNum = 0;
        for (Attribute column : concept.getColumns()) {
            attrNum++;
            stringBuilder.append(",").append(column.getFieldName());
        }

        stringBuilder.append(") values (?");
        for (int i = 0; i < attrNum; i++) {
            stringBuilder.append(",").append("?");
        }
        stringBuilder.append(")");
        insertStr = stringBuilder.toString();
    }

    public String getInsertStr() {
        return insertStr;
    }
}
