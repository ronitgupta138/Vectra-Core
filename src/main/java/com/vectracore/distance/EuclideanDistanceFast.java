package com.vectracore.distance;

/**
 * Fast Euclidean squared distance calculator avoiding expensive Math.sqrt calls during nearest-neighbor sorting.
 */
public class EuclideanDistanceFast {
    public static float computeSquared(float[] a, float[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Dimension mismatch: " + a.length + " vs " + b.length);
        }
        float sum = 0.0f;
        for (int i = 0; i < a.length; i++) {
            float diff = a[i] - b[i];
            sum += diff * diff;
        }
        return sum;
    }
}
