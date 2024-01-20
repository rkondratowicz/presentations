package com.github.rkondratowicz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Level1 {

    private static final Logger log = LoggerFactory.getLogger(Level1.class);

    public static void main(String[] args) {
        UUID messageId = UUID.randomUUID();
        String result = "REJECT";

        log.info("Message received. Message id: " + messageId + ". Result: " + result);
        log.error("Cannot transform transaction", new RuntimeException("Exception message"));
    }
}