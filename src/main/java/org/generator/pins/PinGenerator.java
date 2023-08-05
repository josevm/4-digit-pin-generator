package org.generator.pins;

import java.util.Set;

/**
 * Interface for generating PINs.
 * */
public interface PinGenerator {
    /**
     * Generates unique PINs.
     *
     * @param batchSize the number of PINs to generate
     * @return a set of PINs
     * @throws IllegalArgumentException if batch size is outside the valid range.
     */
    Set<String> generate(int batchSize) throws IllegalArgumentException;

}
