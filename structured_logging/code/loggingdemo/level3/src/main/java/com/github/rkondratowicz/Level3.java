package com.github.rkondratowicz;

import com.github.rkondratowicz.lib.EventLogger;
import com.github.rkondratowicz.lib.EventLoggerFactory;
import com.github.rkondratowicz.logs.EventCatalogue.Audit.MsgReceived;

import java.util.UUID;

public class Level3 {

    private static final EventLogger log = EventLoggerFactory.getLogger(Level3.class);

    public static void main(String[] args) {
        var messageId = UUID.randomUUID().toString();
        var result = "REJECT";

        // Logging starts here.

        log.audit(new MsgReceived(messageId, result));
    }
}
