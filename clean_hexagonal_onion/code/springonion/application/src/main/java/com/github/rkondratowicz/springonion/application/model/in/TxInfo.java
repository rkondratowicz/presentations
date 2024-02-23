package com.github.rkondratowicz.springonion.application.model.in;

public record TxInfo(
    String transactionId,
    long amount
) {
}
