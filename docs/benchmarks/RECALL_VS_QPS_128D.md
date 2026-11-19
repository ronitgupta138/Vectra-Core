# HNSW 128-Dimension Recall@10 vs QPS Benchmark Report

## 1. Experimental Setup
- **Dataset:** Synthetic 128-dimensional unit-normalized embeddings ($N = 10,\!000$)
- **Runtime:** OpenJDK 21 LTS 64-Bit Server VM, Project Loom Virtual Threads
- **Hardware:** AMD Ryzen 5 5600H @ 3.3 GHz

## 2. Pareto Frontier
| $efSearch$ | Recall@10 | Throughput (QPS) | Latency P99 |
|---|---|---|---|
| 16 | 0.912 | $16,\!500$ | $0.85\,\text{ms}$ |
| 32 | 0.958 | $12,\!800$ | $1.20\,\text{ms}$ |
| 64 | 0.985 | $9,\!400$ | $2.10\,\text{ms}$ |
| 128 | 0.994 | $5,\!200$ | $3.80\,\text{ms}$ |
