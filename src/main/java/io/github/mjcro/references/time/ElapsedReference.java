package io.github.mjcro.references.time;

import java.time.Duration;

public interface ElapsedReference {
    /**
     * @return Elapsed time.
     */
    Duration getElapsed();

    /**
     * @return Elapsed time in milliseconds.
     */
    default long getElapsedMillis() {
        return getElapsed().toMillis();
    }

    /**
     * @return Elapsed time in nanoseconds.
     */
    default long getElapsedNanos() {
        return getElapsed().toNanos();
    }
}
