package io.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public interface CreatedAtReference {
    /**
     * @return Entity creation time.
     */
    Instant getCreatedAt();

    /**
     * @return Entity creation time as unix (epoch) seconds.
     */
    default long getCreatedAtSeconds() {
        return getCreatedAt().getEpochSecond();
    }

    /**
     * @return Entity creation time as unix (epoch) milliseconds.
     */
    default long getCreatedAtMillis() {
        return getCreatedAt().toEpochMilli();
    }

    /**
     * @return Entity creation time in ISO_INSTANT string representation.
     */
    default String formatCreatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getCreatedAt());
    }

    /**
     * Compares creation time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareCreatedAtTo(Instant other) {
        return other == null
                ? -1
                : other.compareTo(getCreatedAt());
    }

    /**
     * Compares creation time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareCreatedAtTo(Supplier<Instant> other) {
        return other == null
                ? -1
                : compareCreatedAtTo(other.get());
    }

    /**
     * Compares creation time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareCreatedAtTo(CreatedAtReference other) {
        return other == null
                ? -1
                : compareCreatedAtTo(other.getCreatedAt());
    }
}
