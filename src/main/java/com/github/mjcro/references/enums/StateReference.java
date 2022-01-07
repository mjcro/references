package com.github.mjcro.references.enums;

import java.util.Collection;

public interface StateReference<T extends Enum<T>> {
    T getState();

    default boolean isStateOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getState());
    }
}
