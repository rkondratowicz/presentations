package com.github.rkondratowicz.springonion.infrastructure.out.decisionpublisher.kafka;

import com.github.rkondratowicz.springonion.application.model.out.DecisionNotification;
import com.github.rkondratowicz.springonion.application.ports.DecisionPublisher;

public class KafkaDecisionPublisher implements DecisionPublisher {
    @Override
    public void publish(DecisionNotification notification) {

    }
}
