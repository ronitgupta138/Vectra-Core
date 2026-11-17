package com.vectracore.index;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HnswConfigTest {
    @Test
    void testDefaultProfiles() {
        HnswConfig def = HnswConfig.defaultProfile();
        assertEquals(16, def.m());
        assertEquals(200, def.efConstruction());
        assertEquals(50, def.efSearch());

        HnswConfig fast = HnswConfig.lowLatencyProfile();
        assertEquals(12, fast.m());
    }

    @Test
    void testInvalidConfigThrows() {
        assertThrows(IllegalArgumentException.class, () -> new HnswConfig(1, 200, 50));
        assertThrows(IllegalArgumentException.class, () -> new HnswConfig(16, 4, 50));
        assertThrows(IllegalArgumentException.class, () -> new HnswConfig(16, 200, 0));
    }
}
