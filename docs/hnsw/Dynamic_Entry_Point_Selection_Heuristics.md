# Dynamic Entry Point Selection Heuristics in Multi-Layer HNSW

## 1. Graph Entrapment Prevention
- Standard HNSW maintains a single global entry point on the top layer.
- Vectra-Core tracks centroid dispersion across high layers, dynamically maintaining multiple entry points to accelerate convergence on skewed vector topologies.
