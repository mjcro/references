package io.github.mjcro.references.enums;

import java.util.Collection;

public interface StateReference<T extends Enum<T>> {
    /**
     * @return Entity state.
     */
    T getState();

    /**
     * Checks if entity state is equal to given one.
     *
     * @param other State to compare with.
     * @return True is states are equal.
     */
    default boolean hasState(T other) {
        return other != null && other.equals(getState());
    }

    /**
     * Checks if entity state is equal to given one.
     *
     * @param other State container to compare with.
     * @return True is states are equal.
     */
    default boolean hasState(StateReference<T> other) {
        return other != null && other.hasState(getState());
    }

    /**
     * Checks if entity's state contains in given states collection.
     *
     * @param suggestions Collection of states to match against.
     * @return True if entity's state contains in given collection.
     */
    default boolean hasStateOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getState());
    }
}
