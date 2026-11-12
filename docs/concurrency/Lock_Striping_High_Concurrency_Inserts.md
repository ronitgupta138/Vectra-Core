# High-Concurrency HNSW Insertion via Lock Striping Specification

## 1. Lock Contention Problem
Global synchronization on graph layers serializes parallel inserts, bottlenecking multi-threaded ingestion on high-core server systems.

## 2. Hash-Based Striped Locks
Neighbor lists are partitioned across 256 independent `StampedLock` instances:
```java
int stripeIndex = (nodeId * 31) & 0xFF;
StampedLock lock = lockStripes[stripeIndex];
```

## 3. Optimistic Read Invariants
Neighbor routing queries use optimistic read stamps (`tryOptimisticRead()`), falling back to pessimistic locks only when a concurrent node insertion splits the neighbor set.
