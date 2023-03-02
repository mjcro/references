package io.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface DeleteReference {
    /**
     * Filters given collection of deletable entities returning only
     * those are not marked as deleted.
     * Providing empty collection does not cause an exception, resulting
     * empty list will be returned.
     *
     * @param source Source collection.
     * @param <T>    Collection type.
     * @return List containing only entities that are not marked as deleted.
     */
    static <T extends DeleteReference> List<T> filterNotDeleted(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(DeleteReference::isNotDeleted).collect(Collectors.toList());
    }

    /**
     * @return True if entity is marked as deleted.
     */
    boolean isDeleted();

    /**
     * @return True if entity is not marked as deleted.
     */
    default boolean isNotDeleted() {
        return !isDeleted();
    }
}
