package com.github.rkondratowicz.lib;

import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class EventRecordHelper {

    public String getName(Class<?> clazz) {
        return clazz.isAnnotationPresent(Named.class)
            ? clazz.getAnnotation(Named.class).value()
            : clazz.getSimpleName();
    }

    public Map<String, String> getFieldsAsMap(Event event) {
        return Arrays
            .stream(event.getClass().getRecordComponents())
            .collect(toMap(rc -> rc.getName(), rc -> getValue(event, rc)));
    }

    private String getValue(Event event, RecordComponent rc) {
        try {
            return rc.getAccessor().invoke(event).toString();
        } catch (Exception exc) {
            // in case invoking a getter fails... (shouldn't happen on records)
            return "N/A";
        }
    }
}
