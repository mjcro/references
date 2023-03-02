package io.github.mjcro.references.longs;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface OptionalIdReference {
    /**
     * @return Identifier of entity.
     */
    Optional<Long> getId();

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
    default long mustGetId() throws NoSuchElementException {
        return getId().get();
    }
}
