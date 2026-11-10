# SIMD Vector API Distance Metrics and Equations

## 1. Cosine Distance
$$D_{\text{Cosine}}(u, v) = 1 - \frac{\sum u_i v_i}{\sqrt{\sum u_i^2} \cdot \sqrt{\sum v_i^2}}$$
When vectors are pre-normalized to unit Euclidean length ($||u|| = 1$), Cosine distance reduces to $1 - \langle u, v \rangle$, executed via single-cycle SIMD FMA (Fused Multiply-Add).

## 2. Squared Euclidean Distance ($L_2$)
$$D_{L2}(u, v) = \sum_{i=1}^{d} (u_i - v_i)^2$$
Avoids square root computation during nearest-neighbor ranking since square root is strictly monotonic.
