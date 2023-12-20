//package ru.sberbank.lab2.jmhjson;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.RunnerException;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//import ru.sberbank.lab2.jmhjson.dto.ComplexDto;
//import ru.sberbank.lab2.jmhjson.dto.PlainDto;
//import ru.sberbank.lab2.jmhjson.utils.TestData;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.Throughput)
//@State(Scope.Benchmark)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//public class JsonSerializeAndDeserialize {
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Benchmark
//    public String jsonPlainSerialization() throws JsonProcessingException {
//        return objectMapper.writeValueAsString(TestData.PLAIN_DTO);
//    }
//
//    @Benchmark
//    public String jsonComplexSerialization() throws JsonProcessingException {
//        return objectMapper.writeValueAsString(TestData.COMPLEX_DTO);
//    }
//
//    @Benchmark
//    public PlainDto jsonPlainDeserialization() throws IOException {
//        return objectMapper.readValue(TestData.PLAIN_DTO_JSON, PlainDto.class);
//    }
//
//    @Benchmark
//    public ComplexDto jsonComplexDeserialization() throws IOException {
//        return objectMapper.readValue(TestData.COMPLEX_DTO_JSON, ComplexDto.class);
//    }
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder().include(JsonSerializeAndDeserialize.class.getSimpleName())
//                .warmupIterations(10)
//                .measurementIterations(5)
//                .threads(4)
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
//}
