package io.github.mjcro.references.longs;

import java.util.Objects;
import java.util.Optional;

class OwnerImpl<T extends Enum<T>> implements Owner<T> {
    private final T type;
    private final Long id;

    OwnerImpl(T type, Long id) {
        this.type = Objects.requireNonNull(type, "type");
        this.id = id;
    }

    @Override
    public T getType() {
        return type;
    }

    @Override
    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerImpl<?> owner = (OwnerImpl<?>) o;
        return getId() == owner.getId() && Objects.equals(this.getId(), owner.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getId());
    }

    @Override
    public String toString() {
        return id != null
                ? "OwnerImpl{type=" + type + ", id=" + id + '}'
                : "OwnerImpl{type=" + type + '}';
    }
}
