package com.github.mjcro.references.longs;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ScopeIdReference {
    static <T extends ScopeIdReference> Collection<T> filter(Collection<T> source, long scopeId) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter($ -> $.getScopeId() == scopeId).collect(Collectors.toList());
    }

    long getScopeId();
}
