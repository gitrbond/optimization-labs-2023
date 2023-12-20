package ru.sberbank.lab2.jmhjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.sberbank.lab2.jmhjson.dto.ComplexDto;
import ru.sberbank.lab2.jmhjson.dto.PlainDto;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sberbank.lab2.jmhjson.utils.TestData.COMPLEX_DTO;
import static ru.sberbank.lab2.jmhjson.utils.TestData.PLAIN_DTO;

public class JsonSerializeAndDeserializeTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonPlainSerializeAndDeserializeTest() throws IOException {
        String json = objectMapper.writeValueAsString(PLAIN_DTO);
        PlainDto dto = objectMapper.readValue(json, PlainDto.class);
        assertEquals(PLAIN_DTO, dto);
    }

    @Test
    void jsonComplexSerializeAndDeserializeTest() throws IOException {
        String json = objectMapper.writeValueAsString(COMPLEX_DTO);
        ComplexDto dto = objectMapper.readValue(json, ComplexDto.class);
        assertEquals(COMPLEX_DTO, dto);
    }

//    @Test
//    void jsonPlainSerializationTest() throws JsonProcessingException {
//        String expected = PLAIN_DTO.toJson();
//        String actual = jsd.jsonPlainSerialization();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void jsonComplexSerializationTest() throws JsonProcessingException {
//        String expected = COMPLEX_DTO.toJson();
////        System.out.println("exp = " + expected);
//        String actual = jsd.jsonComplexSerialization();
////        System.out.println("act = " + actual);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void jsonPlainDeserializationTest() throws IOException {
//        PlainDto actual = jsd.jsonPlainDeserialization();
//        assertEquals(PLAIN_DTO, actual);
//    }
//
//    @Test
//    void jsonComplexDeserializationTest() throws IOException {
//        ComplexDto actual = jsd.jsonComplexDeserialization();
//        assertEquals(COMPLEX_DTO, actual);
//    }
}
