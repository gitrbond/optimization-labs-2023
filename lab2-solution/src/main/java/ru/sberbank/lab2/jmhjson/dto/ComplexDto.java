package ru.sberbank.lab2.jmhjson.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComplexDto {
    String id;
    String date;
    User fio;
    Order order;
    double discount;

    @Data // necessary annotation for jackson
    @Builder
    public static class User {
        String firstName;
        //        @JsonProperty("2nd name")
        String secondName;
        String thirdName;
        // not boolean, otherwise duplicates
        Boolean isAClient;

//        public String toJson() {
//            return "{" +
//                    "\"firstName\":\"" + firstName + '\"' +
//                    ",\"secondName\":\"" + secondName + '\"' +
//                    ",\"thirdName\":\"" + thirdName + '\"' +
//                    ",\"isAClient\":" + isAClient +
//                    '}';
//        }
    }

    @Data
    @Builder
    public static class Order {
        String id;
        long totalPrice;
        List<Item> items;

        @Data
        @Builder
        public static class Item {
            String name;
            long price;

//            public String toJson() {
//                return "{" +
//                        "\"name\":\"" + name + '\"' +
//                        ",\"price\":" + price +
//                        '}';
//            }
        }

//        public String toJson() {
//            return "{" +
//                    "\"id\":\"" + id + '\"' +
//                    ",\"totalPrice\":" + totalPrice +
//                    ",\"items\":[" + items.stream().map(Item::toJson).collect(Collectors.joining(",")) + ']' +
//                    '}';
//        }
    }

//    public String toJson() {
//        return "{" +
//                "\"id\":\"" + id + '\"' +
//                ",\"date\":\"" + date + '\"' +
//                ",\"fio\":" + fio.toJson() +
//                ",\"order\":" + order.toJson() +
//                ",\"discount\":" + discount +
//                '}';
//    }
}
