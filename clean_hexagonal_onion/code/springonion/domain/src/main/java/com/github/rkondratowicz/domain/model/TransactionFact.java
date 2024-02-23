package com.github.rkondratowicz.domain.model;

public record TransactionFact(
    long amount,
    Recommendation recommendation
) {
}
