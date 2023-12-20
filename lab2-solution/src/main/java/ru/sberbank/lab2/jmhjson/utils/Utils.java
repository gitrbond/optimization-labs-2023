package ru.sberbank.lab2.jmhjson.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.AbstractMessageLite;

import java.io.ByteArrayOutputStream;

public class Utils {
    public static <T> String dtoToJson(T dto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            System.out.println("Error while converting dto into String: " + e);
        }
        return null;
    }

    public static <T extends AbstractMessageLite> byte[] protoToByteArray(T proto) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            proto.writeTo(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            System.out.println("Error while converting proto into byte array: " + e);
        }
        return null;
    }
}
