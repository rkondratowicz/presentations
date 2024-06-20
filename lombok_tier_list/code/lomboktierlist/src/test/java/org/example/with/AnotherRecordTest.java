package org.example.with;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnotherRecordTest {

    @Test
    void test() {
        // given
        var foo = new AnotherRecord(1, "foo");

        // when
        var bar = foo.withName("bar");

        // then
        assertThat(foo).isNotEqualTo(bar);
        assertThat(foo.name()).isEqualTo("foo");
        assertThat(bar.name()).isEqualTo("bar");
    }
}