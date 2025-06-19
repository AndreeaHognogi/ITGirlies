package ro.ubbcluj.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("PENDING")
    PENDING,

    @JsonProperty("APPROVED")
    APPROVED,

    @JsonProperty("REJECTED")
    REJECTED;

    // Permite deserializarea din string gol către null
    @JsonCreator
    public static Status fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return Status.valueOf(value.toUpperCase());
    }
}
