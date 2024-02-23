package com.github.rkondratowicz.springonion.application.ports;

import com.github.rkondratowicz.springonion.application.model.out.DecisionNotification;

public interface DecisionPublisher {
    void publish(DecisionNotification notification);
}
