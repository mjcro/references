package io.github.mjcro.references.longs;

/**
 * Represents weighted relation.
 *
 * @param <T> Relation target.
 */
public interface Weighted<T> {
    /**
     * Constructs new weighted relation.
     *
     * @param weight Relation weight.
     * @param target Relation target.
     * @param <T>    Relation target type.
     * @return Relation
     */
    static <T> Weighted<T> of(long weight, T target) {
        return new WeightedImpl<>(weight, target);
    }

    /**
     * @return Relation target.
     */
    T getData();

    /**
     * @return Relation weight.
     */
    long getWeight();

    /**
     * Compares weight of current object and given one.
     *
     * @param other Other weighted relation object to compare weight with.
     * @return Comparison result.
     */
    default int compareWeightTo(Weighted<?> other) {
        return other == null
                ? -1
                : Long.compare(getWeight(), other.getWeight());
    }
}
