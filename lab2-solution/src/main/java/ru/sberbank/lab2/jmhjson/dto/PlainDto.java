package ru.sberbank.lab2.jmhjson.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlainDto {
    String field1;
    int field2;
    double field3;
    Boolean field4;

//    public String toJson() {
//        return "{" +
//                "\"field1\":\"" + field1 + '\"' +
//                ",\"field2\":" + field2 +
//                ",\"field3\":" + field3 +
//                ",\"field4\":" + field4 +
//                '}';
//    }
}
