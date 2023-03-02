package io.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public interface UpdatedAtReference {
    /**
     * @return Entity update time.
     */
    Instant getUpdatedAt();

    /**
     * @return Entity update time as unix (epoch) seconds.
     */
    default long getUpdatedAtSeconds() {
        return getUpdatedAt().getEpochSecond();
    }

    /**
     * @return Entity update time as unix (epoch) milliseconds.
     */
    default long getUpdatedAtMillis() {
        return getUpdatedAt().toEpochMilli();
    }

    /**
     * @return Entity update time in ISO_INSTANT string representation.
     */
    default String formatUpdatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getUpdatedAt());
    }

    /**
     * Compares update time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareUpdatedAtTo(Instant other) {
        return other == null
                ? -1
                : other.compareTo(getUpdatedAt());
    }

    /**
     * Compares update time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareUpdatedAtTo(Supplier<Instant> other) {
        return other == null
                ? -1
                : compareUpdatedAtTo(other.get());
    }

    /**
     * Compares update time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareUpdateAtTo(UpdatedAtReference other) {
        return other == null
                ? -1
                : compareUpdatedAtTo(other.getUpdatedAt());
    }
}
