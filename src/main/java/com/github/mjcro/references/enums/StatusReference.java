package com.github.mjcro.references.enums;

import java.util.Collection;

public interface StatusReference<T extends Enum<T>> {
    T getStatus();

    default boolean isStatusOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getStatus());
    }
}
