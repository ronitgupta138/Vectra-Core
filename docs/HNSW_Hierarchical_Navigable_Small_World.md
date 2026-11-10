# HNSW (Hierarchical Navigable Small World) Indexing Specification

## 1. Mathematical Topology
Vectra-Core implements the Malkov & Yashunin HNSW algorithm in native Java 21:
- **Layer Probability Distribution:**
  $$l = \lfloor -\ln(\text{uniform}(0, 1)) \cdot m_L \rfloor \quad \text{where } m_L = \frac{1}{\ln(M)}$$
- **Hyperparameter Guidelines:**
  - $M = 16$: Ideal for general-purpose text embeddings (384–768 dimensions), balancing link memory and recall.
  - $M = 32$–$64$: Recommended for high-dimensional image/multimodal embeddings (1536+ dimensions).
  - $efConstruction = 128$–$256$: Controls index build time vs graph connectivity quality.
  - $efSearch = 64$: Dynamic query beam search budget offering $> 98.5\%$ Recall@10.

## 2. Lock-Free Traversal
Reads traverse entry points down through layer 0 using atomic memory fences (`VarHandle`) without locking global structures.
