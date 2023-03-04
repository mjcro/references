package io.github.mjcro.references.shorts;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface ScopeIdReference {
    /**
     * Filters given collection by scope id.
     *
     * @param source  Source collection.
     * @param scopeId Scope identifier to match.
     * @param <T>     Collection type.
     * @return Filtered collection (list).
     */
    static <T extends ScopeIdReference> List<T> filter(Collection<T> source, short scopeId) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<ScopeIdReference> predicate = ScopeIdReference.predicate(scopeId);
        return source.stream().filter(Objects::nonNull).filter(predicate).collect(Collectors.toList());
    }

    /**
     * Constructs and returns predicate, that can be useful to filter some collections
     * with {@link ScopeIdReference} instances.
     * <p>
     * Example:
     * scopeReferences.stream().filter(ScopeIdReference.predicate(1)).collect(Collectors.toList())
     *
     * @param expectedScopeId Expected scope identifier.
     * @return Predicate that will return true if given {@link ScopeIdReference} contains same scope identifier.
     */
    static Predicate<ScopeIdReference> predicate(final short expectedScopeId) {
        return ref -> ref != null && ref.getScopeId() == expectedScopeId;
    }

    /**
     * @return Scope identifier of entity
     */
    short getScopeId();
}
