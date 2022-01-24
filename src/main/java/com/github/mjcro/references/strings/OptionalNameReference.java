package com.github.mjcro.references.strings;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface OptionalNameReference {
    /**
     * @return Name of entity
     */
    Optional<String> getName();

    /**
     * @return Name of entity
     * @throws NoSuchElementException if there is no value present
     */
    default String mustGetName() {
        return getName().get();
    }
}
