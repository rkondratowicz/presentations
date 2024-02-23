package com.github.rkondratowicz.springonion.application;

import com.github.rkondratowicz.domain.RoutingRulesEngine;
import com.github.rkondratowicz.domain.model.Recommendation;
import com.github.rkondratowicz.domain.model.RoutingDecision;
import com.github.rkondratowicz.domain.model.TransactionFact;
import com.github.rkondratowicz.springonion.application.model.in.TxInfo;
import com.github.rkondratowicz.springonion.application.model.out.DecisionNotification;
import com.github.rkondratowicz.springonion.application.ports.DecisionPublisher;
import com.github.rkondratowicz.springonion.application.ports.FooClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TxHandler {

    private final RoutingRulesEngine rulesEngine;
    private final FooClient fooClient;
    private final DecisionPublisher decisionPublisher;

    public void handle(TxInfo tx) {
        Recommendation recommendation = fooClient.screen(tx);

        var fact = new TransactionFact(tx.amount(), recommendation);
        RoutingDecision routingDecision = rulesEngine.getDecision(fact);

        decisionPublisher.publish(
            new DecisionNotification(
                tx.transactionId(),
                routingDecision
            )
        );
    }
}
