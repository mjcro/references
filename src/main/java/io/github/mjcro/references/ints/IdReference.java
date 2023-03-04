package io.github.mjcro.references.ints;

import java.util.Comparator;

public interface IdReference {
    /**
     * Comparator used to sort list of entries with ids.
     * in DESC order
     */
    Comparator<IdReference> SORT_DESC = Comparator.comparingInt(IdReference::getId).reversed();
    /**
     * Comparator used to sort list of entries with ids.
     * in ASC order
     */
    Comparator<IdReference> SORT_ASC = Comparator.comparingInt(IdReference::getId);

    /**
     * @return Identifier of entity
     */
    int getId();
}
