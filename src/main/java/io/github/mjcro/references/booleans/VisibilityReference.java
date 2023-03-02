package io.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface VisibilityReference {
    /**
     * Filters given collection of hide-able entities returning only
     * those are marked as visible.
     * Providing empty collection does not cause an exception, resulting
     * empty list will be returned.
     *
     * @param source Source collection.
     * @param <T>    Collection type.
     * @return List containing only entities that are marked as visible.
     */
    static <T extends VisibilityReference> List<T> filterVisible(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(VisibilityReference::isVisible).collect(Collectors.toList());
    }

    /**
     * @return True if entity is marked as visible.
     */
    boolean isVisible();

    /**
     * @return True if entity is not marked as visible.
     */
    default boolean isHidden() {
        return !isVisible();
    }
}
