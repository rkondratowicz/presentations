package com.github.rkondratowicz.springonion.application.ports;

import com.github.rkondratowicz.domain.model.Recommendation;
import com.github.rkondratowicz.springonion.application.model.in.TxInfo;

public interface FooClient {
    Recommendation screen(TxInfo txInfo);
}
