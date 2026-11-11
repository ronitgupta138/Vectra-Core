# Manhattan (L1) Distance SIMD Vector Equations

## 1. Formulation
$$D_{L1}(u, v) = \sum_{i=1}^{d} |u_i - v_i|$$
Accelerated on AVX-512 using `vpandn` and `vpaddd` instructions, minimizing floating-point pipeline stalls for sparse embedding vectors.
