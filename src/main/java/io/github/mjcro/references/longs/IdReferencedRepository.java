package io.github.mjcro.references.longs;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface IdReferencedRepository<T extends IdReference> {
    /**
     * Creates repository instance that reads data from given collection.
     *
     * @param data Source data.
     * @param <T>  Entity type.
     * @return Repository instance.
     */
    static <T extends IdReference> IdReferencedRepository<T> staticRepository(Collection<T> data) {
        return new IdReferencedRepositoryStaticMap<>(data);
    }

    /**
     * Matches entities by their identifiers.
     *
     * @param ids Identifiers.
     * @return List of matched entities.
     */
    List<T> findById(long... ids);

    /**
     * Matches entities by their identifiers.
     *
     * @param ids Identifiers.
     * @return List of matched entities.
     */
    default List<T> findById(Collection<Long> ids) {
        return ids == null || ids.isEmpty()
                ? Collections.emptyList()
                : findById(ids.stream().filter(Objects::nonNull).distinct().mapToLong($ -> $).toArray());
    }

    /**
     * Matches single entity by its identifier.
     *
     * @param id Entity identifier.
     * @return Matched entity, if any.
     */
    default Optional<T> findById(long id) {
        return findById(new long[]{id}).stream().findAny();
    }

    /**
     * Matches single entity by its identifier.
     *
     * @param id Entity identifier.
     * @return Matched entity, if any.
     * @throws java.util.NoSuchElementException if entity not found.
     */
    default T mustFindById(long id) {
        return findById(id).get();
    }

    /**
     * Matches single entity by its identifier.
     *
     * @param id       Entity identifier.
     * @param supplier Exception supplier, used to generation exception when entity not found.
     * @return Matched entity, if any.
     */
    default T mustFindById(long id, Supplier<RuntimeException> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return findById(id).orElseThrow(supplier);
    }

    /**
     * Matches entities by their identifiers.
     *
     * @param ids Identifiers.
     * @return Mapped by identifier collection of found entities.
     */
    default Map<Long, T> mapById(long[] ids) {
        return findById(ids)
                .stream()
                .collect(Collectors.toMap(IdReference::getId, Function.identity()));
    }

    /**
     * Matches entities by their identifiers.
     *
     * @param ids Identifiers.
     * @return Mapped by identifier collection of found entities.
     */
    default Map<Long, T> mapById(Collection<Long> ids) {
        return ids == null || ids.isEmpty()
                ? Collections.emptyMap()
                : mapById(ids.stream().filter(Objects::nonNull).distinct().mapToLong($ -> $).toArray());
    }
}
