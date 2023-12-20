package ru.sberbank.lab2.jmhjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openjdk.jmh.annotations.*;
import ru.sberbank.lab2.jmhjson.utils.TestData;

import java.util.concurrent.TimeUnit;

// тестирование самописного метода .toJson()
@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 10)
@Measurement(iterations = 7)
@OutputTimeUnit(TimeUnit.SECONDS)
public class CustomJsonBenchmark {
    @Benchmark
    public String customJsonPlainSerialization() {
        return TestData.PLAIN_DTO.toJson();
    }

    @Benchmark
    public String customJsonComplexSerialization() {
        return TestData.COMPLEX_DTO.toJson();
    }
}
