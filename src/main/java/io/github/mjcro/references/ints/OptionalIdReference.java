package io.github.mjcro.references.ints;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface OptionalIdReference {
    /**
     * @return Identifier of entity.
     */
    Optional<Integer> getId();

    /**
     * @return True if identifier is present.
     */
    default boolean hasId() {
        return getId().isPresent();
    }

    /**
     * @return Identifier of entity.
     * @throws NoSuchElementException if entity has no identifier.
     */
    default int mustGetId() throws NoSuchElementException {
        return getId().get();
    }
}
