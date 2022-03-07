package io.github.mjcro.references.longs;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalLong;

public interface OptionalIdReference {
    OptionalLong getId();

    default long mustGetId() throws NoSuchElementException {
        return getId().getAsLong();
    }

    default Optional<Long> getIdBoxed() {
        OptionalLong id = getId();
        return id.isPresent() ? Optional.of(id.getAsLong()) : Optional.empty();
    }
}
