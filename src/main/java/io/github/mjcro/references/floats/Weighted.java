package io.github.mjcro.references.floats;

/**
 * Represents weighted relation.
 *
 * @param <T> Relation target.
 */
public interface Weighted<T> extends WeightReference {
    /**
     * Constructs new weighted relation.
     *
     * @param weight Relation weight.
     * @param target Relation target.
     * @param <T>    Relation target type.
     * @return Relation
     */
    static <T> Weighted<T> of(float weight, T target) {
        return new WeightedImpl<>(weight, target);
    }

    /**
     * @return Relation target.
     */
    T getData();
}
