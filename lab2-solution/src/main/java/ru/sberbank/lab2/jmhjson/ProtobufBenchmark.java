package ru.sberbank.lab2.jmhjson;

import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.*;
import ru.sberbank.lab2.jmhjson.utils.TestData;
import ru.sberbank.lab2.jmhjson.protobuf.ComplexProto;
import ru.sberbank.lab2.jmhjson.protobuf.PlainProto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ProtobufBenchmark {
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

//    public static void main(String[] args) throws IOException, RunnerException {
//        Options opt = new OptionsBuilder().include(ProtoSerializeAndDeserialize.class.getSimpleName())
//                .warmupIterations(5)
//                .measurementIterations(5)
//                .threads(4)
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
}
