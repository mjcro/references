package io.github.mjcro.references.ints;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface GateIdReference {
    /**
     * Filters given collection by gate id.
     *
     * @param source Source collection.
     * @param gateId Gate identifier to match.
     * @param <T>    Collection type.
     * @return Filtered collection (list).
     */
    static <T extends GateIdReference> List<T> filter(Collection<T> source, int gateId) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<GateIdReference> predicate = GateIdReference.predicate(gateId);
        return source.stream().filter(Objects::nonNull).filter(predicate).collect(Collectors.toList());
    }

    /**
     * Constructs and returns predicate, that can be useful to filter some collections
     * with {@link GateIdReference} instances.
     * <p>
     * Example:
     * gateReferences.stream().filter(GateIdReference.predicate(1)).collect(Collectors.toList())
     *
     * @param expectedGateId Expected gate identifier.
     * @return Predicate that will return true if given {@link GateIdReference} contains same gate identifier.
     */
    static Predicate<GateIdReference> predicate(final int expectedGateId) {
        return ref -> ref != null && ref.getGateId() == expectedGateId;
    }

    /**
     * @return Gate (Scope) identifier of entity
     */
    int getGateId();
}
