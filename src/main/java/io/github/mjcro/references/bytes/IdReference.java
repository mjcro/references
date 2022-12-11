package io.github.mjcro.references.bytes;

import java.util.Base64;

public interface IdReference {
    /**
     * @return Identifier of entity.
     */
    byte[] getId();

    /**
     * @return Identifier of entity represented in Base64 format.
     */
    default String getIdBase64() {
        return Base64.getEncoder().encodeToString(getId());
    }
}
