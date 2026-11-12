# Product Quantization (PQ) Codebook Clustering Specification

## 1. Space Decomposition
Product Quantization divides a $D$-dimensional vector space into $M$ orthogonal subspaces of dimension $d' = D / M$.

## 2. Codebook Centroids & Asymmetric Distance Computation
- Each subspace trains $K = 256$ centroids via $k$-means ($1\,\text{byte}$ code index per sub-vector).
- **Asymmetric Distance Computation (ADC):** Uncompressed query vector computes lookup tables against all 256 centroids per subspace:

$$\text{Dist}(Q, X) \approx \sum_{m=1}^{M} \| Q^{(m)} - c_{m, i_m} \|^2$$

## 3. Memory Compression
A 1536-dimensional float32 vector (6144 bytes) compresses to 96 bytes (64x reduction) while retaining $> 94\%$ relative recall.
