# Лабораторная работа 2 по Оптимизации программ. Роман Бондарь

В работе исследованы два подхода к сериализации и десериализации объектов в Java: 
при помощи библиотек *com.fasterxml.jackson.dataformat* и *com.google.protobuf*.

Jackson умеет переводить объекты (java-классы) в строку с json-представлением данного объекта и обратно. Json-схема наследуется из структуры класса, с возможностью конфигурировать ее аннотациями.

Protobuf, в отличие от Jackson-а, сериализует в поток байт (не-человекочитаемый формат), и вычитывает из него же. Схема полей описывается файлом с расширением .proto, из которого protoc компилирует соответствующий класс с готовыми методами сериализации / десериализации согласно схеме. 

Для бенчмарков использовались 2 класса: PlainDto и ComplexDto. Первый содержит 4 примитивных поля, второй - три уровня вложенных сущностей с 11 различными полями.

Результаты бенчмарков:
```
Benchmark                                            Mode  Cnt        Score         Error  Units
JacksonBenchmark.jsonComplexDeserialization         thrpt    5   222947,496 ±   77396,812  ops/s
JacksonBenchmark.jsonComplexSerialization           thrpt    5   435477,882 ±  167275,397  ops/s
JacksonBenchmark.jsonPlainDeserialization           thrpt    5   764861,245 ±  478441,517  ops/s
JacksonBenchmark.jsonPlainSerialization             thrpt    5  1267884,835 ±  187966,055  ops/s
ProtobufBenchmark.protoComplexDeserialization       thrpt    5   679061,660 ±  324656,210  ops/s
ProtobufBenchmark.protoComplexSerialization         thrpt    5  1240064,595 ±  867404,567  ops/s
ProtobufBenchmark.protoPlainDeserialization         thrpt    5  5024188,182 ± 1767836,637  ops/s
ProtobufBenchmark.protoPlainSerialization           thrpt    5  4949010,706 ± 1784612,713  ops/s

Benchmark                           Acceleration (times protobuf faster than jackson)
ComplexDeserialization              3,05
ComplexSerialization                2,85
PlainDeserialization                6,58
PlainSerialization                  3,92
```

Из результатов видно, что в каждом из вариантов protobuf быстрее jackson-а, ускорение разнится от 3 до 6,5. Причем в среднем при работе с простыми объектами protobuf показывает себя лучше. Это, конечно, качественные тесты, но они показывают разницу между двумя подходами. 

Среди причин, почему protobuf быстрее:
* Protobuf компилируется в класс, работающий с конкретной схемой, в результате чего можно избежать разбора схемы налету.
* Protobuf был разработан Google и написан с упором на оптимизацию взамен удобности и гибкости, и затем выложен в открытый доступ.
* Protobuf работает с потоком байт, а JSON - со String, что добавляет дополнительный оверхед. Размер сериализованных объектов также выше у protobuf.
