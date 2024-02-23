package com.github.rkondratowicz.springonion.infrastructure.out.fooclient;

import com.github.rkondratowicz.domain.model.Recommendation;
import com.github.rkondratowicz.springonion.application.model.in.TxInfo;
import com.github.rkondratowicz.springonion.application.ports.FooClient;

public class RestFooClient implements FooClient {

    @Override
    public Recommendation screen(TxInfo txInfo) {
        return null;
    }
}
