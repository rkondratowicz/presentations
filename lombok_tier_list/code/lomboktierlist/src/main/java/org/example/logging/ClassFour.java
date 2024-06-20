package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassFour {

    private static final Logger log = LoggerFactory.getLogger(ClassThree.class);

    public void foo() {
        log.info("Hello");
    }
}
