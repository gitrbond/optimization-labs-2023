package ru.sberbank.lab2.jmhjson;

import org.junit.jupiter.api.Test;
import ru.sberbank.lab2.jmhjson.utils.TestData;
import ru.sberbank.lab2.protobuf.ComplexProto;
import ru.sberbank.lab2.protobuf.PlainProto;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sberbank.lab2.jmhjson.utils.TestData.*;

public class ProtoSerializeAndDeserializeTest {
//    OutputStream output = new OutputStream() {
//        private StringBuilder string = new StringBuilder();
//
//        @Override
//        public void write(int b) throws IOException {
//            this.string.append((char) b );
//        }
//
//        public String toString() {
//            return this.string.toString();
//        }
//    };

    @Test
    void protoPlainSerializeAndDeserializeTest() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PLAIN_PROTO.writeTo(baos);
        byte[] dataBytes = baos.toByteArray();
        PlainProto.PlainDto proto = PlainProto.PlainDto.newBuilder()
                .mergeFrom(dataBytes).build();
        assertEquals(PLAIN_PROTO, proto);
    }

    @Test
    void protoComplexSerializeAndDeserializeTest() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TestData.COMPLEX_PROTO.writeTo(baos);
        byte[] dataBytes = baos.toByteArray();
        ComplexProto.ComplexDto proto = ComplexProto.ComplexDto.newBuilder()
                .mergeFrom(dataBytes).build();
        assertEquals(COMPLEX_PROTO, proto);
    }

//    @Test
//    void jsonComplexSerializeAndDeserializeTest() throws IOException {
//        String json = objectMapper.writeValueAsString(COMPLEX_DTO);
//        ComplexDto dto = objectMapper.readValue(json, ComplexDto.class);
//        assertEquals(COMPLEX_DTO, dto);
//    }

}
