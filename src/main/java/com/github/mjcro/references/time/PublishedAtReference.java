package com.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface PublishedAtReference {
    Instant getPublishedAt();

    default long getPublishedAtSeconds() {
        return getPublishedAt().getEpochSecond();
    }

    default long getPublishedAtMillis() {
        return getPublishedAt().toEpochMilli();
    }

    default String formatPublishedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getPublishedAt());
    }
}
