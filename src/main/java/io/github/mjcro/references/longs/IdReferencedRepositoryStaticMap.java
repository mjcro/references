package io.github.mjcro.references.longs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class IdReferencedRepositoryStaticMap<T extends IdReference> implements IdReferencedRepository<T> {
    private final Map<Long, T> values;

    IdReferencedRepositoryStaticMap(Collection<T> values) {
        this.values = values == null || values.isEmpty()
                ? Collections.emptyMap() // Empty
                : values.stream().collect(Collectors.toMap(IdReference::getId, Function.identity()));
    }

    @Override
    public List<T> findById(long... ids) {
        if (ids == null || ids.length == 0) {
            return Collections.emptyList();
        }

        ArrayList<T> result = new ArrayList<>(ids.length);
        for (long id : ids) {
            T row = values.get(id);
            if (row != null) {
                result.add(row);
            }
        }

        return result;
    }
}
