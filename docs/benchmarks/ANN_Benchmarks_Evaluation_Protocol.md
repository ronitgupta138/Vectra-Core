# ANN-Benchmarks Standard Evaluation & Verification Protocol

## 1. Standard Datasets
Vectra-Core performance is benchmarked against standard public datasets:
- **SIFT1M:** 1,000,000 vectors, 128 dimensions, Euclidean (L2) distance.
- **GloVe-100:** 1,183,514 vectors, 100 dimensions, Cosine distance.
- **Cohere-768:** 1,000,000 vectors, 768 dimensions, Angular distance.

## 2. Pareto Frontier Metrics
- **Recall@K:** $\frac{|\text{Retrieved}_K \cap \text{GroundTruth}_K|}{K}$
- **Queries Per Second (QPS):** $\frac{\text{Total Queries}}{\text{Elapsed Wall Clock Time}}$
- Pareto frontier curves measure QPS at Recall@10 levels: 0.90, 0.95, 0.98, and 0.99.
