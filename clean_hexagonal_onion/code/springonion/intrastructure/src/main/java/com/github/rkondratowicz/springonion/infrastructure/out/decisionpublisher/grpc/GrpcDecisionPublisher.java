package com.github.rkondratowicz.springonion.infrastructure.out.decisionpublisher.grpc;

import com.github.rkondratowicz.springonion.application.model.out.DecisionNotification;
import com.github.rkondratowicz.springonion.application.ports.DecisionPublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GrpcDecisionPublisher implements DecisionPublisher {

    private final NotificationFactory notificationFactory;

    @Override
    public void publish(DecisionNotification notification) {
        Notification msg = notificationFactory.build(notification);
        // ... send message
    }
}
