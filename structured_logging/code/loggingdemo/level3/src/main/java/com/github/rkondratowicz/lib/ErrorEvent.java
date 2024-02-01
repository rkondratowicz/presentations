package com.github.rkondratowicz.lib;

public interface ErrorEvent extends Event {
    Exception exc();
}
