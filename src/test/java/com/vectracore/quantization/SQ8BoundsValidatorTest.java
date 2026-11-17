package com.vectracore.quantization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SQ8BoundsValidatorTest {
    @Test
    void testComputeRange() {
        float[] vec = {-1.0f, 0.0f, 1.0f};
        var range = SQ8BoundsValidator.computeRange(vec);
        assertEquals(-1.0f, range.min(), 1e-6);
        assertEquals(1.0f, range.max(), 1e-6);
        assertEquals(2.0f / 255.0f, range.scale(), 1e-6);
    }

    @Test
    void testClampToByte() {
        byte b0 = SQ8BoundsValidator.clampToByte(-1.0f, -1.0f, 2.0f / 255.0f);
        byte b255 = SQ8BoundsValidator.clampToByte(1.0f, -1.0f, 2.0f / 255.0f);
        assertEquals(0, b0);
        assertEquals((byte) 255, b255);
    }
}
