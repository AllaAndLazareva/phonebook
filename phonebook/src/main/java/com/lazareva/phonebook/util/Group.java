package com.lazareva.phonebook.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Group {
    @JsonProperty("A")
    A,
    @JsonProperty("B")
    B,
    @JsonProperty("C")
    C;

    @JsonCreator
    public static Group fromString(String raw) {
        return Group.valueOf(raw.toUpperCase());
    }
}
