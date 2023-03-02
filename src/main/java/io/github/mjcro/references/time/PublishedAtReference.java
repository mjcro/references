package io.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public interface PublishedAtReference {
    /**
     * @return Entity publishing time.
     */
    Instant getPublishedAt();

    /**
     * @return Entity publishing time as unix (epoch) seconds.
     */
    default long getPublishedAtSeconds() {
        return getPublishedAt().getEpochSecond();
    }

    /**
     * @return Entity publishing time as unix (epoch) milliseconds.
     */
    default long getPublishedAtMillis() {
        return getPublishedAt().toEpochMilli();
    }

    /**
     * @return Entity publishing time in ISO_INSTANT string representation.
     */
    default String formatPublishedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getPublishedAt());
    }

    /**
     * Compares publishing time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int comparePublishedAtTo(Instant other) {
        return other == null
                ? -1
                : other.compareTo(getPublishedAt());
    }

    /**
     * Compares publishing time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int comparePublishedAtTo(Supplier<Instant> other) {
        return other == null
                ? -1
                : comparePublishedAtTo(other.get());
    }

    /**
     * Compares publishing time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int comparePublishedAtTo(PublishedAtReference other) {
        return other == null
                ? -1
                : comparePublishedAtTo(other.getPublishedAt());
    }
}
