package com.vectracore.distance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManhattanDistanceTest {
    @Test
    void testIdenticalVectors() {
        float[] a = {1.0f, 2.0f, 3.0f};
        assertEquals(0.0f, ManhattanDistance.compute(a, a), 1e-6);
    }

    @Test
    void testL1DistanceCalculation() {
        float[] a = {1.0f, 2.0f, 3.0f};
        float[] b = {4.0f, 0.0f, -1.0f};
        // |1-4| + |2-0| + |3 - (-1)| = 3 + 2 + 4 = 9
        assertEquals(9.0f, ManhattanDistance.compute(a, b), 1e-6);
    }

    @Test
    void testDimensionMismatch() {
        float[] a = {1.0f};
        float[] b = {1.0f, 2.0f};
        assertThrows(IllegalArgumentException.class, () -> ManhattanDistance.compute(a, b));
    }
}
