package ru.sberbank.lab2.jmhjson;

import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.sberbank.lab2.jmhjson.utils.TestData;
import ru.sberbank.lab2.protobuf.ComplexProto;
import ru.sberbank.lab2.protobuf.PlainProto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProtoSerializeAndDeserialize {
    @Benchmark
    public byte[] protoPlainSerialization() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TestData.PLAIN_PROTO.writeTo(baos);
        return baos.toByteArray();
    }

    @Benchmark
    public PlainProto.PlainDto protoPlainDeserialization() throws InvalidProtocolBufferException {
        return PlainProto.PlainDto.newBuilder()
                .mergeFrom(TestData.PLAIN_PROTO_BYTES).build();
    }

    @Benchmark
    public byte[] protoComplexSerialization() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TestData.COMPLEX_PROTO.writeTo(baos);
        return baos.toByteArray();
    }

    @Benchmark
    public ComplexProto.ComplexDto protoComplexDeserialization() throws InvalidProtocolBufferException {
        return ComplexProto.ComplexDto.newBuilder()
                .mergeFrom(TestData.COMPLEX_PROTO_BYTES).build();
    }

    public static void main(String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder().include(ProtoSerializeAndDeserialize.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .threads(4)
                .forks(1)
                .build();

        new Runner(opt).run();

//        ProtoSerializeAndDeserialize psd = new ProtoSerializeAndDeserialize();
//        psd.protoPlainSerialization();
    }
}
