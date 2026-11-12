# AVX-512 FMA Vector Dot Product Hardware Acceleration Specification

## 1. SIMD Register Allocation
Vectra-Core leverages 512-bit ZMM registers via Java 21 Foreign Function & Memory API / Project Panama to execute SIMD vector multiplications.

## 2. Fused Multiply-Add (FMA) Unrolling
- 16 single-precision 32-bit floats processed simultaneously per cycle:
```asm
vfmadd231ps %zmm0, %zmm1, %zmm2
```
- Loop unrolling factor of 4 evaluates 64 floating point dimensions per iteration, saturating instruction pipelines and maximizing arithmetic intensity.

## 3. Memory Alignment Constraints
Vectors are aligned to 64-byte memory boundaries to ensure single-cycle SIMD cache line loads without unaligned access penalties.
