package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassTwo {

    private static final Logger log = LoggerFactory.getLogger(ClassTwo.class);

    public void foo() {
        log.info("Foo");
    }
}
