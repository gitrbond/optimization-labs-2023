package ru.sberbank.lab2.jmhjson.utils;

import ru.sberbank.lab2.jmhjson.dto.ComplexDto;
import ru.sberbank.lab2.jmhjson.dto.PlainDto;
import ru.sberbank.lab2.jmhjson.protobuf.ComplexProto;
import ru.sberbank.lab2.jmhjson.protobuf.PlainProto;

import java.util.List;

import static ru.sberbank.lab2.jmhjson.utils.Utils.dtoToJson;
import static ru.sberbank.lab2.jmhjson.utils.Utils.protoToByteArray;

public class TestData {
    public static PlainDto PLAIN_DTO = PlainDto.builder()
            .field1("1")
            .field2(2)
            .field3(3.0)
            .field4(true)
            .build();

    public static PlainProto.PlainDto PLAIN_PROTO = PlainProto.PlainDto.newBuilder()
            .setField1("1")
            .setField2(2)
            .setField3(3.0)
            .setField4(true)
            .build();

    public static String PLAIN_DTO_JSON = dtoToJson(PLAIN_DTO);

    public static byte[] PLAIN_PROTO_BYTES = protoToByteArray(PLAIN_PROTO);

    public static ComplexDto COMPLEX_DTO = ComplexDto.builder()
            .id("id")
            .date("2023-12-20")
            .fio(ComplexDto.User.builder()
                    .firstName("Ivan")
                    .secondName("Ivanov")
                    .thirdName("Ivanovich")
                    .isAClient(true)
                    .build())
            .order(ComplexDto.Order.builder()
                    .id("orderId")
                    .totalPrice(300)
                    .items(List.of(
                            ComplexDto.Order.Item.builder()
                                    .name("cucumbers")
                                    .price(100)
                                    .build(),
                            ComplexDto.Order.Item.builder()
                                    .name("tomatoes")
                                    .price(200)
                                    .build())
                    )
                    .build())
            .discount(0.1)
            .build();

    public static ComplexProto.ComplexDto COMPLEX_PROTO = ComplexProto.ComplexDto.newBuilder()
            .setId("id")
            .setDate("2023-12-20")
            .setFio(ComplexProto.ComplexDto.User.newBuilder()
                    .setFirstName("Ivan")
                    .setSecondName("Ivanov")
                    .setThirdName("Ivanovich")
                    .setIsAClient(true)
                    .build())
            .setOrder(ComplexProto.ComplexDto.Order.newBuilder()
                    .setId("orderId")
                    .setTotalPrice(300)
                    .addItems(0, ComplexProto.ComplexDto.Order.Item.newBuilder()
                            .setName("cucumbers")
                            .setPrice(100)
                            .build())
                    .addItems(1, ComplexProto.ComplexDto.Order.Item.newBuilder()
                            .setName("tomatoes")
                            .setPrice(200)
                            .build())
                    .build())
            .setDiscount(0.1)
            .build();

    public static String COMPLEX_DTO_JSON = dtoToJson(COMPLEX_DTO);

    public static byte[] COMPLEX_PROTO_BYTES = protoToByteArray(COMPLEX_PROTO);
}
