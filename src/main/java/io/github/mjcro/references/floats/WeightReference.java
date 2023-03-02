package io.github.mjcro.references.floats;

public interface WeightReference {
    /**
     * @return Relation weight.
     */
    float getWeight();

    /**
     * Compares weight of current object and given one.
     *
     * @param other Other weighted relation object to compare weight with.
     * @return Comparison result.
     */
    default int compareWeightTo(WeightReference other) {
        return other == null
                ? -1
                : Float.compare(getWeight(), other.getWeight());
    }
}
