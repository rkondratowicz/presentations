package org.example.builder;

public class Usage {
    public void usage() {
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
