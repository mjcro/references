package io.github.mjcro.references.enums;

import java.util.Collection;

public interface StatusReference<T extends Enum<T>> {
    /**
     * @return Entity status.
     */
    T getStatus();

    /**
     * Checks if entity status is equal to given one.
     *
     * @param other State to compare with.
     * @return True is statuses are equal.
     */
    default boolean hasStatus(T other) {
        return other != null && other.equals(getStatus());
    }

    /**
     * Checks if entity status is equal to given one.
     *
     * @param other State container to compare with.
     * @return True is statuses are equal.
     */
    default boolean hasStatus(StatusReference<T> other) {
        return other != null && other.hasStatus(getStatus());
    }

    /**
     * Checks if entity's status contains in given statuses collection.
     *
     * @param suggestions Collection of statuses to match against.
     * @return True if entity's status contains in given collection.
     */
    default boolean hasStatusOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getStatus());
    }
}
