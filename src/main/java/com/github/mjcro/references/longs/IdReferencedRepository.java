package com.github.mjcro.references.longs;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface IdReferencedRepository<T extends IdReference> {
    static <T extends IdReference> IdReferencedRepository<T> staticRepository(Collection<T> data) {
        return new IdReferencedRepositoryStaticMap<>(data);
    }

    Collection<T> findById(long... ids);

    default Collection<T> findById(Collection<Long> ids) {
        return ids == null || ids.isEmpty()
                ? Collections.emptyList()
                : findById(ids.stream().filter(Objects::nonNull).distinct().mapToLong($ -> $).toArray());
    }

    default Optional<T> findById(long id) {
        return findById(new long[]{id}).stream().findAny();
    }

    default T mustFindById(long id) {
        return findById(id).get();
    }

    default T mustFindById(long id, Supplier<RuntimeException> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return findById(id).orElseThrow(supplier);
    }

    default Map<Long, T> mapById(long[] ids) {
        return findById(ids)
                .stream()
                .collect(Collectors.toMap(IdReference::getId, Function.identity()));
    }

    default Map<Long, T> mapById(Collection<Long> ids) {
        return ids == null || ids.isEmpty()
                ? Collections.emptyMap()
                : mapById(ids.stream().filter(Objects::nonNull).distinct().mapToLong($ -> $).toArray());
    }
}
