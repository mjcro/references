package io.github.mjcro.references.floats;

import java.util.Objects;

class WeightedImpl<T> implements Weighted<T> {
    private final T data;
    private final float weight;

    WeightedImpl(float weight, T target) {
        this.data = Objects.requireNonNull(target, "target");
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weighted)) return false;
        Weighted<?> weighted = (Weighted<?>) o;
        return Float.compare(weighted.getWeight(), getWeight()) == 0 && getData().equals(weighted.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getWeight());
    }
}
