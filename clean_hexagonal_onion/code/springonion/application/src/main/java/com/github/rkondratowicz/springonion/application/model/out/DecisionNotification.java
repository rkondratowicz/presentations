package com.github.rkondratowicz.springonion.application.model.out;

import com.github.rkondratowicz.domain.model.RoutingDecision;

public record DecisionNotification(
    String txId,
    RoutingDecision decision
) {
}
