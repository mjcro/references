package io.github.mjcro.references.booleans;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface EnabledReference {
    static <T extends EnabledReference> List<T> filterEnabled(Collection<T> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().filter(Objects::nonNull).filter(EnabledReference::isEnabled).collect(Collectors.toList());
    }

    boolean isEnabled();

    default boolean isDisabled() {
        return !isEnabled();
    }
}
