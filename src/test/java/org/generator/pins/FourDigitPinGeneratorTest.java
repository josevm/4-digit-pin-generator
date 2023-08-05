package org.generator.pins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FourDigitPinGeneratorTest {

    PinGenerator pinGenerator;

    @BeforeEach
    public void setUp() {
        pinGenerator = new FourDigitPinGenerator();
    }

    @DisplayName("Test should generate unique 4 digit pins")
    @ParameterizedTest(name = "Batch size: {0}")
    @ValueSource(ints = {1, 10, 100, 1000, 5978, 9999})
    public void testShouldGenerateUnique4DigitPins(int batchSize) {
        Set<String> pins = pinGenerator.generate(batchSize);
        Set<String> uniquePins = Set.copyOf(pins);

        assertEquals(batchSize, pins.size(), "Generated batch size should match requested batch size");
        assertEquals(batchSize, uniquePins.size(), "All generated pins should be unique");
        for (String pin : pins) {
            assertTrue(pin.matches("[0-9]{4}"), "Generated pin should be 4 digits long");
        }
    }

    @DisplayName("Test should throw exception when batch size is less than 1")
    @ParameterizedTest(name = "Batch size: {0}")
    @ValueSource(ints = {0, -1, -10, -100, -999999})
    public void testShouldThrowExceptionWhenBatchSizeIsLessThan1(int batchSize) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> pinGenerator.generate(batchSize)
        );

        assertEquals("Batch size must be greater than 0", exception.getMessage());
    }

    @DisplayName("Test should throw exception when batch size is greater than 9999")
    @ParameterizedTest(name = "Batch size: {0}")
    @ValueSource(ints = {10000, 10001, 100000, 1000001, 9999999})
    public void testShouldThrowExceptionWhenBatchSizeIsGreaterThan10000(int batchSize) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> pinGenerator.generate(batchSize)
        );

        assertEquals("Batch size must be less than 10000", exception.getMessage());
    }
}
