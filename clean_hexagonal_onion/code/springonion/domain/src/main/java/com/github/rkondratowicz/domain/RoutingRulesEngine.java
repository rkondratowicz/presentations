package com.github.rkondratowicz.domain;

import com.github.rkondratowicz.domain.model.RoutingDecision;
import com.github.rkondratowicz.domain.model.TransactionFact;

import static com.github.rkondratowicz.domain.model.Recommendation.A;
import static com.github.rkondratowicz.domain.model.Recommendation.B;
import static com.github.rkondratowicz.domain.model.RoutingDecision.*;

public class RoutingRulesEngine {

    public RoutingDecision getDecision(TransactionFact fact) {
        if (fact.recommendation() == A) {
            return PASS;
        } else if (fact.amount() > 1_000_000 && fact.recommendation() == B) {
            return FAIL;
        } else {
            return INVESTIGATE;
        }
    }
}
