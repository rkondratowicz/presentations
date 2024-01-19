package com.github.rkondratowicz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Level1 {

    private static final Logger log = LoggerFactory.getLogger(Level1.class);

    public static void main(String[] args) {
        log.info("Hello world");
        log.error("Oh noes!");
    }
}