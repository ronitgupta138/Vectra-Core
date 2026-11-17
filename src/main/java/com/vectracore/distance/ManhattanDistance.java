package com.vectracore.distance;

/**
 * Manhattan (L1) distance metric calculation.
 */
public class ManhattanDistance {
    public static float compute(float[] a, float[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Dimension mismatch: " + a.length + " vs " + b.length);
        }
        float sum = 0.0f;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }
}
