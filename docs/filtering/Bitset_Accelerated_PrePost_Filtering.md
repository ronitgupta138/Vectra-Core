# Hybrid Vector Search: Bitset-Accelerated Pre-Filtering Specification

## 1. Filtering Trade-Offs
- **Post-Filtering:** Retrieve top-$k$ nearest neighbors from HNSW and filter metadata afterward. (Fails when metadata predicate selectivity $< 5\%$).
- **Pre-Filtering:** Restrict HNSW graph traversal strictly to nodes satisfying the boolean attribute predicate.

## 2. RoaringBitmap Traversal Acceleration
Allowed document IDs are represented as compressed `RoaringBitmap` bitsets. During graph search:
```java
if (!allowedBitset.contains(candidateNodeId)) {
    continue; // Prune traversal without computing vector distance
}
```

## 3. Dynamic Threshold Crossover
Engine dynamically switches from pre-filtering to post-filtering when bitmap cardinality exceeds $65\%$ of total indexed documents.
