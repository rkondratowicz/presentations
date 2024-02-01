package com.github.rkondratowicz.lib;

public class EventLoggerFactory {
    public static EventLogger getLogger(Class<?> clazz) {
        return new EventLogger(clazz.getName(), new EventRecordHelper());
    }
}
