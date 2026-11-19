package com.vectracore.filter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitsetSelectivityEstimatorTest {
    @Test
    void testSelectivityDecisions() {
        // 100 matches out of 1000 = 10% selectivity -> pre-filter
        assertTrue(BitsetSelectivityEstimator.shouldPreFilter(100, 1000));

        // 800 matches out of 1000 = 80% selectivity -> post-filter
        assertFalse(BitsetSelectivityEstimator.shouldPreFilter(800, 1000));
    }
}
