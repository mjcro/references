package io.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface CreatedAtReference {
    Instant getCreatedAt();

    default long getCreatedAtSeconds() {
        return getCreatedAt().getEpochSecond();
    }

    default long getCreatedAtMillis() {
        return getCreatedAt().toEpochMilli();
    }

    default String formatCreatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getCreatedAt());
    }
}
