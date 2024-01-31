package com.github.rkondratowicz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

public class Level2 {
    private static final Logger log = LoggerFactory.getLogger(Level2.class);

    public static void main(String[] args) {
        UUID messageId = UUID.randomUUID();
        String result = "REJECT";

        log.info(
            "Message received",
            Map.of(
                "message_id", messageId,
                "result", result
            )
        );
        log.error(
            "Cannot transform transaction",
            Map.of(
                "message_id", messageId
            ),
            new RuntimeException("Exception message")
        );
    }
}
