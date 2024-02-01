package com.github.rkondratowicz;

import com.github.rkondratowicz.lib.EventLogger;
import com.github.rkondratowicz.lib.EventLoggerFactory;

import java.util.Map;
import java.util.UUID;

public class Level2 {
    private static final EventLogger log = EventLoggerFactory.getLogger(Level2.class);

    public static void main(String[] args) {
        var messageId = UUID.randomUUID().toString();
        var result = "REJECT";

        // Logging starts here.

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
