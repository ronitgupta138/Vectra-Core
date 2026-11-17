package com.vectracore.distance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChebyshevDistanceTest {
    @Test
    void testIdenticalVectors() {
        float[] a = {2.5f, -1.0f, 4.0f};
        assertEquals(0.0f, ChebyshevDistance.compute(a, a), 1e-6);
    }

    @Test
    void testChebyshevCalculation() {
        float[] a = {1.0f, 5.0f, 3.0f};
        float[] b = {2.0f, 1.0f, 8.0f};
        // diffs: |1-2|=1, |5-1|=4, |3-8|=5 -> max is 5
        assertEquals(5.0f, ChebyshevDistance.compute(a, b), 1e-6);
    }
}
