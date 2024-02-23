package com.github.rkondratowicz.springonion.infrastructure.out.decisionpublisher.grpc;

import com.github.rkondratowicz.springonion.application.model.out.DecisionNotification;

public class NotificationFactory {
    public Notification build(DecisionNotification dn) {
        return new Notification();
    }
}
