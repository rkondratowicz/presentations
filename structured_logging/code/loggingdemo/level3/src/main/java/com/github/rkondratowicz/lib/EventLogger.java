package com.github.rkondratowicz.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;

public class EventLogger {

    private static final Logger log = LoggerFactory.getLogger("EventLogger");

    private final String eventSource;
    private final EventRecordHelper helper;

    // region ctor
    public EventLogger(String eventSource, EventRecordHelper helper) {
        this.eventSource = eventSource;
        this.helper = helper;
    }
    // endregion

    public void audit(AuditEvent event) {
        var eventName = helper.getName(event.getClass());
        var fields = helper.getFieldsAsMap(event);
        try {
            MDC.put("event.name", eventName);
            MDC.put("event.source", this.eventSource);
            if (fields != null) {
                fields.forEach((k, v) -> MDC.put("event.properties." + k, v));
            }
            log.info(eventName);
        } finally {
            cleanUpMDC(fields);
        }
    }

    public void error(
        String eventName,
        Map<String, String> params,
        Exception exc
    ) {
        try {
            MDC.put("event.name", eventName);
            MDC.put("event.source", this.eventSource);
            if (params != null) {
                params.forEach((k, v) -> MDC.put("event.properties." + k, v));
            }
            log.error(eventName, exc);
        } finally {
            cleanUpMDC(params);
        }
    }

    private void cleanUpMDC(Map<String, String> params) {
        MDC.remove("event.name");
        MDC.remove("event.source");
        if (params != null) {
            params.forEach((k, v) -> MDC.remove("event.properties." + k));
        }
    }
}
