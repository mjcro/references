package io.github.mjcro.references.longs;

import java.util.Objects;
import java.util.OptionalLong;

class OwnerImpl<T extends Enum<T>> implements Owner<T> {
    private final T type;
    private final long id;
    private final boolean idPresent;

    OwnerImpl(T type, long id, boolean idPresent) {
        this.type = Objects.requireNonNull(type, "type");
        this.id = id;
        this.idPresent = idPresent;
    }

    @Override
    public T getType() {
        return type;
    }

    @Override
    public OptionalLong getId() {
        return idPresent ? OptionalLong.of(id) : OptionalLong.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerImpl<?> owner = (OwnerImpl<?>) o;
        return getId() == owner.getId() && idPresent == owner.idPresent && getType().equals(owner.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getId());
    }

    @Override
    public String toString() {
        return idPresent
                ? "OwnerImpl{type=" + type + ", id=" + id + '}'
                : "OwnerImpl{type=" + type + '}';
    }
}
