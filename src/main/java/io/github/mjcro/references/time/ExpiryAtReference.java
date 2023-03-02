package io.github.mjcro.references.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface ExpiryAtReference {
    /**
     * Filters given collection returning only those entities
     * that are not expired against current time.
     *
     * @param source Source collection.
     * @return Filtered list.
     */
    static <T extends ExpiryAtReference> List<T> filterNonExpired(Collection<T> source) {
        return filterNonExpired(source, Instant::now);
    }

    /**
     * Filters given collection returning only those entities
     * that are not expired against given time.
     *
     * @param source   Source collection.
     * @param supplier "Current time" provider.
     * @return Filtered list.
     */
    static <T extends ExpiryAtReference> List<T> filterNonExpired(Collection<T> source, Supplier<Instant> supplier) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        Objects.requireNonNull(supplier, "supplier");
        return source.stream().filter(Objects::nonNull).filter($ -> $.isNotExpired(supplier)).collect(Collectors.toList());
    }

    /**
     * @return Entity expiration time.
     */
    Instant getExpiryAt();

    /**
     * @return Entity expiration time as unix (epoch) seconds.
     */
    default long getExpiryAtSeconds() {
        return getExpiryAt().getEpochSecond();
    }

    /**
     * @return Entity expiration time as unix (epoch) milliseconds.
     */
    default long getExpiryAtMillis() {
        return getExpiryAt().toEpochMilli();
    }

    /**
     * Checks if entity expired or not against instant
     * representing current time.
     *
     * @param now Current time.
     * @return True if entity not expired.
     */
    default boolean isNotExpired(Instant now) {
        return getExpiryAt().isBefore(now);
    }

    /**
     * Checks if entity expired or not against instant
     * representing current time.
     *
     * @param now Current time.
     * @return True if entity is expired.
     */
    default boolean isExpired(Instant now) {
        return !isNotExpired(now);
    }

    /**
     * Checks if entity expired or not against instant
     * representing current time.
     *
     * @param supplier Supplier providing current time.
     * @return True if entity not expired.
     */
    default boolean isNotExpired(Supplier<Instant> supplier) {
        return supplier != null && isNotExpired(supplier.get());
    }

    /**
     * Checks if entity expired or not against instant
     * representing current time.
     *
     * @param supplier Supplier providing current time.
     * @return True if entity is expired.
     */
    default boolean isExpired(Supplier<Instant> supplier) {
        return supplier != null && isExpired(supplier.get());
    }

    /**
     * Checks if entity expired or not.
     *
     * @return True if entity not expired.
     */
    default boolean isNotExpired() {
        return isNotExpired(Instant::now);
    }

    /**
     * Checks if entity expired or not.
     *
     * @return True if entity is expired.
     */
    default boolean isExpired() {
        return !isNotExpired();
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAt());
    }

    /**
     * Compares expiration time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareExpiryAtTo(Instant other) {
        return other == null
                ? -1
                : other.compareTo(getExpiryAt());
    }

    /**
     * Compares expiration time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareExpiryAtTo(Supplier<Instant> other) {
        return other == null
                ? -1
                : compareExpiryAtTo(other.get());
    }

    /**
     * Compares expiration time with given one.
     *
     * @param other Instant to compare with.
     * @return Comparison result.
     */
    default int compareExpiryAtTo(ExpiryAtReference other) {
        return other == null
                ? -1
                : compareExpiryAtTo(other.getExpiryAt());
    }
}
