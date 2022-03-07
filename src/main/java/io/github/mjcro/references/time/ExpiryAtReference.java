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
    static <T extends ExpiryAtReference> List<T> filterNonExpired(Collection<T> source) {
        return filterNonExpired(source, Instant::now);
    }

    static <T extends ExpiryAtReference> List<T> filterNonExpired(Collection<T> source, Supplier<Instant> supplier) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        Objects.requireNonNull(supplier, "supplier");
        return source.stream().filter(Objects::nonNull).filter($ -> $.isNotExpired(supplier)).collect(Collectors.toList());
    }

    Instant getExpiryAt();

    default long getExpiryAtSeconds() {
        return getExpiryAt().getEpochSecond();
    }

    default long getExpiryAtMillis() {
        return getExpiryAt().toEpochMilli();
    }

    default boolean isNotExpired(Supplier<Instant> supplier) {
        return getExpiryAt().isBefore(supplier.get());
    }

    default boolean isNotExpired() {
        return isNotExpired(Instant::now);
    }

    default boolean isExpired(Supplier<Instant> supplier) {
        return !isNotExpired(supplier);
    }

    default boolean isExpired() {
        return !isNotExpired();
    }

    default String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAt());
    }
}
