# Epoch-Based Hazard Pointer Memory Reclamation in HNSW

## 1. Motivation
In concurrent vector indexing, deleting a node while search threads traverse its outgoing edges causes memory segmentation faults or null reference reads.

## 2. Invariants
- Traversal threads register an active read epoch via thread-local counters.
- Deleted nodes are queued in a retirement buffer and only freed when all active search epochs have advanced past the deletion timestamp.
