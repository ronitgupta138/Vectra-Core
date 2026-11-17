package com.vectracore.quantization;

/**
 * Validates dynamic range boundaries and computes scale factors for SQ8 scalar quantization.
 */
public class SQ8BoundsValidator {
    public record QuantizationRange(float min, float max, float scale) {}

    public static QuantizationRange computeRange(float[] vector) {
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("Vector cannot be empty");
        }
        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;
        for (float v : vector) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        float scale = (max > min) ? (max - min) / 255.0f : 1.0f;
        return new QuantizationRange(min, max, scale);
    }

    public static byte clampToByte(float value, float min, float scale) {
        int quantized = Math.round((value - min) / scale);
        return (byte) Math.max(0, Math.min(255, quantized));
    }
}
