package ru.sberbank.lab2.jmhjson;

import org.junit.jupiter.api.Test;
import ru.sberbank.lab2.jmhjson.utils.TestData;
import ru.sberbank.lab2.jmhjson.protobuf.ComplexProto;
import ru.sberbank.lab2.jmhjson.protobuf.PlainProto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sberbank.lab2.jmhjson.utils.TestData.COMPLEX_PROTO;
import static ru.sberbank.lab2.jmhjson.utils.TestData.PLAIN_PROTO;

public class ProtobufBenchmarkTest {
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
}
