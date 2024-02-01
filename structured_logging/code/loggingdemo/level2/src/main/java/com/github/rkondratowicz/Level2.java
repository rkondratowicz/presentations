package com.github.rkondratowicz;

import com.github.rkondratowicz.lib.EventLogger;
import com.github.rkondratowicz.lib.EventLoggerFactory;

import java.util.Map;
import java.util.UUID;

public class Level2 {
    private static final EventLogger log = EventLoggerFactory.getLogger(Level2.class);

    public static void main(String[] args) {
        UUID messageId = UUID.randomUUID();
        String result = "REJECT";

        // Logging starts here.

        log.info(
            "Message received",
            Map.of(
                "message_id", messageId.toString(),
                "result", result
            )
        );
        log.error(
            "Cannot transform transaction",
            Map.of(
                "message_id", messageId.toString()
            ),
            new RuntimeException("Exception message")
        );
    }
}
