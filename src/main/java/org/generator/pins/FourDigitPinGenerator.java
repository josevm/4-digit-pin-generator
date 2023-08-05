package org.generator.pins;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates unique 4 digit PINs.
 * <p><b>NOTE:</b> This class is not thread-safe.
 * If multiple threads access a {@code FourDigitPinGenerator} instance concurrently, it must be synchronized externally.
 * </p>
 */
public class FourDigitPinGenerator implements PinGenerator {

    private static final int MAX_PIN = 9999;

    @Override
    public Set<String> generate(int batchSize) throws IllegalArgumentException {
        if (batchSize < 1) {
            throw new IllegalArgumentException("Batch size must be greater than 0");
        }

        if (batchSize > MAX_PIN) {
            throw new IllegalArgumentException("Batch size must be less than 10000");
        }

        Set<String> pins = new HashSet<>(batchSize);
        Random random = new Random();
        while (pins.size() < batchSize) {
            pins.add(String.format("%04d", random.nextInt(MAX_PIN)));
        }

        return pins;
    }
}
