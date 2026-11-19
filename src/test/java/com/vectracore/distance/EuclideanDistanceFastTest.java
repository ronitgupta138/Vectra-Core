package com.vectracore.distance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EuclideanDistanceFastTest {
    @Test
    void testSquaredDistance() {
        float[] a = {1.0f, 2.0f, 3.0f};
        float[] b = {4.0f, 6.0f, 3.0f};
        // (1-4)^2 + (2-6)^2 + (3-3)^2 = 9 + 16 + 0 = 25
        assertEquals(25.0f, EuclideanDistanceFast.computeSquared(a, b), 1e-5);
    }
}
