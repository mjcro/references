package io.github.mjcro.references.longs;

public interface WeightReference {
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
