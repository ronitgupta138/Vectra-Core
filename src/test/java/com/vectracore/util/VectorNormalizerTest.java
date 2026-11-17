package com.vectracore.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorNormalizerTest {
    @Test
    void testNormalizeL2UnitMagnitude() {
        float[] vec = {3.0f, 4.0f};
        float[] normalized = VectorNormalizer.normalizeL2(vec);
        assertEquals(0.6f, normalized[0], 1e-5);
        assertEquals(0.8f, normalized[1], 1e-5);

        float magnitude = normalized[0] * normalized[0] + normalized[1] * normalized[1];
        assertEquals(1.0f, magnitude, 1e-5);
    }

    @Test
    void testZeroVectorNormalized() {
        float[] zero = {0.0f, 0.0f};
        float[] norm = VectorNormalizer.normalizeL2(zero);
        assertArrayEquals(zero, norm, 1e-6f);
    }
}
