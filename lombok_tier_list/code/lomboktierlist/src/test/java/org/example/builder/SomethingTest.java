package org.example.builder;

import org.junit.jupiter.api.Test;

class SomethingTest {

    @Test
    void test() {
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