package com.vectracore.index;

/**
 * HNSW Graph construction and query search hyperparameter configuration.
 */
public record HnswConfig(int m, int efConstruction, int efSearch) {
    public HnswConfig {
        if (m < 2 || m > 128) {
            throw new IllegalArgumentException("M must be between 2 and 128, got: " + m);
        }
        if (efConstruction < 8 || efConstruction > 1024) {
            throw new IllegalArgumentException("efConstruction must be between 8 and 1024, got: " + efConstruction);
        }
        if (efSearch < 1 || efSearch > 512) {
            throw new IllegalArgumentException("efSearch must be between 1 and 512, got: " + efSearch);
        }
    }

    public static HnswConfig defaultProfile() {
        return new HnswConfig(16, 200, 50);
    }

    public static HnswConfig lowLatencyProfile() {
        return new HnswConfig(12, 100, 32);
    }

    public static HnswConfig highRecallProfile() {
        return new HnswConfig(32, 400, 128);
    }
}
