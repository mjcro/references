package com.github.mjcro.references.bytes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public interface ByteBodyReference {
    /**
     * @return Entity body as bytes.
     */
    byte[] getBody();

    /**
     * @return True if body is empty.
     */
    default boolean isBodyEmpty() {
        byte[] body = this.getBody();
        return body == null || body.length == 0;
    }

    /**
     * @return True if body not empty.
     */
    default boolean isBodyPresent() {
        return !isBodyEmpty();
    }

    /**
     * Returns entity body as string.
     * If body bytes are null or empty, empty string will be returned.
     *
     * @param charset String character set.
     * @return Entity body as string.
     */
    default String getBodyString(Charset charset) {
        byte[] body = this.getBody();
        return body == null || body.length == 0
                ? ""
                : (charset == null ? new String(body) : new String(body, charset));
    }

    /**
     * Returns entity body as string.
     * If body bytes are null or empty, empty string will be returned.
     *
     * @return Entity body as string in UTF-8 encoding.
     */
    default String getBodyString() {
        return this.getBodyString(StandardCharsets.UTF_8);
    }

    /**
     * @return Entity body as {@link InputStream}.
     */
    default InputStream getBodyInputStream() {
        return new ByteArrayInputStream(getBody());
    }
}
