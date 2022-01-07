package com.github.mjcro.references.longs;

import com.github.mjcro.references.enums.TypeReference;

public interface Owner<T extends Enum<T>> extends OptionalIdReference, TypeReference<T> {
    static <T extends Enum<T>> Owner<T> of(T type) {
        return new OwnerImpl<>(type, 0, false);
    }

    static <T extends Enum<T>> Owner<T> of(T type, long id) {
        return new OwnerImpl<>(type, id, true);
    }
}
