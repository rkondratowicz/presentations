package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassOne {

    private static final Logger log = LoggerFactory.getLogger(ClassOne.class);

    public void foo() {
        log.info("Hi");
    }
}
