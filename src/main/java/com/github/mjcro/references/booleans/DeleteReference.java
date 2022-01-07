package com.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public interface DeleteReference {
    static <T extends DeleteReference> Collection<T> filterNotDeleted(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(DeleteReference::isNotDeleted).collect(Collectors.toList());
    }

    boolean isDeleted();

    default boolean isNotDeleted() {
        return !isDeleted();
    }
}
