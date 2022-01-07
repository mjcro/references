package com.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface UpdatedAtReference {
    Instant getUpdatedAt();

    default long getUpdatedAtSeconds() {
        return getUpdatedAt().getEpochSecond();
    }

    default long getUpdatedAtMillis() {
        return getUpdatedAt().toEpochMilli();
    }

    default String formatUpdatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getUpdatedAt());
    }
}
