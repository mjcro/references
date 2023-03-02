package io.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface EnabledReference {
    /**
     * Filters given collection of enable-able entities returning only
     * those are marked as enabled.
     * Providing empty collection does not cause an exception, resulting
     * empty list will be returned.
     *
     * @param source Source collection.
     * @param <T>    Collection type.
     * @return List containing only entities that are marked as enabled.
     */
    static <T extends EnabledReference> List<T> filterEnabled(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(EnabledReference::isEnabled).collect(Collectors.toList());
    }

    /**
     * @return True if entity is marked as enabled.
     */
    boolean isEnabled();

    /**
     * @return True if entity is not marked as enabled.
     */
    default boolean isDisabled() {
        return !isEnabled();
    }
}
