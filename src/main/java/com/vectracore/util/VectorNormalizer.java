package com.vectracore.util;

/**
 * L2 vector normalization utility for unit sphere cosine optimization.
 */
public class VectorNormalizer {
    public static float[] normalizeL2(float[] vector) {
        if (vector == null) return null;
        float normSq = 0.0f;
        for (float v : vector) {
            normSq += v * v;
        }
        if (normSq == 0.0f) {
            return vector.clone();
        }
        float norm = (float) Math.sqrt(normSq);
        float[] normalized = new float[vector.length];
        for (int i = 0; i < vector.length; i++) {
            normalized[i] = vector[i] / norm;
        }
        return normalized;
    }
}
