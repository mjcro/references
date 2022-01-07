package com.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public interface VisibilityReference {
    static <T extends VisibilityReference> Collection<T> filterVisible(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(VisibilityReference::isVisible).collect(Collectors.toList());
    }

    boolean isVisible();

    default boolean isHidden() {
        return !isVisible();
    }
}
