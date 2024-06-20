package org.example.builder;

public class Main {
    public static void main(String[] args) {
        var sth = Something
            .builder()
            .type("x")
            .kind("y")
            .name("hi")
            .postCode("1234")
            .whatever("yo")
            .build();
    }
}
