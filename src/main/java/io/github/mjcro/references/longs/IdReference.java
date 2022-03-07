package io.github.mjcro.references.longs;

import java.util.Comparator;

public interface IdReference {
    /**
     * Comparator used to sort list of entries with ids.
     * in DESC order
     */
    Comparator<IdReference> SORT_DESC = Comparator.comparingLong(IdReference::getId).reversed();
    /**
     * Comparator used to sort list of entries with ids.
     * in ASC order
     */
    Comparator<IdReference> SORT_ASC = Comparator.comparingLong(IdReference::getId);

    /**
     * @return Identifier of entity
     */
    long getId();
}
