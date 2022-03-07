package io.github.mjcro.references.enums;

import java.util.Collection;

public interface TypeReference<T extends Enum<T>> {
    T getType();

    default boolean isTypeOneOf(Collection<T> suggestions) {
        return suggestions != null && suggestions.contains(getType());
    }
}
