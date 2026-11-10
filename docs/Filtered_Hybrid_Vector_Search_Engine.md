# Filtered Hybrid Vector Search Specification

## 1. Filter Execution Strategies
- **Pre-Filtering (BitSet Filtering):**
  Evaluates boolean SQL/metadata expressions first, producing a compressed Roaring Bitmap of valid document IDs. HNSW traversal visits only nodes passing the bitset filter.
- **Post-Filtering:**
  Retrieves top $K \times \text{oversample}$ candidates from HNSW, filtering metadata afterwards. Efficient when selectivity $> 80\%$.
- **Adaptive Auto-Routing:**
  Dynamically switches between pre-filtering and post-filtering based on catalog metadata selectivity estimates.
