package io.github.mjcro.references.enums;

import java.util.Collection;

public interface TypeReference<T extends Enum<T>> {
    /**
     * @return Entity type
     */
    T getType();

    /**
     * Checks if entity type is equal to given one.
     *
     * @param other State to compare with.
     * @return True is types are equal.
     */
    default boolean hasType(T other) {
        return other != null && other.equals(getType());
    }

    /**
     * Checks if entity type is equal to given one.
     *
     * @param other State container to compare with.
     * @return True is types are equal.
     */
    default boolean hasType(TypeReference<T> other) {
        return other != null && other.hasType(getType());
    }

    /**
     * Checks if entity's types contains in given types collection.
     *
     * @param suggestions Collection of types to match against.
     * @return True if entity's type contains in given collection.
     */
    default boolean hasTypeOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getType());
    }
}
