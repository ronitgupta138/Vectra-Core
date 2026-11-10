# SQ8 (Scalar Quantization 8-bit) Compression Specification

## 1. Algorithmic Formulation
Converts standard 32-bit floating point embeddings (`float32`, 4 bytes/dim) into signed 8-bit integers (`int8`, 1 byte/dim), slashing RAM requirements by 75%:
- **Quantization Formula:**
  $$q_i = \text{clamp}\left(\left\lfloor \frac{x_i - \min_i}{\max_i - \min_i} \cdot 255 \right\rceil, 0, 255\right)$$
- **Asymmetric Reconstruction:**
  $$\hat{x}_i = \min_i + \frac{q_i}{255} \cdot (\max_i - \min_i)$$

## 2. SIMD Vector Acceleration
Java 21 Incubator Vector API (`ByteVector`) processes 64 integer dimensions per SIMD instruction cycle on AVX-512 architectures, yielding sub-0.08ms vector distance evaluations.
