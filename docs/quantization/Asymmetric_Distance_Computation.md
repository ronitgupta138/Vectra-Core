# Asymmetric Distance Computation (ADC) for SQ8 Quantized Vectors

## 1. Mechanics
- The query vector $q$ remains in full 32-bit floating point precision.
- Stored database vectors $x_i$ remain in compressed 8-bit quantized format.
- Lookups eliminate quantization loss on the query side while avoiding runtime decompression of database vectors.
