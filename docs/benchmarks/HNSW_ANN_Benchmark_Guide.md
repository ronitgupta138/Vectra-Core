# Recall@K vs QPS Vector Index Benchmarking Methodology

## 1. Standard Dataset Standards
Benchmarks use standard ANN benchmarks (Cohere 768d, SIFT 128d, GloVe 100d):
- **Metrics Evaluated:**
  - `Recall@10 = |GroundTruth \cap Predicted| / 10`
  - Queries Per Second (QPS) under varying concurrency (1 to 64 virtual threads).
  - P50, P95, and P99 latency percentiles.

## 2. Target Performance Profile
- 100,000 vectors (768-dim): QPS $> 12,500$ at Recall@10 $\ge 98.2\%$ with P99 latency $< 4.2$ms.
