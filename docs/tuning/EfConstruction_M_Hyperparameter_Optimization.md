# HNSW Hyperparameter Tuning: efConstruction, M, and efSearch

## 1. Hyperparameter Roles
- **$M$ (Max outgoing edges per node):** Controls graph connectivity and memory consumption. Range: `16` to `64`.
- **$efConstruction$ (Candidate evaluation depth during index build):** Controls index construction quality. Range: `64` to `400`.
- **$efSearch$ (Candidate pool size during query search):** Controls runtime search latency vs accuracy tradeoff. Range: `16` to `256`.

## 2. Recommended Operating Profiles
- **Ultra-Low Latency:** $M = 16, efConstruction = 64, efSearch = 32$ (Sub-1ms search, 92% recall).
- **High Accuracy Enterprise:** $M = 32, efConstruction = 200, efSearch = 128$ (2.5ms search, 98.8% recall).
