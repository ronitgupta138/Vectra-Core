package com.vectracore.distance;

/**
 * Chebyshev (L-infinity) maximum coordinate distance metric calculation.
 */
public class ChebyshevDistance {
    public static float compute(float[] a, float[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Dimension mismatch: " + a.length + " vs " + b.length);
        }
        float maxDiff = 0.0f;
        for (int i = 0; i < a.length; i++) {
            float diff = Math.abs(a[i] - b[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
