package org.example.builder;

import lombok.Builder;

@Builder
public record Something(
    String name,
    String type,
    String kind,
    String postCode,
    String whatever
) {
}
