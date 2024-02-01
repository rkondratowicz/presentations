package com.github.rkondratowicz.logs;

import com.github.rkondratowicz.lib.AuditEvent;
import com.github.rkondratowicz.lib.Named;

public class EventCatalogue {

    public class Audit {

        /**
         * Documentation for this audit event.
         *
         * @param messageId documentation for this field
         * @param result    documentation for this field
         */
        @Named("MESSAGE_RECEIVED")
        public record MsgReceived(
            String messageId,
            String result
        ) implements AuditEvent {
        }

        /**
         * Documentation goes here.
         */
        public record SomeOtherAuditEvent() implements AuditEvent {

        }
    }

    public class Error {

    }
}
