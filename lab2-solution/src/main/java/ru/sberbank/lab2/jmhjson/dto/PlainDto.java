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

    public String toJson() {
        return new StringBuilder().append("{")
                .append("\"field1\":\"").append(field1).append('\"')
                .append(",\"field2\":").append(field2)
                .append(",\"field3\":").append(field3)
                .append(",\"field4\":").append(field4)
                .append('}').toString();
    }
}
